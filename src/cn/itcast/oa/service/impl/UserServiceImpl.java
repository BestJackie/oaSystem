package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{
    public User findByLoginNameAndPassword(String loginName, String passWord) {
        String MD5passWord = DigestUtils.md5Hex(passWord);
        return (User) getSession().createQuery("from User u where " +
                "u.loginName=:loginName and u.passWord=:MD5passWord")
                .setParameter("loginName",loginName)
                .setParameter("MD5passWord",MD5passWord)
                .uniqueResult();
    }
}
