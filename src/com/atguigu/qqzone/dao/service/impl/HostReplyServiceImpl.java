package com.atguigu.qqzone.dao.service.impl;

import com.atguigu.qqzone.dao.HostReplyDAO;
import com.atguigu.qqzone.dao.service.HostReplyService;
import com.atguigu.qqzone.pojo.HostReply;

public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;

    // 根据评论的id查询主人回复
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyByReplyId(replyId);
    }

    @Override
    public void deleteHostReplyByReplyId(Integer replyId) {
        hostReplyDAO.deleteHostReplyByReplyId(replyId);
    }

}
