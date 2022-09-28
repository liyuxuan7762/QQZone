package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ReplyDAO {
    // 根据日志获取回复列表
    List<Reply> getReplyList(Topic topic);
    // 添加回复
    void addReply(Reply reply);
    // 删除回复
    void deleteReply(Integer id);
    // 根据id获取reply
    Reply getReplyByReplyId(Integer replyId);
}
