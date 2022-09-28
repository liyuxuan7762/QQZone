package com.atguigu.qqzone.dao.service.impl;

import com.atguigu.qqzone.dao.UserBasicDAO;
import com.atguigu.qqzone.dao.impl.UserBasicDAOImpl;
import com.atguigu.qqzone.dao.service.UserBasicService;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.ArrayList;
import java.util.List;

public class UserBasicServiceImpl implements UserBasicService {
    UserBasicDAO userBasicDAO = null;
    @Override
    public UserBasic login(String loginId, String pwd) {
        return userBasicDAO.getUserBasic(loginId, pwd);
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicList = userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList = new ArrayList<>(userBasicList.size());
        for(UserBasic friend : userBasicList) {
            Integer id = friend.getId();
            friend = userBasicDAO.getUserBasicById(id);
            friendList.add(friend);
        }
        return friendList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return userBasicDAO.getUserBasicById(id);
    }
}
