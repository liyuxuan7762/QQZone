package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.dao.service.ReplyService;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import javax.servlet.http.HttpSession;
import java.util.Date;

public class ReplyController {
    private ReplyService replyService = null;

    public String addReply(String content, Integer topicId, HttpSession session) {
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        Reply reply = new Reply(content, new Date(), author, new Topic(topicId));
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&topicId=" + topicId;
    }

    public String deleteReply(Integer replyId, Integer topicId) {
        replyService.deleteReplyByReplyId(replyId);
        return "redirect:topic.do?operate=topicDetail&topicId=" + topicId;
    }
}
