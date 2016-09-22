package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
    //    private Long id;
//
//    private String name;
//
//    private String description;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
    private Long privilegeId;
    private Long[] privilegeIds;

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    public Long[] getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(Long[] privilegeIds) {
        this.privilegeIds = privilegeIds;
    }

    /**
     * 列表
     *
     * @return
     */
    public String list() {
        List<Role> roleList = roleService.findAll();
        putIntoMap("roleList", roleList);
        return "list";
    }

    /**
     * 添加页面
     *
     * @return
     */
    public String addUI() {
        return "saveUI";
    }

    /**
     * 添加
     *
     * @return
     */
    public String add() {

        roleService.save(model);
        return "toList";
    }

    /**
     * 删除
     *
     * @return
     */
    public String delete() {
        roleService.delete(model.getId());
        return "toList";
    }

    /**
     * 更新页面
     *
     * @return
     */
    public String editUI() {
        Role role = roleService.getById(model.getId());
        pushIntoValueStack(role);
//        model.setName(role.getName());
//        model.setDescription(role.getDescription());
        return "saveUI";
    }

    /**
     * 更新
     *
     * @return
     */
    public String edit() {
        Role role = roleService.getById(model.getId());
        role.setName(model.getName());
        role.setDescription(model.getDescription());
        roleService.update(role);
        return "toList";
    }

//    Role model = new Role();
//
//    @Override
//    public Role getModel() {
//        return model;
//    }

    /**
     * 设置权限页面
     *
     * @return
     */
    public String setPrivilegeUI() {
        //显示权限列表
        Role role = roleService.getById(model.getId());
        pushIntoValueStack(role);
        //回写数据
        if (role.getPrivileges() != null) {
            privilegeIds = new Long[role.getPrivileges().size()];
            int index = 0;
            for (Privilege p : role.getPrivileges()) {
                privilegeIds[index++] = p.getId();
            }
        }
        List<Privilege> privilegeList = privilegeService.findAll();
        putIntoMap("privilegeList",privilegeList);
        return "setPrivilegeUI";
    }

    /**
     * 设置权限
     *
     * @return
     */
    public String setPrivilege() {
        //1、找到修改数据role对象
        Role role = roleService.getById(model.getId());
        //2、设置权限
        List<Privilege> privileges = privilegeService.getByIds(privilegeIds);
        role.setPrivileges(new HashSet<Privilege>(privileges));
        //3、保存修改后的role
        roleService.update(role);
        return "toList";
    }


}
