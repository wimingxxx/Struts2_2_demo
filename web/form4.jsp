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
  <form action="${pageContext.request.contextPath}/DemoParams4Action" method="post">
      list:<input type="text" name="list" /><br>
      list:<input type="text" name="list[3]" /><br>
      map:<input type="text" name="map['test']" /><br>
      <input type="submit" value="提交" />
  </form>
</body>
</html>
