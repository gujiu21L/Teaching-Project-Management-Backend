package com.gujiu21l.tp.dao.impl;

import com.gujiu21l.tp.dao.BaseDao;
import com.gujiu21l.tp.dao.ProjectDao;
import com.gujiu21l.tp.pojo.Project;

import java.util.List;

public class ProjectDaoImpl extends BaseDao implements ProjectDao {
    @Override
    public List<Project> getAllProjects() {
        String sql = "SELECT * FROM Project";
        return baseQuery(Project.class, sql);
    }

    @Override
    public Project getProjectById(int projectId) {
        String sql = "SELECT * FROM Project WHERE ProjectID = ?";
        return baseQueryObject(Project.class, sql, projectId);
    }

    @Override
    public int addProject(Project project) {
        String sql = "INSERT INTO Project (ProjectName, StartDate, EndDate, TeacherID) VALUES (?, ?, ?, ?)";
        return baseUpdate(sql, project.getProjectName(), project.getStartDate(), project.getEndDate(), project.getTeacherID());
    }

    @Override
    public int updateProject(Project project) {
        String sql = "UPDATE Project SET ProjectName = ?, StartDate = ?, EndDate = ?, TeacherID = ? WHERE ProjectID = ?";
        return baseUpdate(sql, project.getProjectName(), project.getStartDate(), project.getEndDate(), project.getTeacherID(), project.getProjectID());
    }

    @Override
    public int deleteProject(int projectId) {
        String sql = "DELETE FROM Project WHERE ProjectID = ?";
        return baseUpdate(sql, projectId);
    }

    @Override
    public List<Project> searchProjects(String keyword) {
        String sql = "SELECT * FROM Project WHERE ProjectID LIKE ? OR ProjectName LIKE ? OR TeacherID LIKE ?";
        String searchKeyword = "%" + keyword + "%";
        return baseQuery(Project.class, sql, searchKeyword, searchKeyword, searchKeyword);
    }

    @Override
    public List<Project> getProjectsByTeacherId(int teacherId) {
        String sql = "SELECT * FROM Project WHERE TeacherID = ?";
        return baseQuery(Project.class, sql, teacherId);
    }
}
