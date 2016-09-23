package cn.itcast.oa.util;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Collection;
import java.util.List;

/**
 * 准备权限数据
 * Created by Administrator on 2016/9/22 0022.
 */
public class InitListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        PrivilegeService privilegeService = (PrivilegeService)applicationContext.getBean("privilegeServiceImpl");
        //获取权限列表
        List<Privilege> topPrivilegeList = privilegeService.getTopPrivilegeList();
        servletContextEvent.getServletContext().setAttribute("topPrivilegeList",topPrivilegeList);
        //获取权限的Url
        Collection<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrl();
        servletContextEvent.getServletContext().setAttribute("allPrivilegeUrls",allPrivilegeUrls);


    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
