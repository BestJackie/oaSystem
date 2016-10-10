package cn.itcast.oa.base;

import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.util.QueryHelper;

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
    PageBean getPageBean(int pageNum,int pageSize,String hql,List<Object> parameters);
    PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
}
