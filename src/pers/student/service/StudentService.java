package pers.student.service;

import pers.student.dao.StudentDao;
import pers.student.entity.Student;

import java.util.List;

//业务逻辑层：逻辑性的增删改查（ 增：先查后增 ），对dao层进行组装
public class StudentService {

    StudentDao studentDao = new StudentDao();

    /**
     * 增加学生
     * @param student
     * @return
     */
    public boolean addStudent(Student student) {
        if (!studentDao.isExit(student.getSno())) {//不存在
            return studentDao.addStudent(student);
        } else {
            System.out.println("此人已存在！");
            return false;
        }
    }

    /**
     * 根据学号删除
     * @param sno
     * @return
     */
    public boolean deleteStudentBySno(String sno) {
        if (studentDao.isExit(sno)) {
            return studentDao.deleteStudentBySno(sno);
        }
        return false;
    }

    /**
     * 根据学号修改
     * @param sno
     * @param student
     * @return
     */
    public boolean updateStudentBySno(String sno, Student student) {
        if (studentDao.isExit(sno)) {
            return studentDao.updateStudentBySno(sno, student);
        }
        return false;
    }

    /**
     * 根据学号查询单个学生
     * @param sno
     * @return
     */
    public Student queryStudentBySno(String sno) {
        return studentDao.queryStudentBySno(sno);
    }

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> queryAllStudent() {
        return studentDao.queryAllStudent();
    }

}
