package com.zkq.serviceiface;

public interface insertservice {
    public boolean insertBlog(String bt, String gaishu, String context, String date, String bq);
    public boolean insertUser(String username,String password,String email,String path,String quanxian);
}
