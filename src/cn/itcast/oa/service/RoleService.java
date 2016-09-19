package cn.itcast.oa.service;

import cn.itcast.oa.domain.Role;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public interface RoleService {
    List<Role> findAll();

    void delete(Long id);

    void save(Role role);

    Role findOne(Long id);

    void update(Role role);
}
