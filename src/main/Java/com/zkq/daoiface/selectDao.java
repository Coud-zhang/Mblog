package com.zkq.daoiface;

import com.zkq.domain.Blog;
import com.zkq.domain.User;
import com.zkq.pageutils.Page;

import java.util.List;

public interface selectDao {
    public void getBlogBypage(Page<Blog> page);
    public void getUserBypage(Page<User> page);
    public int getBlogRows();
    public int getUserRows();
    public int getSelectRows(String keyword);
    public void selectPage(Page<User> page,String keyword);
    public List<User> getUserRights(String username);
    public int checkUserNameAndPassWord(String username,String password);
}
