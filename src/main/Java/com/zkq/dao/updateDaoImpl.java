package com.zkq.dao;

import com.zkq.daoiface.updateDao;
import com.zkq.jdbcutils.ConnectionDb;
import lombok.extern.log4j.Log4j;

@Log4j
public class updateDaoImpl implements updateDao {
    @Override
    public int updateUser(String username, String password, String email, String path) {
        String sql="update glyb set password=?,email=?,photo=? where username=?";
        int count= ConnectionDb.excueupddate(sql,password,email,path,username);
        return count;
    }
}
