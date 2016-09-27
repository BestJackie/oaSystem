package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Reply;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply>{
    /**
     * 发表新回复
     * @return
     */
    public String add() {
        return "toTopicShow";//转到新回复所在的页面
    }

    /**
     * 发表新回复页面
     * @return
     */
    public String addUI(){
        return "addUI";
    }
}
