package cn.itcast.oa.service;

import cn.itcast.oa.domain.Department;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public interface DepartmentService {
    public List<Department> findAll();

    void save(Department model);

    void delete(Long id);

    Department findOne(Long id);

    void update(Department department);
}
