package com.qwm.struts2_2.b_api;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: wiming
 * @date: 2017-09-18 16:50:34  星期一
 * @decription:
 * 第二种方式获取 不推荐
 */
public class DemoApi2Action extends ActionSupport{
    @Override
    public String execute() throws Exception {
        //原生request
//        内部调用   ActionContext.getContext().get(HTTP_REQUEST)
        HttpServletRequest request = ServletActionContext.getRequest();
        //原生response
        HttpServletResponse response = ServletActionContext.getResponse();
        //原生session
        HttpSession session = ServletActionContext.getRequest().getSession();
        //原生servlerContext
        ServletContext servletContext = ServletActionContext.getServletContext();

        request.setAttribute("name","request_wiming_test2");
        session.setAttribute("name","session_wiming_test2");
        servletContext.setAttribute("name","application_wiming_test2");

        return SUCCESS;
    }
}
