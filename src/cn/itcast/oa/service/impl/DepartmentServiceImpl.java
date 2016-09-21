package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
@Service
@Transactional
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {
//    @Autowired
//    private DepartmentDaoSupport departmentDao;
//    @Autowired
//    private SessionFactory sessionFactory;
//    @Override
//    public List<Department> findAll() {
//        return departmentDao.findAll();
//    }
//
//    @Override
//    public void save(Department model) {
//        departmentDao.save(model);
//    }
//
//    @Override
//    public void delete(Long id) {
//        departmentDao.delete(id);
//    }
//
//    @Override
//    public Department getById(Long id) {
//        return departmentDao.getById(id);
//    }
//
//    @Override
//    public void update(Department department) {
//        departmentDao.update(department);
//    }


    public List<Department> findChildren(Long parentId) {
        return getSession()
                .createQuery("FROM Department d where d.parent.id = ?")
                .setParameter(0,parentId).list();
    }


    public List<Department> findParent() {
        return getSession()
                .createQuery("from Department d where d.parent is null ")
                .list();
    }
}
