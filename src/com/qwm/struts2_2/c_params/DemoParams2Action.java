package com.qwm.struts2_2.c_params;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * @author: wiming
 * @date: 2017-09-19 14:19:22  星期二
 * @decription:
 *  参数获取方式二 对象驱动获得参数
 */
public class DemoParams2Action extends ActionSupport {
    private User user;
    @Override
    public String execute() throws Exception {
        //保存到request域中去
        ActionContext.getContext().put("title",this.getClass().getSimpleName());
        ActionContext.getContext().put("name",user.getName());
        ActionContext.getContext().put("age",user.getAge());
        ActionContext.getContext().put("birthday",user.getBirthday());
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
