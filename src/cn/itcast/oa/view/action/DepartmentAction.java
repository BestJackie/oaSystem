package cn.itcast.oa.view.action;

import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    @Autowired
    private DepartmentService departmentService;
    private Long parentId;
    Department model = new Department();

    @Override
    public Department getModel() {
        return model;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 列表
     *
     * @return
     */
    public String list() {
        List<Department> departmentList = departmentService.findAll();
        ActionContext.getContext().put("departmentList", departmentList);
        return "list";
    }

    /**
     * 添加页面
     *
     * @return
     */
    public String addUI() {
        //准备数据
        List<Department> departmentList = departmentService.findAll();
        ActionContext.getContext().put("departmentList", departmentList);
        return "saveUI";
    }

    /**
     * 添加
     *
     * @return
     */
    public String add() {
        Department department = departmentService.findOne(parentId);
        model.setParent(department);
        departmentService.save(model);
        return "toList";
    }

    /**
     * 删除
     *
     * @return
     */
    public String delete() {
        departmentService.delete(model.getId());
        return "toList";
    }

    /**
     * 更新页面
     *
     * @return
     */
    public String editUI() {
        List<Department> departmentList = departmentService.findAll();
        ActionContext.getContext().put("departmentList", departmentList);

        Department department = departmentService.findOne(model.getId());
        ActionContext.getContext().getValueStack().push(department);
//        model.setName(role.getName());
//        model.setDescription(role.getDescription());
        if (department.getParent() != null) {
            parentId = department.getParent().getId();
        }
        return "saveUI";
    }

    /**
     * 更新
     *
     * @return
     */
    public String edit() {
        Department department = departmentService.findOne(model.getId());
        department.setName(model.getName());
        department.setDescription(model.getDescription());
        department.setParent(departmentService.findOne(parentId));
        departmentService.update(department);
        return "toList";
    }

}
