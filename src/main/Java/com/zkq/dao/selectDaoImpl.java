package com.zkq.dao;

import com.zkq.daoiface.selectDao;
import com.zkq.domain.Blog;
import com.zkq.domain.User;
import com.zkq.jdbcutils.ConnectionDb;
import com.zkq.pageutils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class selectDaoImpl implements selectDao {
    @Override
    public void getBlogBypage(Page<Blog> page) {
        String sql = "select * from blog limit " + (page.getCurrentPage() - 1) * page.getPageNumber() + "," + page.getPageNumber();
        List<Blog> list = ConnectionDb.query(sql, (rs) -> {
            List<Blog> list1 = new ArrayList<>();
            while (rs.next()) {
                Blog blog = new Blog(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4).toString(), rs.getInt(5), rs.getString(6),rs.getInt(7));
                list1.add(blog);
            }
            return list1;
        });
        page.setList(list);
    }

    @Override
    public void getUserBypage(Page<User> page) {
        String sql = "select * from glyb limit " + (page.getCurrentPage() - 1) * page.getPageNumber() + "," + page.getPageNumber();
        List<User> list = ConnectionDb.query(sql, (rs) -> {
            List<User> list1 = new ArrayList<>();
            while (rs.next()) {
                User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6));
                list1.add(user);
            }
            return list1;
        });
        page.setList(list);
    }

    @Override
    public int getBlogRows() {
        String sql = "select count(1) from blog";
        int count = ConnectionDb.queryForCount(sql);
        return count;
    }

    @Override
    public int getUserRows() {
        String sql = "select count(1) from glyb";
        int count = ConnectionDb.queryForCount(sql);
        return count;
    }

    @Override
    public int getSelectRows(String keyword) {
        String sql = "select count(1) from glyb where username like ?";
        int count = ConnectionDb.queryForCount(sql, "%" + keyword + "%");
        return count;
    }

    @Override
    public void selectPage(Page<User> page, String keyword) {
        String sql = "select * from glyb where username like ? limit " + (page.getCurrentPage() - 1) * page.getPageNumber() + "," + page.getPageNumber();
        List<User> list = ConnectionDb.query(sql, (rs) -> {
            List<User> list1 = new ArrayList<>();
            while (rs.next()) {
                User user = new User(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6));
                list1.add(user);
            }
            return list1;
        }, "%" + keyword + "%");
        page.setList(list);
    }

    @Override
    public List<User> getUserRights(String username) {
        String sql = "select * from glyb where username=?";
        List<User> list = ConnectionDb.query(sql,(rs)->{
            List<User> list1 = new ArrayList<>();
            while (rs.next()){
                User user = new User(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6));
                list1.add(user);
            }
            return list1;
        },username);
        return list;
    }

    @Override
    public int checkUserNameAndPassWord(String username,String password) {
        int count = 0;
        String sql = "select count(*) from glyb where username=? and password=?";
        count = ConnectionDb.queryForCount(sql, username, password);
        return count;
    }
}
