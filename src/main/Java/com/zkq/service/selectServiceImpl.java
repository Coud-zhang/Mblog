package com.zkq.service;

import com.zkq.dao.selectDaoImpl;
import com.zkq.daoiface.selectDao;
import com.zkq.domain.Blog;
import com.zkq.domain.User;
import com.zkq.pageutils.Page;
import com.zkq.serviceiface.selectservice;
import org.apache.log4j.Logger;

import java.util.List;

public class selectServiceImpl implements selectservice {
    private Logger log= Logger.getLogger(selectServiceImpl.class);
    selectDao selectDao=new selectDaoImpl();
    @Override
    public boolean checkpassWord(String username, String password) {
        int num=selectDao.checkUserNameAndPassWord(username,password);
        return num==1?true:false;
    }

    @Override
    public void getBlogBypage(Page<Blog> page) {
        selectDao.getBlogBypage(page);
    }

    @Override
    public void getBlogRows(Page<Blog> page) {
       int num=selectDao.getBlogRows();
       int totalPage=num%page.getPageNumber()==0?num/page.getPageNumber():num/page.getPageNumber()+1;
       page.setTotalPage(totalPage);
    }

    @Override
    public void getUserBypage(Page<User> page) {
        selectDao.getUserBypage(page);
    }

    @Override
    public void getUserRows(Page<User> page) {
        int num=selectDao.getUserRows();
        int totalPage=num%page.getPageNumber()==0?num/page.getPageNumber():num/page.getPageNumber()+1;
        page.setTotalPage(totalPage);
    }

    @Override
    public void selectPage(Page<User> page, String keyword) {
        selectDao.selectPage(page,keyword);
    }

    @Override
    public void getSelectRows(Page<User> page, String keyword) {
        int num=selectDao.getSelectRows(keyword);
        int totalPage=num%page.getPageNumber()==0?num/page.getPageNumber():num/page.getPageNumber()+1;
        page.setTotalPage(totalPage);
    }

    @Override
    public User getUserRights(String username) {
        List<User> list=selectDao.getUserRights(username);
        return list.get(0);
    }
}
