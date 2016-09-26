package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {
    /**
     * 列表
     *
     * @return
     */
    public String list() {

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

        return COMMON_TOLIST;
    }

    /**
     * 删除
     *
     * @return
     */
    public String delete() {

        return COMMON_TOLIST;
    }

    /**
     * 更新页面
     *
     * @return
     */
    public String editUI() {


        return COMMON_SAVEUI;
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
