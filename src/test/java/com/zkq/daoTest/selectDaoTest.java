package com.zkq.daoTest;

import com.zkq.dao.selectDaoImpl;
import com.zkq.daoiface.selectDao;
import com.zkq.domain.User;
import com.zkq.pageutils.Page;
import org.junit.Test;

public class selectDaoTest {
    @Test
    public  void test(){
        Page<User> page=new Page<>(1,2);
        selectDao selectDao=new selectDaoImpl();
       selectDao.selectPage(page,"1");
       System.out.print(page.getList());
    }
    @Test
    public void testcheck(){
        selectDao selectDao=new selectDaoImpl();
        int num=selectDao.getSelectRows("1");
        System.out.print(num);
    }
}
