package cn.itcast.oa.util;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.PageBean;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class QueryHelper {
    private String fromClause;
    private String whereClause;
    private String orderByClause;

    private List<Object> parameters = new ArrayList<Object>();

    /**
     * 生成Form 语句
     *
     * @param clazz
     * @param alias 别名
     */
    public QueryHelper(Class clazz, String alias) {
        fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
    }

    /**
     * 拼接where子句
     *
     * @param condition
     * @param params
     */
    public QueryHelper addCondition(String condition, Object... params) {
        if (whereClause.length() == 0) {
            whereClause = " WHERE " + condition;
        } else {
            whereClause += " AND " + condition;
        }
        //设置参数
        if (params != null) {
            for (Object param : params) {
                parameters.add(param);
            }
        }
        return this;
    }

    public QueryHelper addCondition(boolean append, String condition, Object... params) {
        if (append) {
            addCondition(condition, params);
        }
        return this;
    }

    /**
     * 拼接orderBy子句
     *
     * @param propertyName 属性名
     * @param asc          是否升序
     */
    public QueryHelper addOrderByProperty(String propertyName, boolean asc) {
        if (orderByClause.length() == 0) {
            orderByClause = " ORDER BY " + propertyName + (asc ? " ASC " : " DESC ");
        } else {
            orderByClause += ", " + propertyName + (asc ? " ASC " : " DESC ");
        }
        return this;
    }

    public QueryHelper addOrderByProperty(boolean append, String propertyName, boolean asc) {
        if (append) {
            addOrderByProperty(propertyName, asc);
        }
        return this;
    }

    public String getListQueryHql() {
        return fromClause + whereClause + orderByClause;
    }

    public String getCountQueryHql() {
        return "SELECT COUNT(*) " + fromClause + whereClause;
    }

    /**
     * @return
     */
    public List<Object> getParameters() {
        return parameters;
    }

    public void preparePageBean(DaoSupport<?> service, int pageNum, int pageSize) {
        PageBean pageBean = service.getPageBean(pageNum, pageSize, this);
        ActionContext.getContext().getValueStack().push(pageBean);
    }
}



