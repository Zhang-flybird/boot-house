package com.etoak.bean;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;
    private String password;
    private String gender;
    private Integer age;
    private String email;
    private String birthday;
    private Integer state;
}
