package com.gujiu21l.tp.dao;

import com.gujiu21l.tp.pojo.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> getAllProjects();
    Project getProjectById(int projectId);
    int addProject(Project project);
    int updateProject(Project project);
    int deleteProject(int projectId);
    List<Project> searchProjects(String keyword);
    List<Project> getProjectsByTeacherId(int teacherId);
}
