package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Service
@Transactional
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements TopicService {
    public List<Topic> findByForum(Forum forum) {
        return getSession().createQuery(
                //排序，所有置顶帖在最上面，并按最后更新时间排序
                //Todo 怎么排序？
                // FIXME: 2016/9/27 0027 怎么排序
                "from Topic t where t.forum = :forum " +
                        "order by t.type desc , t.lastUpdateTime desc ")
                .setParameter("forum",forum)
                .list();
    }
}
