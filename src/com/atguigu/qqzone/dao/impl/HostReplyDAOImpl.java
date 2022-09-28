package com.atguigu.qqzone.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.qqzone.dao.HostReplyDAO;
import com.atguigu.qqzone.pojo.HostReply;

public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        String sql = "select * from t_host_reply where reply = ?";
        return super.load(sql, replyId);
    }

    @Override
    public void deleteHostReplyByReplyId(Integer replyId) {
        String sql = "delete from t_host_reply where reply = ?";
        super.executeUpdate(sql, replyId);
    }
}
