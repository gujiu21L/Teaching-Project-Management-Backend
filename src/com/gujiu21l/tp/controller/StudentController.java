package com.gujiu21l.tp.controller;

import com.gujiu21l.tp.common.Result;
import com.gujiu21l.tp.pojo.Student;
import com.gujiu21l.tp.service.StudentService;
import com.gujiu21l.tp.service.impl.StudentServiceImpl;
import com.gujiu21l.tp.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/student/*")
public class StudentController extends BaseController {
    private StudentService studentService = new StudentServiceImpl();

    public void getAllStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.getAllStudents();
        Result<List<Student>> result = Result.ok(students);
        WebUtil.writeJson(resp, result);
    }

    public void getStudentById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        Student student = studentService.getStudentById(studentId);
        Result<Student> result = Result.ok(student);
        WebUtil.writeJson(resp, result);
    }

    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = WebUtil.readJson(req, Student.class);
        int rows = studentService.addStudent(student);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = WebUtil.readJson(req, Student.class);
        int rows = studentService.updateStudent(student);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        studentService.deleteStudentCascade(studentId);
        Result<Integer> result = Result.ok(1);
        WebUtil.writeJson(resp, result);
    }

    public void searchStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Student> students = studentService.searchStudents(keyword);
        Result<List<Student>> result = Result.ok(students);
        WebUtil.writeJson(resp, result);
    }
}
