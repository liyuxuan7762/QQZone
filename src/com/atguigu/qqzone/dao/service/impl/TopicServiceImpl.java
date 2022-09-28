package com.atguigu.qqzone.dao.service.impl;

import com.atguigu.qqzone.dao.TopicDAO;
import com.atguigu.qqzone.dao.service.ReplyService;
import com.atguigu.qqzone.dao.service.TopicService;
import com.atguigu.qqzone.dao.service.UserBasicService;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDAO = null;
    private UserBasicService userBasicService = null;
    private ReplyService replyService = null;

    // 查询某一个用户的日志列表
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        // 获取到的topic的author属性只有一个id
        Integer authorId = topic.getAuthor().getId();
        UserBasic author = userBasicService.getUserBasicById(authorId);
        topic.setAuthor(author);
        return topic;
    }
    // 根据Id删除日志
    @Override
    public void deleteTopicByTopicId(Integer topicId) {
        // 删除所有关联的评论
        replyService.deleteAllReplyByTopicId(topicId);
        // 删除topic
        topicDAO.deleteTopic(new Topic(topicId));
    }
}
