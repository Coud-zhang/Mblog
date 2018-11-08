package com.zkq.service;

import com.zkq.dao.insertDaoImpl;
import com.zkq.daoiface.InsertDao;
import com.zkq.domain.User;
import com.zkq.pageutils.Page;
import com.zkq.serviceiface.insertservice;
import com.zkq.serviceiface.selectservice;
import org.junit.Test;

public class serviceTest {
@Test
    public void test(){
    selectservice selectservice=new selectServiceImpl();
    Page<User> page=new Page<>(3,2);
    selectservice.getUserRows(page);
    selectservice.getUserBypage(page);
    System.out.print(page.getTotalPage());
    System.out.print(page.getList());
}
@Test
    public void check(){
    selectservice selectservice=new selectServiceImpl();
    System.out.print(selectservice.getUserRights("zkq162534"));
}
@Test
    public void t(){
    insertservice insertservice=new insertServiceImpl();
    boolean a=insertservice.insertBlog("00000","0000","00000","00000","0000");
    System.out.print(a);
}
}
