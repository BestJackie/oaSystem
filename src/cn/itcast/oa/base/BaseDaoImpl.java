package cn.itcast.oa.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Resource
    private SessionFactory sessionFactory;
    private Class<T> clazz;

    public BaseDaoImpl() {
        //使用反射技术得到T的真实类型
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();//获取当前new的对象泛型的父类
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
        return (T) getSession().get(clazz,id);
    }

    public List<T> getByIds(Long[] ids) {
        return getSession().createQuery(
                "FROM User WHERE id in (:ids)").setParameter("ids",ids).list();
    }

    public List<T> findAll() {
        return getSession().createQuery(//
                    "FROM " + clazz.getSimpleName())//
                        .list();
    }
}
