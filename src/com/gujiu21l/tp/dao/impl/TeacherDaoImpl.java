package com.gujiu21l.tp.dao.impl;

import com.gujiu21l.tp.dao.BaseDao;
import com.gujiu21l.tp.dao.TeacherDao;
import com.gujiu21l.tp.pojo.Teacher;
import com.gujiu21l.tp.util.JDBCUtil;

import java.util.List;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {
    @Override
    public List<Teacher> getAllTeachers() {
        String sql = "SELECT * FROM Teacher";
        return baseQuery(Teacher.class, sql);
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        String sql = "SELECT * FROM Teacher WHERE TeacherID = ?";
        return baseQueryObject(Teacher.class, sql, teacherId);
    }

    @Override
    public Teacher getTeacherByEmail(String email) {
        String sql = "SELECT * FROM Teacher WHERE Email = ?";
        return baseQueryObject(Teacher.class, sql, email);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        String sql = "INSERT INTO Teacher (Name, Email, Department) VALUES (?, ?, ?)";
        return baseUpdate(sql, teacher.getName(), teacher.getEmail(), teacher.getDepartment());
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        String sql = "UPDATE Teacher SET Name = ?, Email = ?, Department = ? WHERE TeacherID = ?";
        return baseUpdate(sql, teacher.getName(), teacher.getEmail(), teacher.getDepartment(), teacher.getTeacherID());
    }

    @Override
    public int deleteTeacher(int teacherId) {
        String sql = "DELETE FROM Teacher WHERE TeacherID = ?";
        return baseUpdate(sql, teacherId);
    }

    @Override
    public List<Teacher> searchTeachers(String keyword) {
        String sql = "SELECT * FROM Teacher WHERE TeacherID LIKE ? OR Name LIKE ? OR Email LIKE ? OR Department LIKE ?";
        String searchKeyword = "%" + keyword + "%";
        return baseQuery(Teacher.class, sql, searchKeyword, searchKeyword, searchKeyword, searchKeyword);
    }
}
