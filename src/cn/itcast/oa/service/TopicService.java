package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public interface TopicService extends DaoSupport<Topic> {

    /**
     * 注定板块中的所有主题并排序 置顶帖在最上面，之后是最新的在最上面
     * @param forum
     * @return
     */
    List<Topic> findByForum(Forum forum);
}
