<%--
  Created by IntelliJ IDEA.
  User: qiwenming
  Date: 2017/9/18
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>原生ServletApi取值</title>
</head>
<body>
    request: ${requestScope.name}<br><br>
    session: ${sessionScope.name}<br><br>
    application: ${applicationScope.name}<br>
</body>
</html>
