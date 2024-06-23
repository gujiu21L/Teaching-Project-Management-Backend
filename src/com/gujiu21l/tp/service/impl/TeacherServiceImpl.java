package com.gujiu21l.tp.service.impl;

import com.gujiu21l.tp.dao.impl.TeacherDaoImpl;
import com.gujiu21l.tp.dao.impl.ProjectDaoImpl;
import com.gujiu21l.tp.dao.impl.ProjectParticipationDaoImpl;
import com.gujiu21l.tp.pojo.Project;
import com.gujiu21l.tp.pojo.Teacher;
import com.gujiu21l.tp.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDaoImpl teacherDao = new TeacherDaoImpl();
    private ProjectDaoImpl projectDao = new ProjectDaoImpl();
    private ProjectParticipationDaoImpl participationDao = new ProjectParticipationDaoImpl();

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        return teacherDao.getTeacherById(teacherId);
    }

    @Override
    public Teacher getTeacherByEmail(String email) {
        return teacherDao.getTeacherByEmail(email);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public int deleteTeacher(int teacherId) {
        return teacherDao.deleteTeacher(teacherId);
    }

    @Override
    public void deleteTeacherCascade(int teacherId) {
        List<Project> projects = projectDao.getProjectsByTeacherId(teacherId);
        for (Project project : projects) {
            participationDao.deleteParticipationsByProjectId(project.getProjectID());
            projectDao.deleteProject(project.getProjectID());
        }
        teacherDao.deleteTeacher(teacherId);
    }

    @Override
    public List<Teacher> searchTeachers(String keyword) {
        return teacherDao.searchTeachers(keyword);
    }
}
