package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.service.ReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Service
@Transactional
public class ReplyServiceImpl extends DaoSupportImpl<Reply> implements ReplyService {
}
