package com.lee.qqzone.dao.impl;

import com.lee.myssm.basedao.TransBasicDAO;
import com.lee.qqzone.dao.UserBasicDAO;
import com.lee.qqzone.domain.UserBasic;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class UserBasicDAOImpl extends TransBasicDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        String sql = "select * from t_user_basic where loginId=? and pwd=?";
        UserBasic userBasic = super.querySingle(sql, UserBasic.class, loginId, pwd);

        return userBasic;
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        String sql = "select fid as 'id' from t_friend where uid=?";
        List<UserBasic> userBasicList = super.queryMulti(sql, UserBasic.class, userBasic.getId());

        return userBasicList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        String sql = "select * from t_user_basic where id=?";
        UserBasic userBasic = super.querySingle(sql, UserBasic.class, id);

        return userBasic;
    }
}
