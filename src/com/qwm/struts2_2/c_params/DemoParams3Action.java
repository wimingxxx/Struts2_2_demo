package com.qwm.struts2_2.c_params;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author: wiming
 * @date: 2017-09-19 14:19:22  星期二
 * @decription:
 *  参数获取方式三 模型驱动获得参数
 */
public class DemoParams3Action extends ActionSupport implements ModelDriven<User> {
    //准备user成员变量,必须实例化
    private User user = new User();
    @Override
    public String execute() throws Exception {
        //保存到request域中去
        ActionContext.getContext().put("title",this.getClass().getSimpleName());
        ActionContext.getContext().put("name",user.getName());
        ActionContext.getContext().put("age",user.getAge());
        ActionContext.getContext().put("birthday",user.getBirthday());
        return SUCCESS;
    }

    @Override
    public User getModel() {
        return user;
    }
}
