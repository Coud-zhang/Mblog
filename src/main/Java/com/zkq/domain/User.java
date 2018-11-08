package com.zkq.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor//无参构造器
@AllArgsConstructor//有参构造器
@Getter//get方法
@Setter//set方法
public class User {
    private String username;
    private String password;
    private String email;
    private  String path;
    private String quanxian;
    private int id;
}
