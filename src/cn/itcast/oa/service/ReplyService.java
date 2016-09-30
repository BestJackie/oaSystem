package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public interface ReplyService extends DaoSupport<Reply> {

    /**
     * 查看所有回复，按时间升序排序
     * @param topic
     * @return
     */List<Reply> findByTopic(Topic topic);

    PageBean getPageBeanByTopic(int pageNum, int pageSize, Topic topic);
}
