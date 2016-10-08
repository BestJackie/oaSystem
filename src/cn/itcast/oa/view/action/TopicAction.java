package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.domain.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {
    private Long forumId;

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public String show() {
        //准备数据 topic
        Topic topic = topicService.getById(model.getId());
        putIntoMap("topic", topic);

//        //准备数据replyList
//        List<Reply> replyList = replyService.findByTopic(topic);
//        putIntoMap("replyList",replyList);

        //准备分页信息
//        PageBean pageBean = replyService.getPageBeanByTopic(pageNum, pageSize, topic);
//        pushIntoValueStack(pageBean);

        String hql = "from Reply r where r.topic =? order by r.postTime ";
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(topic);
        PageBean pageBean = replyService.getPageBean(pageNum,pageSize,hql,parameters);
        pushIntoValueStack(pageBean);
        return SHOW;
    }

    public String add() {
        Forum forum = forumService.getById(forumId);
        //表单中的信息 model中已经封装了title,content
//        model.setTitle(title);
//        model.setContent(content);
        model.setForum(forum);

        //当前直接获取的信息
        User user = getCurrentUser();
        model.setAuthor(user);
        model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
        model.setPostTime(new Date());

        topicService.save(model);
        return TO_SHOW;//新主题的显示页面
    }

    public String addUI() {
        Forum forum = forumService.getById(forumId);
        putIntoMap("forum", forum);
        return "addUI";
    }

}
