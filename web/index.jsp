<%@ page import="java.util.List" %>
<%@ page import="pers.student.entity.Student" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>学生信息列表</title>

      <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
      <script type="text/javascript">
          $(function () {
            $("tr:odd").css("background-color","lightgray");
          });
      </script>
  </head>
  <body>
    <%
       String error = (String) request.getAttribute("error");
       if (error != null){
           if (error.equals("addError")) {
               out.print("增加失败");
           } else if (error.equals("addSuccess")){
               out.print("增加成功");
           }
       }
    %>
    <table border="1px">
      <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
<%--        <th>地址</th>--%>
        <th>操作</th>
      </tr>
      <%
        //获取request域中的数据
        List<Student> students = (List<Student>) request.getAttribute("students");
        for (Student student: students) {
      %>
        <tr>
          <td><a href="QueryStudentServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
          <td><%=student.getSname()%></td>
          <td><%=student.getAge()%></td>
<%--          <td><%=student.getAddress()%></td>--%>
          <td><a href="#" onclick="window.confirm('确认删除吗？')?this.href='DeleteStudentServlet?sno=<%=student.getSno()%>':this.href='javascript:void()';">删除</a></td>
        </tr>
      <%
        }
      %>
    </table>
    <a href="add.jsp">新增学生</a>
  </body>
</html>