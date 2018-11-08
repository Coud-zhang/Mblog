package com.zkq.service;

import com.zkq.dao.deleteDaoImpl;
import com.zkq.daoiface.deleteDao;
import com.zkq.serviceiface.deleteService;
import lombok.extern.log4j.Log4j;

@Log4j
public class deleteServiceImpl implements deleteService {
    deleteDao deleteDao=new deleteDaoImpl();
    @Override
    public boolean deleteUser(String username) {
        int num=deleteDao.deleteUser(username);
        return num==1?true:false;
    }

    @Override
    public boolean deleteBlog(int id) {
        int num=deleteDao.deleteBlog(id);
        return num==1?true:false;
    }
}
