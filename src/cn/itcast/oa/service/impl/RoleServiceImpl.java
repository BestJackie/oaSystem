package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService{
//    @Autowired
//    private RoleDaoSupport roleDao;
//
//    @Override
//    public void update(Role role) {
//        roleDao.update(role);
//    }
//
//    @Override
//    public Role getById(Long id) {
//        return roleDao.getById(id);
//    }
//
//    @Override
//    public void save(Role role) {
//        roleDao.save(role);
//    }
//
//    @Override
//    public void delete(Long id) {
//        roleDao.delete(id);
//    }
//
//    @Override
//    public List<Role> findAll() {
//        return roleDao.findAll();
//    }
}
