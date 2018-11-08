package com.zkq.service;

import com.zkq.dao.updateDaoImpl;
import com.zkq.daoiface.updateDao;
import com.zkq.serviceiface.updateService;
import lombok.extern.log4j.Log4j;

@Log4j
public class updateServiceImpl implements updateService {
    updateDao updateDao=new updateDaoImpl();
    @Override
    public boolean updateUser(String username, String password, String email, String path) {
        int count=updateDao.updateUser(username,password,email,path);
        return count==1?true:false;
    }
}
