package com.zkq.daoiface;

public interface InsertDao {
    public int insertBlog(String bt,String gaishu, String context, String date,String bq);
    public int insertUser(String username,String password,String email,String path,String quanxian);
}
