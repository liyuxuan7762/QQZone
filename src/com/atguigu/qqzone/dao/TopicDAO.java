package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicDAO {
    // 根据用户获取日志列表
    List<Topic> getTopicList(UserBasic userBasic);
    // 添加日志
    void addTopic(Topic topic);
    // 删除日志
    void deleteTopic(Topic topic);
    // 通过id查询日志
    Topic getTopic(Integer id);

}
