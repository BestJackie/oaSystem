package cn.itcast.oa.base;

import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.util.QueryHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
@Transactional
public class DaoSupportImpl<T> implements DaoSupport<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    protected Class<T> clazz;

    public DaoSupportImpl() {
        //使用反射技术得到T的真实类型
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();//获取当前new的对象泛型的父类
        this.clazz = (Class<T>) type.getActualTypeArguments()[0];
//        System.out.println("clazz------>"+clazz);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(T entity) {
        this.getSession().save(entity);
    }

    public void delete(Long id) {
        Object obj = getById(id);
        if (obj != null) getSession().delete(obj);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public T getById(Long id) {
        if (id == null)
            return null;
        return (T) getSession().get(clazz, id);
    }

    public List<T> getByIds(Long[] ids) {
        if (ids == null || ids.length == 0) {
            return Collections.EMPTY_LIST;
        } else {
            return getSession().createQuery(//
                    "FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
                    .setParameterList("ids", ids)//
                    .list();
        }
    }

    public List<T> findAll() {
        return getSession().createQuery(//
                "FROM " + clazz.getSimpleName())//
                .list();
    }

    /**
     * @param pageNum
     * @param pageSize
     * @param hql
     * @param parameters
     * @return
     */
    public PageBean getPageBean(int pageNum, int pageSize, String hql, List<Object> parameters) {
        Query listQuery = getSession().createQuery(hql);
        if (parameters.size() != 0) {//设置参数
            for (int i = 0; i < parameters.size(); i++) {
                listQuery.setParameter(i, parameters.get(i));
            }
        }
        listQuery.setFirstResult((pageNum - 1) * pageSize);
        listQuery.setMaxResults(pageSize);
        List list = listQuery.list();

        Query countQuery = getSession().createQuery("select count (*) from " + hql);
        if (parameters.size() != 0) {//设置参数
            for (int i = 0; i < parameters.size(); i++) {
                countQuery.setParameter(i, parameters.get(i));
            }
        }
        Long count = (Long) countQuery.uniqueResult();
        return new PageBean(pageSize, pageNum, list, count.intValue());
    }

    /**
     * 公共的查询分页信息的方法（最终版）
     *
     * @param pageNum
     * @param pageSize
     * @param queryHelper HQL语句与参数列表
     * @return
     */
    public PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper) {
        System.out.println("-------> DaoSupportImpl.getPageBean( int pageNum, int pageSize, QueryHelper queryHelper )");
        List<Object> parameters = queryHelper.getParameters();
        Query listQuery = getSession().createQuery(queryHelper.getListQueryHql());
        if (parameters.size() != 0) {
            for (int i = 0; i < parameters.size(); i++) {
                Object o = parameters.get(i);
                listQuery.setParameter(i, o);
            }
        }
        listQuery.setFirstResult((pageNum - 1) * pageSize);
        listQuery.setMaxResults(pageSize);
        List list = listQuery.list();
        //数量查询
        Query countQuery = getSession().createQuery(queryHelper.getCountQueryHql());
        if (parameters.size() != 0) {
            for (int i = 0; i < parameters.size(); i++) {
                Object o = parameters.get(i);
                countQuery.setParameter(i, o);
            }
        }
        Long count = (Long) countQuery.uniqueResult();
        return new PageBean(pageSize, pageNum, list, count.intValue());
    }
}
