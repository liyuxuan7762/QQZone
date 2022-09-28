package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.HostReply;

public interface HostReplyDAO {
    // 通过replyId查找对应的主人回复
    HostReply getHostReplyByReplyId(Integer replyId);
    // 根据replyId删除主人回复
    void deleteHostReplyByReplyId(Integer replyId);
}
