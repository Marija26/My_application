<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.07.2017
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>User id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>DoB</th>
        <th>Email</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.userid}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.dob}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><a href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
            <td><a href="UserController?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="UserController?action=insert">Add user</a></p>
</body>
</html>
