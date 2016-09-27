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
    public String list(){
        return COMMON_LIST;
    }

    public String show(){
        return SHOW;
    }
}
