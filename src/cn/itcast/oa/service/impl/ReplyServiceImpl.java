package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.ReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Service
@Transactional
public class ReplyServiceImpl extends DaoSupportImpl<Reply> implements ReplyService {
    public PageBean getPageBeanByTopic(int pageNum, int pageSize, Topic topic) {
        Long count = (Long)getSession().createQuery("from Reply r " +
                "where r.topic =? ")
                .setParameter(0,topic)
                .uniqueResult();
        List<Reply> list = getSession().createQuery("from Reply r " +
                "where r.topic =? order by r.postTime ")
                .setParameter(0,topic)
                .setFirstResult((pageNum-1)*pageSize)
                .setMaxResults(pageSize)
                .list();
        return new PageBean(pageSize,pageNum,list,count.intValue());
    }

    public List<Reply> findByTopic(Topic topic) {
        return getSession().createQuery("from Reply r " +
                "where r.topic =? order by r.postTime ")
                .setParameter(0,topic)
                .list();
    }

    @Override
    public void save(Reply reply) {
        //保存
        super.save(reply);
        //维护相关的主题
        Topic topic = reply.getTopic();
        topic.setReplyCount(topic.getReplyCount()+1);
        topic.setLastReply(reply);
        topic.setLastUpdateTime(reply.getPostTime());

        Forum forum = topic.getForum();
        forum.setTopicCount(forum.getTopicCount()+1);
        forum.setArticleCount(forum.getArticleCount()+1);
        forum.setLastTopic(topic);
        getSession().update(topic);
        getSession().update(forum);
    }
}
