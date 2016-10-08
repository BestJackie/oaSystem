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
    @Deprecated
    public List<Topic> findByForum(Forum forum) {
        return getSession().createQuery(
                //排序，所有置顶帖在最上面，并按最后更新时间排序
                "from Topic t where t.forum =? " +
                        "order by (case t.type when 2 then 2 else 0 end ) desc , t.lastUpdateTime desc ")
                .setParameter(0, forum)
                .list();
    }

    @Override
    public void save(Topic entity) {
        //业务方法中
        entity.setType(Topic.TYPE_NORMAL);//默认为普通贴
        entity.setReplyCount(0);//默认0
        entity.setLastReply(null);//默认null
        entity.setLastUpdateTime(entity.getPostTime());//默认
        getSession().save(entity);

        //维护特殊属性
        Forum forum = entity.getForum();
        forum.setTopicCount(forum.getTopicCount()+1);
        forum.setArticleCount(forum.getArticleCount()+1);
        forum.setLastTopic(entity);
        getSession().update(forum);


    }

//    public PageBean getPageBeanByForum(int pageNum, int pageSize,Forum forum) {
//        Long count = (Long)getSession().createQuery("select count(*) from Topic t " +
//                "where t.forum =? ")
//                .setParameter(0,forum)
//                .uniqueResult();
//        List<Reply> list = getSession().createQuery( "from Topic t where t.forum =? " +
//                "order by (case t.type when 2 then 2 else 0 end ) desc , t.lastUpdateTime desc ")
//                .setParameter(0, forum)
//                .setFirstResult((pageNum-1)*pageSize)
//                .setMaxResults(pageSize)
//                .list();
//        return new PageBean(pageSize,pageNum,list,count.intValue());
//    }
}
