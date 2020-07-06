<%@ page import="pers.student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/7/5
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生个人信息</title>
</head>
<body>
    <%
        Student student = (Student) request.getAttribute("student");
    %>
<%--    通过表单展示--%>
    <form action="UpdateStudentServlet" method="post" onsubmit="return confirm('确定修改吗？')">
        学号：<input type="text" name="sno" value="<%=student.getSno()%>" readonly="readonly"/><br/>
        姓名：<input type="text" name="sname" value="<%=student.getSname()%>" /><br/>
        年龄：<input type="text" name="sage" value="<%=student.getAge()%>" /><br/>
        地址：<input type="text" name="saddress" value="<%=student.getAddress()%>" /><br/>
        <input type="submit" value="修改">&nbsp;&nbsp;&nbsp;&nbsp;<a href="QueryAllStudentServlet">返回</a>
    </form>
</body>
</html>
