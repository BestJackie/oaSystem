package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public interface ReplyService extends DaoSupport<Reply> {
    List<Reply> findByTopic(Topic topic);
}
