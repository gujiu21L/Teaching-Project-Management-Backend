package com.gujiu21l.tp.dao.impl;

import com.gujiu21l.tp.dao.BaseDao;
import com.gujiu21l.tp.dao.StudentDao;
import com.gujiu21l.tp.pojo.Student;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM Student";
        return baseQuery(Student.class, sql);
    }

    @Override
    public Student getStudentById(int studentId) {
        String sql = "SELECT * FROM Student WHERE StudentID = ?";
        return baseQueryObject(Student.class, sql, studentId);
    }

    @Override
    public Student getStudentByEmail(String email) {
        String sql = "SELECT * FROM Student WHERE Email = ?";
        return baseQueryObject(Student.class, sql, email);
    }

    @Override
    public int addStudent(Student student) {
        String sql = "INSERT INTO Student (Name, Email, Major) VALUES (?, ?, ?)";
        return baseUpdate(sql, student.getName(), student.getEmail(), student.getMajor());
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "UPDATE Student SET Name = ?, Email = ?, Major = ? WHERE StudentID = ?";
        return baseUpdate(sql, student.getName(), student.getEmail(), student.getMajor(), student.getStudentID());
    }

    @Override
    public int deleteStudent(int studentId) {
        String sql = "DELETE FROM Student WHERE StudentID = ?";
        return baseUpdate(sql, studentId);
    }

    @Override
    public List<Student> searchStudents(String keyword) {
        String sql = "SELECT * FROM Student WHERE StudentID LIKE ? OR Name LIKE ? OR Email LIKE ? OR Major LIKE ?";
        String searchKeyword = "%" + keyword + "%";
        return baseQuery(Student.class, sql, searchKeyword, searchKeyword, searchKeyword, searchKeyword);
    }
}
