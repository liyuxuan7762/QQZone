package com.atguigu.qqzone.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.qqzone.dao.ReplyDAO;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyList(Topic topic) {
        // 获取到日志Id
        Integer topicId = topic.getId();
        // 根据日志ID查询所有评论
        String sql = "select * from t_reply where topic = ?";
        return super.executeQuery(sql, topicId);
    }

    @Override
    public void deleteReply(Integer id) {
        String sql = "delete from t_reply where id = ?";
        super.executeUpdate(sql, id);
    }

    @Override
    public Reply getReplyByReplyId(Integer replyId) {
        return null;
    }

    @Override
    public void addReply(Reply reply) {
        String sql = "insert into t_reply(content, replyDate, author, topic) values (?, ?, ?, ?)";
        super.executeUpdate(sql, reply.getContent(), reply.getReplyDate(), reply.getAuthor().getId(), reply.getTopic().getId());
    }
}
