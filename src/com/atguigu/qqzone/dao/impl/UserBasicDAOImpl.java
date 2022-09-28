package com.atguigu.qqzone.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.qqzone.dao.UserBasicDAO;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        String sql = "select id, loginId, nickName, pwd, headImg from t_user_basic where loginId = ? and pwd = ?";
        return super.load(sql, loginId, pwd);
    }

    @Override
    // 获取一个用户的好友列表
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        Integer id = userBasic.getId();
        String sql = "select fid as id from t_friend, t_user_basic where t_friend.uid = t_user_basic.id and t_user_basic.id = ?";
        return super.executeQuery(sql, id);
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        String sql = "select id, loginId, nickName, pwd, headImg from t_user_basic where id = ?";
        return super.load(sql, id);
    }
}
