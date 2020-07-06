package pers.student.servlet;

import pers.student.entity.Student;
import pers.student.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //设置编码
       request.setCharacterEncoding("utf-8");
       response.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=UTF-8");
        //获取前台数据
        String no = request.getParameter("sno");
        String name = request.getParameter("sname");
        String sage = request.getParameter("sage");
        int age = 0;
        if (!(sage == null || sage.equals(""))) {
            age = Integer.parseInt(sage);
        }
        String address = request.getParameter("saddress");
        //封装进JavaBean
        Student student = new Student(no, name, age, address);

        StudentService studentService = new StudentService();
        boolean flag = studentService.addStudent(student);
        PrintWriter out = response.getWriter();
//        if (flag) {
////            out.println("增加成功！");
//
//        } else {
//            out.println("增加失败！！");
//
//        }
        if (!flag) {
            request.setAttribute("error","addError");
        } else {
            request.setAttribute("error","addSuccess");
        }
//        response.sendRedirect("QueryAllStudentServlet");
        request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
