package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Controller
@Scope("prototype")
public class ForumManagerAction extends BaseAction<Forum> {
    /**
     * 列表
     *
     * @return
     */
    public String list() {
        List<Forum> forumList = forumService.findAll();
        putIntoMap("forumList",forumList);
        return COMMON_LIST;
    }

    /**
     * 添加页面
     *
     * @return
     */
    public String addUI() {
        return COMMON_SAVEUI;
    }

    /**
     * 添加
     *
     * @return
     */
    public String add() {
        forumService.save(model);
        return COMMON_TOLIST;
    }

    /**
     * 删除
     *
     * @return
     */
    public String delete() {
        forumService.delete(model.getId());
        return COMMON_TOLIST;
    }

    /**
     * 更新页面
     *
     * @return
     */
    public String editUI() {
        Forum forum = forumService.getById(model.getId());
        pushIntoValueStack(forum);
        return COMMON_SAVEUI;
    }
    /**
     * 更新页面
     *
     * @return
     */
    public String edit() {
        Forum forum = forumService.getById(model.getId());
        forum.setName(model.getName());
        forum.setDescription(model.getDescription());
        forumService.update(forum);
        return COMMON_TOLIST;
    }
    /**
     * 上移
     *
     * @return
     */
    public String moveUp() {
        forumService.moveUp(model.getId());
        return COMMON_TOLIST;
    }
    /**
     * 下移
     *
     * @return
     */
    public String moveDown() {
        forumService.moveDown(model.getId());
        return COMMON_TOLIST;
    }
}
