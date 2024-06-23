package com.gujiu21l.tp.controller;

import com.gujiu21l.tp.common.Result;
import com.gujiu21l.tp.pojo.Project;
import com.gujiu21l.tp.pojo.vo.ProjectVO;
import com.gujiu21l.tp.service.ProjectService;
import com.gujiu21l.tp.service.impl.ProjectServiceImpl;
import com.gujiu21l.tp.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/project/*")
public class ProjectController extends BaseController {
    private ProjectService projectService = new ProjectServiceImpl();

    public void getAllProjects(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Project> projects = projectService.getAllProjects();
        Result<List<Project>> result = Result.ok(projects);
        WebUtil.writeJson(resp, result);
    }

    public void getProjectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        Project project = projectService.getProjectById(projectId);
        Result<Project> result = Result.ok(project);
        WebUtil.writeJson(resp, result);
    }

    public void addProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectVO projectVO = WebUtil.readJson(req, ProjectVO.class);
        Date startDate = convertToDate(projectVO.getStartDate());
        Date endDate = convertToDate(projectVO.getEndDate());
        Project project = new Project(
                projectVO.getProjectID(),
                projectVO.getProjectName(),
                startDate,
                endDate,
                Integer.parseInt(projectVO.getTeacherID())
        );
        int rows = projectService.addProject(project);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void updateProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectVO projectVO = WebUtil.readJson(req, ProjectVO.class);
        Date startDate = convertToDate(projectVO.getStartDate());
        Date endDate = convertToDate(projectVO.getEndDate());
        Project project = new Project(
                projectVO.getProjectID(),
                projectVO.getProjectName(),
                startDate,
                endDate,
                Integer.parseInt(projectVO.getTeacherID())
        );
        int rows = projectService.updateProject(project);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void deleteProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        int rows = projectService.deleteProject(projectId);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void searchProjects(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Project> projects = projectService.searchProjects(keyword);
        Result<List<Project>> result = Result.ok(projects);
        WebUtil.writeJson(resp, result);
    }

    private Date convertToDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new Date(format.parse(dateStr).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
