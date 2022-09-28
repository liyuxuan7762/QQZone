package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.dao.service.TopicService;
import com.atguigu.qqzone.dao.service.UserBasicService;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController {

    private UserBasicService userBasicService = null;
    private TopicService topicService = null;
    // 用户登录方法
    public String login(String loginId, String pwd, HttpSession session) {
        // 调用登录方法
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if(userBasic == null) {
            // 如果用户名密码不对
            return "login";
        }
        // 获取该用户所有的日志和好友列表
        List<Topic> topicList = topicService.getTopicList(userBasic);
        List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
        // 将列表保存到userBasic中
        userBasic.setTopicList(topicList);
        userBasic.setFriendList(friendList);
        // 保存用户对象到session
        session.setAttribute("userBasic", userBasic);
        session.setAttribute("friend", userBasic);
        return "index";
    }

    // 实现用户点击某一个好友连接，获取该好友所有信息
    public String friend(Integer id, HttpSession session) {
        UserBasic userBasic = userBasicService.getUserBasicById(id);
        // 获取这个用户所有的日志
        List<Topic> topicList = topicService.getTopicList(userBasic);
        userBasic.setTopicList(topicList);
        // 讲信息存入session
        session.setAttribute("friend", userBasic);
        // 跳转到index
        return "index";
    }
}
