package cn.itcast.oa.test;

import cn.itcast.oa.dao.RoleDaoSupport;
import cn.itcast.oa.dao.UserDaoSupport;
import cn.itcast.oa.dao.impl.RoleDaoSupportImpl;
import cn.itcast.oa.dao.impl.UserDaoSupportImpl;
import org.junit.Test;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class DaoSupportTest {
    @Test
    public void test(){
        UserDaoSupport user = new UserDaoSupportImpl();
        RoleDaoSupport role = new RoleDaoSupportImpl();
    }
}
