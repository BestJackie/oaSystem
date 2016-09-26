package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.ForumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
@Service
@Transactional
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements ForumService {
    @Override
    public List<Forum> findAll() {
        return getSession().createQuery("from Forum f order by f.position")
                .list();
    }

    @Override
    public void save(Forum entity) {
        super.save(entity);
        entity.setPosition(entity.getId().intValue()+1);
    }

    public void moveDown(Long id) {
        //找到相关对象
        Forum forum = getById(id);
        Forum other = (Forum) getSession().createQuery("from Forum f where f.position>:position " +
                "order by f.position asc ")
                .setParameter("position",forum.getPosition())
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResult();
        //交换位置
        int temp = forum.getPosition();
        forum.setPosition(other.getPosition());
        other.setPosition(temp);
        //更新
//        getSession().update(forum);
//        getSession().update(other);
    }

    public void moveUp(Long id) {
        //找到相关对象
        Forum forum = getById(id);
        Forum other = (Forum) getSession().createQuery("from Forum f where f.position<:position " +
                "order by f.position desc ")
                .setParameter("position",forum.getPosition())
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResult();
        //交换位置
        int temp = forum.getPosition();
        forum.setPosition(other.getPosition());
        other.setPosition(temp);
        //更新
//        getSession().update(forum);
//        getSession().update(other);

    }
}
