package com.atguigu.qqzone.dao.service;

import com.atguigu.qqzone.pojo.Reply;

import java.util.List;

public interface ReplyService {
    // 根据日志Id获取所有评论包括主人评论
    List<Reply> getReplyByTopicId(Integer id);

    // 添加评论
    void addReply(Reply reply);

    // 根据id删除评论
    void deleteReplyByReplyId(Integer replyId);

    // 根据replyId获取对应的reply
    Reply getReplyByReplyId(Integer replyId);

    // 根据日志id，删除对应的所有评论
    void deleteAllReplyByTopicId(Integer topicId);
}
