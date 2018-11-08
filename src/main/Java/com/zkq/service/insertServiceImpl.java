package com.zkq.service;

import com.zkq.dao.insertDaoImpl;
import com.zkq.daoiface.InsertDao;
import com.zkq.serviceiface.insertservice;

public class insertServiceImpl implements insertservice {
    InsertDao insertDao=new insertDaoImpl();
    @Override
    public boolean insertBlog(String bt, String gaishu, String context, String date, String bq) {
        int count= insertDao.insertBlog(bt,gaishu,context,date,bq);
        return count==1?true:false;
    }

    @Override
    public boolean insertUser(String username, String password, String email, String path, String quanxian) {
        int count= insertDao.insertUser(username,password,email,path,quanxian);
        return count==1?true:false;
    }
}
