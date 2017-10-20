package com.qwm.struts2_2.a_result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author: wiming
 * @date: 2017-09-18 17:47:33  星期一
 * @decription:
 */
public class DemoResult1Action  extends ActionSupport{
    @Override
    public String execute() throws Exception {
        System.out.println(this.getClass().getSimpleName());
        return SUCCESS;
    }
}
