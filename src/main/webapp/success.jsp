<%--
  Created by IntelliJ IDEA.
  ustc.gr.InterController.User: Black
  Date: 2017/4/2
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:message code="welcome" arguments="${requestScope.user.username }"/>
</body>
</html>
