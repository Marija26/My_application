<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.07.2017
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="UserController" name="frmAddUser">
    User ID: <input type="text" readonly="readonly" name="userid"
                    value="<c:out value="${user.userid}"/>"> <br/>
    First name: <input type="text" name="firstName"
                        value="<c:out value="${user.firstName}"/>"> <br/>
    Last name: <input type="text" name="lastName"
                       value="<c:out value="${user.lastName}"/>"> <br/>
    DOB: <input type="text" name="dob"
                       value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}"/>"/> <br/>
    Email: <input type="text" name="email"
                       value="<c:out value="${user.email}"/>"> <br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
