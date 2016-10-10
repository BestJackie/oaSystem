package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
//        String hql = "from Topic t where t.forum =? " + "order by (case t.type when 2 then 2 else 0 end ) desc , t.lastUpdateTime desc "; List<Object> parameters = new ArrayList<Object>();
//        parameters.add(forum);
//        PageBean pageBean = topicService.getPageBean(pageNum, pageSize, hql, parameters);
//        pushIntoValueStack(pageBean);


        new QueryHelper(Topic.class, "t")//
                // 过滤条件
                .addCondition("t.forum=?", forum)//
                .addCondition((viewType == 1), "t.type=?", Topic.TYPE_BEST) // 1 表示只看精华帖
                // 排序条件
                .addOrderByProperty((orderBy == 1), "t.lastUpdateTime", asc) // 1 表示只按最后更新时间排序
                .addOrderByProperty((orderBy == 2), "t.postTime", asc) // 2 表示只按主题发表时间排序
                .addOrderByProperty((orderBy == 3), "t.replyCount", asc) // 3 表示只按回复数量排序
                .addOrderByProperty((orderBy == 0), "(CASE t.type WHEN 2 THEN 2 ELSE 0 END)", false)//
                .addOrderByProperty((orderBy == 0), "t.lastUpdateTime", false) // 0 表示默认排序(所有置顶帖在前面，并按最后更新时间降序排列)
                .preparePageBean(topicService, pageNum, pageSize);
        return SHOW;
    }
}