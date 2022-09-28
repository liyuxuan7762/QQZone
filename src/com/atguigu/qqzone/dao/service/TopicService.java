package com.atguigu.qqzone.dao.service;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    List<Topic> getTopicList(UserBasic userBasic);
    // 根据ID获取单个日志
    Topic getTopicById(Integer id);

    // 根据id删除日志
    void deleteTopicByTopicId(Integer topicId);
}
