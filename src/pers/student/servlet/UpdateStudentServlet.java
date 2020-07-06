package pers.student.servlet;

import pers.student.entity.Student;
import pers.student.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取待修改人的学号
        String no = request.getParameter("sno");
        //获取修改后的内容
        String name = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("sage"));
        String address = request.getParameter("saddress");
        //封装进JavaBean
        Student student = new Student(name, age, address);

        StudentService studentService = new StudentService();
        if (studentService.updateStudentBySno(no, student)) {
//            response.getWriter().println("修改成功");
            //修改成功，回到主页，显示所有学生信息
            response.sendRedirect("QueryAllStudentServlet");
        } else {
            response.getWriter().println("修改失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
