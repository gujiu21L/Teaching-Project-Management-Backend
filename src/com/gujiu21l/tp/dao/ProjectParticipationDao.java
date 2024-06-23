package com.gujiu21l.tp.dao;

import com.gujiu21l.tp.pojo.ProjectParticipation;

import java.util.List;

public interface ProjectParticipationDao {
    List<ProjectParticipation> getAllParticipations();
    ProjectParticipation getParticipationById(int participationId);
    int addParticipation(ProjectParticipation participation);
    int updateParticipation(ProjectParticipation participation);
    int deleteParticipation(int participationId);
    List<ProjectParticipation> getParticipationsByProjectId(int projectId);
    List<ProjectParticipation> getParticipationsByStudentId(int studentId);

    void deleteParticipationsByStudentId(int studentId);

    void deleteParticipationsByProjectId(int projectID);
}
