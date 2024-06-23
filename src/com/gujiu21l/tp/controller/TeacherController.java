package com.gujiu21l.tp.controller;

import com.gujiu21l.tp.common.Result;
import com.gujiu21l.tp.common.ResultCodeEnum;
import com.gujiu21l.tp.pojo.Teacher;
import com.gujiu21l.tp.service.ProjectService;
import com.gujiu21l.tp.service.TeacherService;
import com.gujiu21l.tp.service.impl.ProjectServiceImpl;
import com.gujiu21l.tp.service.impl.TeacherServiceImpl;
import com.gujiu21l.tp.util.JwtHelper;
import com.gujiu21l.tp.util.MD5Util;
import com.gujiu21l.tp.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/teacher/*")
public class TeacherController extends BaseController {
    private TeacherService teacherService = new TeacherServiceImpl();
    private ProjectService projectService = new ProjectServiceImpl();
    private static final Logger logger = Logger.getLogger(TeacherController.class.getName());

    public void getAllTeachers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teachers = teacherService.getAllTeachers();
        Result<List<Teacher>> result = Result.ok(teachers);
        WebUtil.writeJson(resp, result);
    }

    public void getTeacherById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int teacherId = Integer.parseInt(req.getParameter("teacherId"));
        Teacher teacher = teacherService.getTeacherById(teacherId);
        Result<Teacher> result = Result.ok(teacher);
        WebUtil.writeJson(resp, result);
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = WebUtil.readJson(req, Teacher.class);
        int rows = teacherService.addTeacher(teacher);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void addTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = WebUtil.readJson(req, Teacher.class);
        int rows = teacherService.addTeacher(teacher);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void updateTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = WebUtil.readJson(req, Teacher.class);
        int rows = teacherService.updateTeacher(teacher);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void deleteTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherIdStr = req.getParameter("teacherId");

        if (teacherIdStr == null || teacherIdStr.isEmpty()) {
            logger.severe("Missing or empty teacherId parameter.");
            Result<String> result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
            WebUtil.writeJson(resp, result);
            return;
        }

        try {
            int teacherId = Integer.parseInt(teacherIdStr);

            teacherService.deleteTeacherCascade(teacherId);

            Result<Integer> result = Result.ok(1);
            WebUtil.writeJson(resp, result);
        } catch (NumberFormatException e) {
            logger.severe("Invalid teacherId parameter: " + teacherIdStr);
            Result<String> result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
            WebUtil.writeJson(resp, result);
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Teacher teacher = teacherService.getTeacherByEmail(email);

        if (teacher != null && "123".equals(MD5Util.encrypt(password))) {
            String token = JwtHelper.createToken(Long.valueOf(teacher.getTeacherID()));
            Result<String> result = Result.ok(token);
            WebUtil.writeJson(resp, result);
        } else {
            Result<String> result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
            WebUtil.writeJson(resp, result);
        }
    }

    public void searchTeachers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Teacher> teachers = teacherService.searchTeachers(keyword);
        Result<List<Teacher>> result = Result.ok(teachers);
        WebUtil.writeJson(resp, result);
    }
}
