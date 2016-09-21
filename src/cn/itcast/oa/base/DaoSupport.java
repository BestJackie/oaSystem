package cn.itcast.oa.base;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public interface DaoSupport<T> {
    void save(T entity);
    void delete(Long id);
    void update(T entity);
    T getById(Long id);
    List<T> getByIds(Long[] ids);
    List<T> findAll();
}
