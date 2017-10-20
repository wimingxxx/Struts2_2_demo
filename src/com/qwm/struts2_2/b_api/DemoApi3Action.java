package com.qwm.struts2_2.b_api;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: wiming
 * @date: 2017-09-18 17:37:20  星期一
 * @decription:
 * 第三种方式获取
 * 想要获取多个，就是实现多个域
 */
public class DemoApi3Action extends ActionSupport implements ServletRequestAware{

    private HttpServletRequest request;

    public String execute() throws Exception{
        //原生session
        HttpSession session = request.getSession();
        //原生servlerContext
        ServletContext servletContext = request.getServletContext();

        request.setAttribute("name","request_wiming_test3");
        session.setAttribute("name","session_wiming_test3");
        servletContext.setAttribute("name","application_wiming_test3");
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}
