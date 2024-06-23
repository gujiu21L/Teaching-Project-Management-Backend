package com.gujiu21l.tp.dao;

import com.gujiu21l.tp.pojo.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(int teacherId);
    Teacher getTeacherByEmail(String email);
    int addTeacher(Teacher teacher);
    int updateTeacher(Teacher teacher);
    int deleteTeacher(int teacherId);

    List<Teacher> searchTeachers(String keyword);
}
