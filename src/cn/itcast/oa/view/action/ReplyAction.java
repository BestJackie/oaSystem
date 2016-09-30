package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply>{

    private Long topicId;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * 发表新回复
     * @return
     */
    public String add() {
        //封装
//        model.setTitle(title);
//        model.getContent(content);
        model.setTopic(topicService.getById(topicId));

        model.setAuthor(getCurrentUser());
        model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
        model.setPostTime(new Date());

        replyService.save(model);
        return "toTopicShow";//转到新回复所在的页面
    }

    /**
     * 发表新回复页面
     * @return
     */
    public String addUI(){
        Topic topic = topicService.getById(topicId);
        putIntoMap("topic",topic);
        return "addUI";
    }
}
