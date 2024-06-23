package com.gujiu21l.tp.service.impl;

import com.gujiu21l.tp.dao.impl.ProjectDaoImpl;
import com.gujiu21l.tp.pojo.Project;
import com.gujiu21l.tp.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private ProjectDaoImpl projectDao = new ProjectDaoImpl();

    @Override
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @Override
    public Project getProjectById(int projectId) {
        return projectDao.getProjectById(projectId);
    }

    @Override
    public int addProject(Project project) {
        return projectDao.addProject(project);
    }

    @Override
    public int updateProject(Project project) {
        return projectDao.updateProject(project);
    }

    @Override
    public int deleteProject(int projectId) {
        return projectDao.deleteProject(projectId);
    }

    @Override
    public List<Project> searchProjects(String keyword) {
        return projectDao.searchProjects(keyword);
    }
}
