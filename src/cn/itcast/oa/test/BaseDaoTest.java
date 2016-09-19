package cn.itcast.oa.test;

import cn.itcast.oa.dao.RoleDao;
import cn.itcast.oa.dao.UserDao;
import cn.itcast.oa.dao.impl.RoleDaoImpl;
import cn.itcast.oa.dao.impl.UserDaoImpl;
import org.junit.Test;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class BaseDaoTest {
    @Test
    public void test(){
        UserDao user = new UserDaoImpl();
        RoleDao role = new RoleDaoImpl();
    }
}
