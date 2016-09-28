package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.util.DepartmentUtils;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
    private Long departmentId;

    private Long[] roleIds;

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 列表
     *
     * @return
     */
    public String list() {
        List<User> userList = userService.findAll();
        putIntoMap("userList", userList);
        return COMMON_LIST;
    }

    /**
     * 添加页面
     *
     * @return
     */
    public String addUI() {
        //查找部门列表
        List<Department> parentList = departmentService.findParent();
        List<Department> departmentList = DepartmentUtils.getAllDepartments(parentList);
        putIntoMap("departmentList", departmentList);
        //查找role列表
        List<Role> roleList = roleService.findAll();
        putIntoMap("roleList", roleList);
        return COMMON_SAVEUI;
    }

    /**
     * 添加
     *
     * @return
     */
    public String add() {
        //将数据封装到对象中（当model是寻常实体时，可以使用model，但是需要封装默认数据）
        //设置所属部门
        Department department = departmentService.getById(departmentId);
        model.setDepartment(department);
        //设置关联岗位
//        Set<Role> roles = new HashSet<Role>();
//        for (int i = 0; i < roleIds.length; i++) {
//            Long roleId = roleIds[i];
//            Role role = roleService.getById(roleId);
//            roles.add(role);
//        }
        List<Role> roles = roleService.getByIds(roleIds);
        model.setRoles(new HashSet<Role>(roles));
        //reset password(使用MD5摘要);
        String password = DigestUtils.md5Hex("1234");
        model.setPassword(password);
        userService.save(model);
        return COMMON_TOLIST;
    }

    /**
     * 删除
     *
     * @return
     */
    public String delete() {
        userService.delete(model.getId());
        return COMMON_TOLIST;
    }

    /**
     * 更新页面
     *
     * @return
     */
    public String editUI() {
        //显示部门列表
        List<Department> parentList = departmentService.findParent();
        List<Department> departmentList = DepartmentUtils.getAllDepartments(parentList);
        putIntoMap("departmentList", departmentList);
        //查找role列表
        List<Role> roleList = roleService.findAll();
        putIntoMap("roleList", roleList);
        //回写数据
        User user = userService.getById(model.getId());
        pushIntoValueStack(user);
        //回写部门
        if (user.getDepartment() != null)
            departmentId = user.getDepartment().getId();
        //回写roles
        if (user.getRoles() != null)
            roleIds = new Long[user.getRoles().size()];
        int index = 0;
        for (Role role : user.getRoles()) {
            roleIds[index++] = role.getId();
        }
        return COMMON_SAVEUI;
    }

    /**
     * 更新
     *
     * @return
     */
    public String edit() {
        //1、找到修改数据User对象
        User user = userService.getById(model.getId());
        //2、设置修改数据
        user.setLoginName(model.getLoginName());
        user.setName(model.getName());
        user.setDescription(model.getDescription());
        user.setEmail(model.getEmail());
        user.setGender(model.getGender());
        user.setPhoneNumber(model.getPhoneNumber());
        Department department = departmentService.getById(departmentId);
        user.setDepartment(department);
        List<Role> roles = roleService.getByIds(roleIds);
        user.setRoles(new HashSet<Role>(roles));
        //3、保存修改后的user
        userService.update(user);
        return COMMON_TOLIST;
    }

    /**
     * 重置密码
     *
     * @return
     */
    public String initPassword() {
        User user = userService.getById(model.getId());
        String password = DigestUtils.md5Hex("1234");
        user.setPassword(password);
        userService.update(user);
        return COMMON_TOLIST;
    }

    /**
     * 登录界面
     *
     * @return
     */
    public String loginUI() {
        return LOGINUI;
    }

    /**
     * 登录
     *
     * @return
     */
    public String login() {
        if (model.getLoginName() == null) {
            addFieldError("login", "登陆名不能为空");
            return LOGINUI;
        }
        if (model.getPassword() == null) {
            addFieldError("password", "密码不能为空");
            return LOGINUI;
        }
        User user = userService.findByLoginNameAndPassword(model.getLoginName(), model.getPassword());
        if (user == null) {
            addFieldError("login", "登陆名或密码错误");
            return LOGINUI;
        }
        ActionContext.getContext().getSession().put("user", user);
        return TO_INDEX;
    }

    /**
     * 注销
     *
     * @return
     */
    public String logout() {
        ActionContext.getContext().getSession().remove("user");
        return LOGOUT;
    }

}
