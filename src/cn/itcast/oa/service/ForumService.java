package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public interface ForumService extends DaoSupport<Forum> {

    void moveDown(Long id);

    void moveUp(Long id);
}
