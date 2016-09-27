package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {
    public String list(){
        List<Forum> forumList = forumService.findAll();
        putIntoMap("forumList",forumList);
        return COMMON_LIST;
    }

    public String show(){
        //准备数据
        Forum forum = forumService.getById(model.getId());
        pushIntoValueStack(forum);
        //准备数据 主题列表
        List<Topic> topicList = topicService.findByForum(forum);
        putIntoMap("topicList",topicList);

        return SHOW;
    }
}
