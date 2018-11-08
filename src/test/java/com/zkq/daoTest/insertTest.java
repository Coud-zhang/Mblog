package com.zkq.daoTest;

import com.zkq.dao.insertDaoImpl;
import com.zkq.daoiface.InsertDao;
import org.junit.Test;

public class insertTest {
    @Test
    public void test(){
        InsertDao insertDao=new insertDaoImpl();
       int num= insertDao.insertBlog("java","java","java","2016-1-1","java");
    System.out.print(num);
    }
}
