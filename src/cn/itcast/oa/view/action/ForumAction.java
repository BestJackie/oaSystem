package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {
    public String list() {
        List<Forum> forumList = forumService.findAll();
        putIntoMap("forumList", forumList);
        return COMMON_LIST;
    }

    public String show() {
        // 准备数据：forum
        Forum forum = forumService.getById(model.getId());
        putIntoMap("forum", forum);
        //准备数据 主题列表
//        List<Topic> topicList = topicService.findByForum(forum);
//        putIntoMap("recordList", topicList);

//        PageBean pageBean = topicService.getPageBeanByForum(pageNum, pageSize, forum);
        String hql = "from Topic t where t.forum =? order by (case t.type when 2 then 2 else 0 end ) desc , t.lastUpdateTime desc ";
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(forum);
        PageBean pageBean = topicService.getPageBean(pageNum, pageSize, hql, parameters);
        pushIntoValueStack(pageBean);
        return SHOW;
    }
}
