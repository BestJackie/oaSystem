package cn.itcast.oa.view.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport{
    public static final String HOME_INDEX = "index";
    public static final String HOME_RIGHT = "right";
    public static final String HOME_TOP = "top";
    public static final String HOME_BOTTOM = "bottom";
    public static final String HOME_LEFT = "left";

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
