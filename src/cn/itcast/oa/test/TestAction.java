package cn.itcast.oa.test;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
@Component
@Scope("prototype")
public class TestAction extends ActionSupport {
//    @Autowired
//    private TestService testService;
    public String execute() throws Exception {
        System.out.println("execute success");
//        testService.saveTwoUser();
        return "success";
    }
}
