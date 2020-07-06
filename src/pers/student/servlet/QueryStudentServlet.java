package pers.student.servlet;

import pers.student.entity.Student;
import pers.student.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/QueryStudentServlet")
public class QueryStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取前台数据
        String no = request.getParameter("sno");

        StudentService studentService = new StudentService();
        Student student = studentService.queryStudentBySno(no);
        System.out.println(student);
        request.setAttribute("student", student);
        //将此人数据通过前台jsp显示出来
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
