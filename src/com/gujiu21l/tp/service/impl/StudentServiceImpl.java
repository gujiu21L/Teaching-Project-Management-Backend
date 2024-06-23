package com.gujiu21l.tp.service.impl;

import com.gujiu21l.tp.dao.impl.StudentDaoImpl;
import com.gujiu21l.tp.dao.impl.ProjectParticipationDaoImpl;
import com.gujiu21l.tp.pojo.Student;
import com.gujiu21l.tp.service.StudentService;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDaoImpl studentDao = new StudentDaoImpl();
    private ProjectParticipationDaoImpl participationDao = new ProjectParticipationDaoImpl();

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentDao.getStudentByEmail(email);
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int deleteStudent(int studentId) {
        return studentDao.deleteStudent(studentId);
    }

    @Override
    public void deleteStudentCascade(int studentId) {
        participationDao.deleteParticipationsByStudentId(studentId);
        studentDao.deleteStudent(studentId);
    }

    @Override
    public List<Student> searchStudents(String keyword) {
        return studentDao.searchStudents(keyword);
    }
}
