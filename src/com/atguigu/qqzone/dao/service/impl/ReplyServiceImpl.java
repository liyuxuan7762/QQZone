package com.atguigu.qqzone.dao.service.impl;

import com.atguigu.qqzone.dao.ReplyDAO;
import com.atguigu.qqzone.dao.service.HostReplyService;
import com.atguigu.qqzone.dao.service.ReplyService;
import com.atguigu.qqzone.dao.service.UserBasicService;
import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;
    @Override
    public List<Reply> getReplyByTopicId(Integer topicId) {
        // 获取到所有的评论
        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicId));
        // 遍历所有的评论，如果有主人回复，则添加上去
        for(Reply reply : replyList) {
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);
            // 2.关联主人回复
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void deleteReplyByReplyId(Integer replyId) {
        // 1.根据replyId查询到对应的hostReply 如果查找到了，说明reply有主人回复
        // 则应该先删除主人回复
        HostReply hostReply = hostReplyService.getHostReplyByReplyId(replyId);
        // 2.判断reply是否有主人回复 如果有则删除主人回复
        if(hostReply != null) {
            // 删除主人回复
            hostReplyService.deleteHostReplyByReplyId(replyId);
        }
        // 3.删除reply
        replyDAO.deleteReply(replyId);
    }

    @Override
    public Reply getReplyByReplyId(Integer replyId) {
        return replyDAO.getReplyByReplyId(replyId);
    }

    @Override
    public void deleteAllReplyByTopicId(Integer topicId) {
        // 获取到日志对应的评论列表
        List<Reply> replyList = this.getReplyByTopicId(topicId);
        if(replyList != null) {
            for(Reply reply : replyList) {
                this.deleteReplyByReplyId(reply.getId());
            }
        }
    }



}
