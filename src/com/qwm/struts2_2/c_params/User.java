package com.qwm.struts2_2.c_params;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    //自动类型转换 只能转换8大基本数据类型以及对应包装类,以及Date
    //准备与参数键名称相同的属性
    private String name;
    private Integer age;
    //支持特定类型字符串转换为Date ,例如 yyyy-MM-dd
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
