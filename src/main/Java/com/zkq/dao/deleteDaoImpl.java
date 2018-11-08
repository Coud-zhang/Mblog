package com.zkq.dao;

import com.zkq.daoiface.deleteDao;
import com.zkq.jdbcutils.ConnectionDb;

public class deleteDaoImpl implements deleteDao {
    @Override
    public int deleteUser(String username) {
        String sql="delete from glyb where username=?";
        int count= ConnectionDb.excueupddate(sql,username);
        return count;
    }

    @Override
    public int deleteBlog(int id) {
        String sql="delete from blog where id=?";
        int count= ConnectionDb.excueupddate(sql,id);
        return count;
    }
}
