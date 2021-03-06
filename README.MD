# Struts2 学习之结果与参数获取

----
这个例子是学习Struts结果与参数获取相关的例子

[SSH与SSM学习之Struts204——结果跳转方式](blog/04.md)

[SSH与SSM学习之Struts205——访问servletAPI方式](blog/05.md)

[SSH与SSM学习之Struts206——参数获取](blog/06.md)

**其他相关**

[SSH与SSM学习之Struts201——介绍与环境搭建和第一个例子](blog/01.md)

[SSH与SSM学习之Struts202——Struts2访问流程和架构图](blog/02.md)

[SSH与SSM学习之Struts203——主配置文件配置_常量配置_动态方法配置_action书写方式](blog/03.md)

[SSH与SSM学习之Struts207——OGNL基本语法](blog/07.md)

[SSH与SSM学习之Struts208——OGNL表达式与Struts框架结合之原理](blog/08.md)

[SSH与SSM学习之Struts209——OGNL表达式与Struts框架结合参数接收](blog/09.md)

[SSH与SSM学习之Struts210——Struts2基本流程(源码)](blog/10.md)

[SSH与SSM学习之Struts211——拦截器](blog/11.md)

[SSH与SSM学习之Struts212——标签](blog/12.md)


---------

或者查看blog

[SSH与SSM学习](http://blog.csdn.net/qiwenmingshiwo/article/category/7175517)

----

相关的项目


**Struts2 学习之配置**
[https://github.com/wimingxxx/Struts2_1_setting](https://github.com/wimingxxx/Struts2_1_setting)

**Struts2 学习之结果与参数获取**
[https://github.com/wimingxxx/Struts2_2_demo](https://github.com/wimingxxx/Struts2_2_demo)

**Struts2 学习之OGNL、拦截器、标签**
[https://github.com/wimingxxx/Struts2_3_demo](https://github.com/wimingxxx/Struts2_3_demo)

----

[TOC]

# SSH与SSM学习之Struts204——结果跳转方式

## 一、result的类型

打开默认配置文件 **struts2-core-2.5.13.jar!\struts-default.xml**，这里面有 result 的定义

```xml
<result-types>
    <result-type name="chain" class="com.opensymphony.xwork2.ActionChainResult"/>
    <result-type name="dispatcher" class="org.apache.struts2.result.ServletDispatcherResult" default="true"/>
    <result-type name="freemarker" class="org.apache.struts2.views.freemarker.FreemarkerResult"/>
    <result-type name="httpheader" class="org.apache.struts2.result.HttpHeaderResult"/>
    <result-type name="redirect" class="org.apache.struts2.result.ServletRedirectResult"/>
    <result-type name="redirectAction" class="org.apache.struts2.result.ServletActionRedirectResult"/>
    <result-type name="stream" class="org.apache.struts2.result.StreamResult"/>
    <result-type name="velocity" class="org.apache.struts2.result.VelocityResult"/>
    <result-type name="xslt" class="org.apache.struts2.views.xslt.XSLTResult"/>
    <result-type name="plainText" class="org.apache.struts2.result.PlainTextResult" />
    <result-type name="postback" class="org.apache.struts2.result.PostbackResult" />
</result-types>
```

|属性| 说明|
|---|----|
|chain  |用 来 处 理Action链 ， 被 跳 转 的 Action 中 仍 能 获 取上个页面的值，如 request信息。|
|dispatcher|用 来 转 向 页 面 ， 通 常 处 理 jsp， 足 默 认 的 结 果 类型 。|
|freemarker| 用来整合 FreeMarker校板结果类型。|
|httpheader |用来处理特殊的 HTTP行为结果类型。|
|redirect | 重定向 到 一 个 URL， 被 跳 转 的 页 面 中 丢 失 传 递 的信息。|
|redirectAction |重定向到一个 Action，跳转的页面中丢失传递的信怠。|
|stream|向浏览器发送 InputStream对象，通常用来处理文件下载，还可用于Ajax数据。|
|velocity|用来整合Velocity模板结果类型。|
|xslt | 用来整合 XML/ XSLT结果类型。|
|plainText |显示原始文件内容，例如文件源代码。|
|postback |使得当前请求参数以表单形式提交|



常用到是下面四种

> chain
> 
> dispatcher
> 
> redirect
> 
> redirectAction


----

## 二、转发

转发我们使用 **dispatcher** ，它也是默认的方式，下面我们实现转发的测试。

### 2.1 DemoResult1Action

```java
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

```

### 2.2 配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <package name="resulttest" namespace="/" extends="struts-default">
        <!--转发-->
        <action name="DemoResult1Action" class="com.qwm.struts2_2.a_result.DemoResult1Action">
            <result name="success" type="dispatcher">/hello.jsp</result>
        </action>
    </package>
</struts>
```

### 2.3 图示

![image](http://img.blog.csdn.net/20170923014303900?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWl3ZW5taW5nc2hpd28=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

----

## 三、重定向

重定向我们使用 **redirect** ，下面我们实现重定向的测试。

### 3.1 DemoResult2Action

```java
package com.qwm.struts2_2.a_result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author: wiming
 * @date: 2017-09-18 17:47:33  星期一
 * @decription:
 */
public class DemoResult2Action extends ActionSupport{
    @Override
    public String execute() throws Exception {
        System.out.println(this.getClass().getSimpleName());
        return SUCCESS;
    }
}
```

### 3.2 配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <package name="resulttest" namespace="/" extends="struts-default">
        <!--重定向-->
        <action name="DemoResult2Action" class="com.qwm.struts2_2.a_result.DemoResult2Action">
            <result name="success" type="redirect">/hello.jsp</result>
        </action>
    </package>
</struts>
```

### 3.3 图示


![这里写图片描述](http://img.blog.csdn.net/20170923014322249?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWl3ZW5taW5nc2hpd28=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

----

## 四、转发到Action

转发到Action我们使用 **chain**。使用这个，我们的result会有不同，如下

```xml
<result name="success" type="chain">
    <!-- 转发到的action的名字 -->
    <param name="actionName">DemoResult1Action</param>
    <!-- 转发到的action所在的命名空间 -->
    <param name="namespace">/</param>
</result>
```

下面我们实现转发Action的测试。

### 4.1 DemoResult3Action

```java
package com.qwm.struts2_2.a_result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author: wiming
 * @date: 2017-09-18 17:47:33  星期一
 * @decription:
 */
public class DemoResult3Action extends ActionSupport{
    @Override
    public String execute() throws Exception {
        System.out.println(this.getClass().getSimpleName());
        return SUCCESS;
    }
}

```

### 4.2 配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
        <!-- 转发到Action -->
        <action name="DemoResult3Action" class="com.qwm.struts2_2.a_result.DemoResult3Action">
            <result name="success" type="chain">
                <!-- action的名字 -->
                <param name="actionName">DemoResult1Action</param>
                <!-- action所在的命名空间 -->
                <param name="namespace">/</param>
            </result>
        </action>
    </package>
</struts>
```

### 4.3 图示

![这里写图片描述](http://img.blog.csdn.net/20170923014341692?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWl3ZW5taW5nc2hpd28=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

----


## 五、重定向到Action

重定向到Action我们使用 **chain**。使用这个，我们的result会有不同，如下

```xml
<result name="success" type="chain">
    <!-- 重定向到的action的名字 -->
    <param name="actionName">DemoResult1Action</param>
    <!-- 重定向到的action所在的命名空间 -->
    <param name="namespace">/</param>
</result>
```

下面我们实现重定向到Action的测试。

### 5.1 DemoResult4Action

```java
package com.qwm.struts2_2.a_result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author: wiming
 * @date: 2017-09-18 17:47:33  星期一
 * @decription:
 */
public class DemoResult4Action extends ActionSupport{
    @Override
    public String execute() throws Exception {
        System.out.println(this.getClass().getSimpleName());
        return SUCCESS;
    }
}

```

### 5.2 配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <package name="resulttest" namespace="/" extends="struts-default">
        <!-- 重定向到Action -->
        <action name="DemoResult4Action" class="com.qwm.struts2_2.a_result.DemoResult4Action">
            <result name="success" type="redirectAction">
                <!-- 重定向到的action的名字 -->
                <param name="actionName">DemoResult1Action</param>
                <!-- 重定向到的action所在的命名空间 -->
                <param name="namespace">/</param>
            </result>
        </action>
    </package>
</struts>
```

### 5.3 图示

![这里写图片描述](http://img.blog.csdn.net/20170923014404890?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWl3ZW5taW5nc2hpd28=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

