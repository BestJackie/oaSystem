package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Department;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public interface DepartmentService extends DaoSupport<Department>{
//    List<Department> findAll();
//
//    void save(Department model);
//
//    void delete(Long id);
//
//    Department getById(Long id);
//
//    void update(Department department);

    List<Department> findChildren(Long parentId);

    /**
     * 查询顶级部门
     * @return
     */
    List<Department> findParent();
}
