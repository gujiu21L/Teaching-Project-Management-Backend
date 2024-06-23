package com.gujiu21l.tp.controller;

import com.gujiu21l.tp.common.Result;
import com.gujiu21l.tp.pojo.ProjectParticipation;
import com.gujiu21l.tp.service.ProjectParticipationService;
import com.gujiu21l.tp.service.impl.ProjectParticipationServiceImpl;
import com.gujiu21l.tp.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/participation/*")
public class ProjectParticipationController extends BaseController {
    private ProjectParticipationService participationService = new ProjectParticipationServiceImpl();

    public void getAllParticipations(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProjectParticipation> participations = participationService.getAllParticipations();
        Result<List<ProjectParticipation>> result = Result.ok(participations);
        WebUtil.writeJson(resp, result);
    }

    public void getParticipationById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int participationId = Integer.parseInt(req.getParameter("participationId"));
        ProjectParticipation participation = participationService.getParticipationById(participationId);
        Result<ProjectParticipation> result = Result.ok(participation);
        WebUtil.writeJson(resp, result);
    }

    public void addParticipation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectParticipation participation = WebUtil.readJson(req, ProjectParticipation.class);
        int rows = participationService.addParticipation(participation);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void updateParticipation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectParticipation participation = WebUtil.readJson(req, ProjectParticipation.class);
        int rows = participationService.updateParticipation(participation);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void deleteParticipation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int participationId = Integer.parseInt(req.getParameter("participationId"));
        int rows = participationService.deleteParticipation(participationId);
        Result<Integer> result = Result.ok(rows);
        WebUtil.writeJson(resp, result);
    }

    public void getParticipationsByProjectId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        List<ProjectParticipation> participations = participationService.getParticipationsByProjectId(projectId);
        Result<List<ProjectParticipation>> result = Result.ok(participations);
        WebUtil.writeJson(resp, result);
    }

    public void getParticipationsByStudentId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        List<ProjectParticipation> participations = participationService.getParticipationsByStudentId(studentId);
        Result<List<ProjectParticipation>> result = Result.ok(participations);
        WebUtil.writeJson(resp, result);
    }
}
