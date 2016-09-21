package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.util.DepartmentUtils;
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
        putIntoMap("userList",userList);
        return "list";
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
        putIntoMap("departmentList",departmentList);
        //查找role列表
        List<Role> roleList = roleService.findAll();
        putIntoMap("roleList",roleList);
        return "saveUI";
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
        //reset password;
        model.setPassWord("1234");
        userService.save(model);
        return "toList";
    }

    /**
     * 删除
     *
     * @return
     */
    public String delete() {
        userService.delete(model.getId());
        return "toList";
    }

    /**
     * 更新页面
     *
     * @return
     */
    public String editUI() {

        return "saveUI";
    }

    /**
     * 更新
     *
     * @return
     */
    public String edit() {

        return "toList";
    }

    /**
     * 重置密码
     *
     * @return
     */
    public String resetPassWord() {

        return "toList";
    }



}
