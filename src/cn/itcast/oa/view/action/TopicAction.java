package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Topic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {
    public String show(){
        return SHOW;
    }
    public String add(){
        return TO_SHOW;//新主题的显示页面
    }
    public String addUI(){
        return "addUI";
    }

}
