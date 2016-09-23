package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {
    public List<Privilege> getTopPrivilegeList() {
        return getSession().createQuery(
                "from Privilege p where p.parent is null ")
                .list();
    }

    public Collection<String> getAllPrivilegeUrl() {
        return getSession().createQuery(
                "select distinct p.url from Privilege p where p.url is not null "
        ).list();
    }
}
