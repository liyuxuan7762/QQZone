package com.atguigu.qqzone.dao.service;

import com.atguigu.qqzone.pojo.HostReply;

public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);
    // 根据replyId删除主人回复
    void deleteHostReplyByReplyId(Integer replyId);
}
