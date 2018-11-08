package com.zkq.serviceiface;

import com.zkq.domain.Blog;
import com.zkq.domain.User;
import com.zkq.pageutils.Page;

public interface selectservice {
    public boolean checkpassWord(String username,String password);
    public void getBlogBypage(Page<Blog> page);
    public void getBlogRows(Page<Blog> page);
    public void getUserBypage(Page<User> page);
    public void getUserRows(Page<User> page);
    public void selectPage(Page<User> page,String keyword);
    public void getSelectRows(Page<User> page,String keyword);
    public User getUserRights(String username);
}
