package pers.student.servlet;

import pers.student.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //接收前台数据
        String no = request.getParameter("sno");
        //创建Service对象
        StudentService studentService = new StudentService();
        boolean rs = studentService.deleteStudentBySno(no);
        if (rs) {
//            response.getWriter().println("删除成功");
            response.sendRedirect("QueryAllStudentServlet");
        } else {
            response.getWriter().println("删除失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
