package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
@Controller
@Scope("prototype")
public class HomeAction extends BaseAction{

    public String index(){
        return HOME_INDEX;
    }
    public String top(){
        return HOME_TOP;
    }
    public String bottom(){
        return HOME_BOTTOM;
    }
    public String left(){
        return HOME_LEFT;
    }
    public String right(){
        return HOME_RIGHT;
    }

}
