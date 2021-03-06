package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Privilege;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public interface PrivilegeService extends DaoSupport<Privilege> {
    List<Privilege> getTopPrivilegeList();

    Collection<String> getAllPrivilegeUrl();
}
