package cn.itcast.oa.test;

import cn.itcast.oa.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
@Service
public class TestService {
    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public void saveTwoUser(){
        Session session = sessionFactory.getCurrentSession();
        session.save(new User());
//        int i = 1/0;
        session.save(new User());
    }
}
