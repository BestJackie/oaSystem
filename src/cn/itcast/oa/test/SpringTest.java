package cn.itcast.oa.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

}
