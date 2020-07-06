<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/7/5
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function check() {
            var no = $("input[name='sno']").val();
            var name = $("input[name='sname']").val();
            var age = $("input[name='sage']").val();
            var address = $("input[name='saddress']").val();
            if (no.length < 4 || !(/(^[1-9]\d*$)/.test(no))) {
                alert("学号必须为四位数!");
                return false;
            }
            if (name.length < 2) {
                alert("姓名必须为两个字符以上!");
                return false;
            }
            if (!(/(^[1-9]\d*$)/.test(age))) {
                alert("年龄必须为正整数!");
                return false;
            }
            if (address == "" || address == null) {
                alert("地址不能为空!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <form action="AddStudentServlet" method="post" onsubmit="return check()">
        学号：<input type="text" name="sno"><br/>
        姓名：<input type="text" name="sname"><br/>
        年龄：<input type="text" name="sage"><br/>
        地址：<input type="text" name="saddress"><br/>
        <input type="submit" value="新增学生"><br/>
    </form>
</body>
</html>
