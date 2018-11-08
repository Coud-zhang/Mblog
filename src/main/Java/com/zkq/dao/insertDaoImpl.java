package com.zkq.dao;

import com.zkq.daoiface.InsertDao;
import com.zkq.jdbcutils.ConnectionDb;

public class insertDaoImpl implements InsertDao {
    @Override
    public int insertBlog(String bt, String gaishu, String context, String date, String bq) {
        String sql="insert into blog(biaoti,gaishu,article,data,biaoqian) values(?,?,?,?,?)";
        int num= ConnectionDb.excueupddate(sql,bt,gaishu,context,date,bq);
        return num;
    }

    @Override
    public int insertUser(String username, String password, String email, String path, String quanxian) {
       String sql="insert into glyb(username,password,email,photo,quanxian) values(?,?,?,?,?)";
        int count=ConnectionDb.excueupddate(sql,username,password,email,path,quanxian);
        return count;
    }
}
