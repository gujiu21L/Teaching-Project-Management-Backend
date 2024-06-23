package com.gujiu21l.tp.service;

import com.gujiu21l.tp.pojo.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
    Student getStudentByEmail(String email);
    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int studentId);
    void deleteStudentCascade(int studentId);
    List<Student> searchStudents(String keyword);
}
