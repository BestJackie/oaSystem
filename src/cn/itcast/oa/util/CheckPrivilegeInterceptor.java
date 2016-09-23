package cn.itcast.oa.util;

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
        System.out.println("zhiqian");
        String result = actionInvocation.invoke();
        System.out.println("zhihou");
        return result;
    }
}
