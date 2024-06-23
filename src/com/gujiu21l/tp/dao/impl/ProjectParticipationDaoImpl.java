package com.gujiu21l.tp.dao.impl;

import com.gujiu21l.tp.dao.BaseDao;
import com.gujiu21l.tp.dao.ProjectParticipationDao;
import com.gujiu21l.tp.pojo.ProjectParticipation;

import java.util.List;

public class ProjectParticipationDaoImpl extends BaseDao implements ProjectParticipationDao {
    @Override
    public List<ProjectParticipation> getAllParticipations() {
        String sql = "SELECT * FROM ProjectParticipation";
        return baseQuery(ProjectParticipation.class, sql);
    }

    @Override
    public ProjectParticipation getParticipationById(int participationId) {
        String sql = "SELECT * FROM ProjectParticipation WHERE ParticipationID = ?";
        return baseQueryObject(ProjectParticipation.class, sql, participationId);
    }

    @Override
    public int addParticipation(ProjectParticipation participation) {
        String sql = "INSERT INTO ProjectParticipation (ProjectID, StudentID, Role) VALUES (?, ?, ?)";
        return baseUpdate(sql, participation.getProjectID(), participation.getStudentID(), participation.getRole());
    }

    @Override
    public int updateParticipation(ProjectParticipation participation) {
        String sql = "UPDATE ProjectParticipation SET ProjectID = ?, StudentID = ?, Role = ? WHERE ParticipationID = ?";
        return baseUpdate(sql, participation.getProjectID(), participation.getStudentID(), participation.getRole(), participation.getParticipationID());
    }

    @Override
    public int deleteParticipation(int participationId) {
        String sql = "DELETE FROM ProjectParticipation WHERE ParticipationID = ?";
        return baseUpdate(sql, participationId);
    }

    @Override
    public List<ProjectParticipation> getParticipationsByProjectId(int projectId) {
        String sql = "SELECT * FROM ProjectParticipation WHERE ProjectID = ?";
        return baseQuery(ProjectParticipation.class, sql, projectId);
    }

    @Override
    public List<ProjectParticipation> getParticipationsByStudentId(int studentId) {
        String sql = "SELECT * FROM ProjectParticipation WHERE StudentID = ?";
        return baseQuery(ProjectParticipation.class, sql, studentId);
    }

    @Override
    public void deleteParticipationsByStudentId(int studentId) {
        String sql = "DELETE FROM ProjectParticipation WHERE StudentID = ?";
        baseUpdate(sql, studentId);
    }

    @Override
    public void deleteParticipationsByProjectId(int projectID) {
        String sql = "DELETE FROM ProjectParticipation WHERE ProjectID = ?";
        baseUpdate(sql, projectID);
    }
}
