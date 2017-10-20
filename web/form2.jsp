<%--
  Created by IntelliJ IDEA.
  User: qiwenming
  Date: 2017/9/19
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数获取</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/DemoParams2Action" method="post">
      用户名:<input type="text" name="user.name" /><br>
      年龄:<input type="text" name="user.age" /><br>
      生日:<input type="text" name="user.birthday" /><br>
      <input type="submit" value="提交" />
  </form>
</body>
</html>
