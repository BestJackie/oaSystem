package cn.itcast.oa.view.action;

import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role> {
    @Autowired
    private RoleService roleService;


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

    /**
     * 列表
     *
     * @return
     */
    public String list() {
        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList", roleList);
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
        Role role = roleService.findOne(model.getId());
        ActionContext.getContext().getValueStack().push(role);
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
        Role role = roleService.findOne(model.getId());
        role.setName(model.getName());
        role.setDescription(model.getDescription());
        roleService.update(role);
        return "toList";
    }

    Role model = new Role();

    @Override
    public Role getModel() {
        return model;
    }
}
