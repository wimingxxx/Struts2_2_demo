package com.qwm.struts2_2.c_params;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;
import java.util.Map;

/**
 * @author: wiming
 * @date: 2017-09-19 14:19:22  星期二
 * @decription:
 *  集合获取参数测试
 */
public class DemoParams4Action extends ActionSupport{

    private List<String> list;
    private Map<String,String> map;

    @Override
    public String execute() throws Exception {
        //保存到request域中去
        ActionContext.getContext().put("title",this.getClass().getSimpleName());
        ActionContext.getContext().put("list",list);
        ActionContext.getContext().put("map",map);
        return SUCCESS;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
