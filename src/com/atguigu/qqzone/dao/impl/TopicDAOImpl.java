package com.atguigu.qqzone.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.qqzone.dao.TopicDAO;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        String sql = "select id, title, content, topicDate, author from t_topic where author = ?";
        return super.executeQuery(sql, userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void deleteTopic(Topic topic) {
        String sql = "delete from t_topic where id = ?";
        super.executeUpdate(sql, topic.getId());
    }

    @Override
    public Topic getTopic(Integer id) {
        String sql = "select * from  t_topic where id = ?";
        return super.load(sql, id);
    }
}
