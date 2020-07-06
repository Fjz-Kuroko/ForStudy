package pers.student.dao;

import pers.student.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//数据访问层，原子性的增删改查
public class StudentDao {
    //数据库连接数据
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB = "javadb";
    private final String USER = "java";
    private final String PWD = "123456";
    private final String URL = "jdbc:mysql://localhost:3306/"+DB+"?useUnicode = true&" +
            "characterEncoding = utf-8&useSSL = false&serverTimezone = GMT&allowPublicKeyRetrieval=true";

    /**
     * 根据学号查询此人是否存在
     * @param sno
     * @return
     */
    public boolean isExit(String sno) {
        return queryStudentBySno(sno) != null;
    }

    /**
     * 根据学号查询学生
     * @param sno
     * @return 返回一个学生对象
     */
    public Student queryStudentBySno(String sno) {
        Student student = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PWD);
            String sql = "select * from stu where sno = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, sno);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String no = rs.getString("sno");
                String name = rs.getString("sname");
                int age = rs.getInt("sage");
                String address = rs.getString("saddress");
                student = new Student(no, name, age, address);
            }
            return student;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询所有学生数据
     * @return
     */
    public List<Student> queryAllStudent() {
        List<Student> studentList = new ArrayList<Student>();
        Student student = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PWD);
            String sql = "select * from stu";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String no = rs.getString("sno");
                String name = rs.getString("sname");
                int age = rs.getInt("sage");
                String address = rs.getString("saddress");
                student = new Student(no, name, age, address);
                studentList.add(student);
            }
            return studentList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 增加、插入学生
     * @param student
     * @return 返回是否成功
     */
    public boolean addStudent(Student student) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PWD);
            String sql = "insert into stu values (?,?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, student.getSno());
            pstmt.setString(2, student.getSname());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getAddress());
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据学号删除
     * @param sno
     * @return
     */
    public boolean deleteStudentBySno(String sno) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PWD);
            String sql = "delete from stu where sno = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, sno);
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据学号修改学生
     * @param sno
     */
    public boolean updateStudentBySno(String sno, Student student) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PWD);
            String sql = "update stu set sname = ?, sage = ?, saddress = ? where sno = ?";
            pstmt = connection.prepareStatement(sql);
            //修改后内容
            pstmt.setString(1, student.getSname());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getAddress());
            pstmt.setString(4, sno);
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
