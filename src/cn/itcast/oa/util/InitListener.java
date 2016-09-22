package cn.itcast.oa.util;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */

public class InitListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        PrivilegeService privilegeService = (PrivilegeService)applicationContext.getBean("privilegeServiceImpl");
        List<Privilege> topPrivilegeList = privilegeService.getTopPrivilegeList();
        servletContextEvent.getServletContext().setAttribute("topPrivilegeList",topPrivilegeList);

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
