package cn.itcast.oa.util;

import cn.itcast.oa.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class CheckPrivilegeInterceptor implements Interceptor {
    public void destroy() {

    }

    public void init() {

    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {
//        System.out.println("zhiqian");
//        String result = actionInvocation.invoke();
//        System.out.println("zhihou");
//        return result;
        //获取当前登录用户
        User user = (User) ActionContext.getContext().getSession().get("user");
        String namespace = actionInvocation.getProxy().getNamespace();
        String actionName = actionInvocation.getProxy().getActionName();
        String privUrl = namespace + actionName;
        //如果未登录，跳转登录界面
        if (user == null) {
            //如果是登陆请求就放行
            if (privUrl.startsWith("/user_login"))
                actionInvocation.invoke();
            return "loginUI";
        }
        //如果已经登陆
        //如果有权限 放行
        if (user.hasPrivilegeByUrl(privUrl))
            actionInvocation.invoke();
        //如果没有权限就转到没有权限界面
        return "error";
    }
}
