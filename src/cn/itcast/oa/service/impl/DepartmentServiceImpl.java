package cn.itcast.oa.service.impl;

import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public void save(Department model) {
        departmentDao.save(model);
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);
    }

    @Override
    public Department findOne(Long id) {
        return departmentDao.getById(id);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public List<Department> findChildren(Long parentId) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Department d where d.parent.id = ?")
                .setParameter(0,parentId).list();
    }

    @Override
    public List<Department> findParent() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Department d where d.parent is null ")
                .list();
    }
}
