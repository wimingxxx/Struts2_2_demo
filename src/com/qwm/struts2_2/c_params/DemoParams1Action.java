package com.qwm.struts2_2.c_params;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * @author: wiming
 * @date: 2017-09-19 13:56:24  星期二
 * @decription:
 * 参数获取方式一 属性驱动获得参数
 */
public class DemoParams1Action extends ActionSupport {

    //自动类型转换 只能转换8大基本数据类型以及对应包装类,以及Date
    //准备与参数键名称相同的属性
    private String name;
    private Integer age;
    //支持特定类型字符串转换为Date ,例如 yyyy-MM-dd
    private Date birthday;

    @Override
    public String execute() throws Exception {
        //保存到request域中去
        ActionContext.getContext().put("title",this.getClass().getSimpleName());
        ActionContext.getContext().put("name",name);
        ActionContext.getContext().put("age",age);
        ActionContext.getContext().put("birthday",birthday);
        return SUCCESS;
    }

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
