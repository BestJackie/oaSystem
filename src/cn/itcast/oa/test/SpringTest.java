package cn.itcast.oa.test;

import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.RoleService;
import cn.itcast.oa.service.UserService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
public class SpringTest {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void springTest(){
       TestAction testAction = (TestAction) applicationContext.getBean("testAction");
        System.out.println(testAction);
    }
    @Test
    public void sessionFactoryTest(){
        SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
        System.out.println(sessionFactory);
    }
    @Test
    public void testTranctionManager(){
        TestService testService = (TestService)applicationContext.getBean("testService");
        testService.saveTwoUser();
    }
    @Test
    public void serviceTest(){
        RoleService roleService =(RoleService)applicationContext.getBean("roleServiceImpl");
        List<Role> list= roleService.findAll();
        for(Role role:list){
            System.out.println(role.getName());
        }
    }
    @Test
    public void testLogin(){
        UserService userService = (UserService)applicationContext.getBean("userServiceImpl");
        User user =  userService.findByLoginNameAndPassword("qwqwqw","1234");
        System.out.println(user.getName());
    }


}
