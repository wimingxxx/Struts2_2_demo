package com.qwm.struts2_2.b_api;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * @author: wiming
 * @date: 2017-09-18 16:50:34  星期一
 * @decription:
 * 第一种方式获取
 */
public class DemoApi1Action extends ActionSupport{
    @Override
    public String execute() throws Exception {
        /*
          static ThreadLocal<ActionContext> actionContext = new ThreadLocal<>();
          (Map<String, Object>) get(SESSION);
         */
        //session域  map
        Map<String, Object> sessionScope = ActionContext.getContext().getSession();
        // application域  map
        Map<String, Object> applicationScope = ActionContext.getContext().getApplication();

        //request域=> map (struts2并不推荐使用原生request域)
        //Map<String,Object> requestScope = (Map<String,Object>)ActionContext.getContext().get("request");
        //推荐
        // ActionContext和 request域的生命周期是一样的
        // 全局过滤器包装了原生的request，主要就是改变了取值的时候，先从原生request中查找，然后还会从ActionContext中查找
        ActionContext.getContext().put("name","request_wiming_test1");

        sessionScope.put("name","session_wiming_test1");
        applicationScope.put("name","application_wiming_test1");
        return SUCCESS;
    }
}
