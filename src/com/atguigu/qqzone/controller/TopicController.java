package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.dao.service.ReplyService;
import com.atguigu.qqzone.dao.service.TopicService;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import javax.servlet.http.HttpSession;
import java.util.List;


public class TopicController {

    private TopicService topicService;
    private ReplyService replyService;

    public String topicDetail(Integer topicId, HttpSession session) {
        // 从replyService中获取某一日志的所有评论
        Topic topic = topicService.getTopicById(topicId);
        List<Reply> replyList = replyService.getReplyByTopicId(topicId);
        topic.setReplyList(replyList);
        session.setAttribute("topic",  topic);
        return "frames/detail";
    }

    public String deleteTopic(Integer topicId) {
        topicService.deleteTopicByTopicId(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }

    public String getTopicList(HttpSession session) {
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        List<Topic> topicList = topicService.getTopicList(userBasic);
        userBasic.setTopicList(topicList);
        session.setAttribute("friend", userBasic);

        return "frames/main";
    }
}
