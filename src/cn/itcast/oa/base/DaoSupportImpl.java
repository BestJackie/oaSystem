package cn.itcast.oa.base;

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
}
