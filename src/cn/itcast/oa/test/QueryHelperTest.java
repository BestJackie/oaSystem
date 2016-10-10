package cn.itcast.oa.test;

import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.util.QueryHelper;
import org.junit.Test;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class QueryHelperTest {
    /**
     * 0 表示查看全部主题<br>
     * 1 表示只看精华帖
     */
    private int viewType = 1;
    /**
     * 0 表示默认排序(所有置顶帖在前面，并按最后更新时间降序排列)<br>
     * 1 表示只按最后更新时间排序<br>
     * 2 表示只按主题发表时间排序<br>
     * 3 表示只按回复数量排序
     */
    private int orderBy;
    /**
     * true 表示升序<br>
     * false 表示降序
     */
    private boolean asc = false;

    private Forum forum = new Forum();

    @Test
    public void testQueryHelper() {
        QueryHelper queryHelper = new QueryHelper(Topic.class, "t")//
                // 过滤条件
                .addCondition("t.forum=?", forum)//
                .addCondition((viewType == 1), "t.type=?", Topic.TYPE_BEST) // 1 表示只看精华帖
                // 排序条件
                .addOrderByProperty((orderBy == 1), "t.lastUpdateTime", asc) // 1 表示只按最后更新时间排序
                .addOrderByProperty((orderBy == 2), "t.postTime", asc) // 2 表示只按主题发表时间排序
                .addOrderByProperty((orderBy == 3), "t.replyCount", asc) // 3 表示只按回复数量排序
                .addOrderByProperty((orderBy == 0), "(CASE t.type WHEN 2 THEN 2 ELSE 0 END)", false)//
                .addOrderByProperty((orderBy == 0), "t.lastUpdateTime", false) // 0 表示默认排序(所有置顶帖在前面，并按最后更新时间降序排列)
                ;

        System.out.println(queryHelper.getListQueryHql());
        System.out.println(queryHelper.getCountQueryHql());
        System.out.println(queryHelper.getParameters());
    }

}
