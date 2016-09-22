package cn.itcast.oa.view.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport {

    public String index(){
        return "index";
    }
    public String top(){
        return "top";
    }
    public String bottom(){
        return "bottom";
    }
    public String left(){
        return "left";
    }
    public String right(){
        return "right";
    }

}
