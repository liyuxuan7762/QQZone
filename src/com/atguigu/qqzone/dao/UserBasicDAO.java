package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicDAO {
    // 根据用户名和密码获取用户基本信息
    UserBasic getUserBasic(String loginId, String pwd);
    // 获取好友列表
    List<UserBasic> getUserBasicList(UserBasic userBasic);

    UserBasic getUserBasicById(Integer id);

}
