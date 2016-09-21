package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{
}
