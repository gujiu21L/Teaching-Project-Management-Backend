package com.gujiu21l.tp.service;

import com.gujiu21l.tp.pojo.ProjectParticipation;

import java.util.List;

public interface ProjectParticipationService {
    List<ProjectParticipation> getAllParticipations();
    ProjectParticipation getParticipationById(int participationId);
    int addParticipation(ProjectParticipation participation);
    int updateParticipation(ProjectParticipation participation);
    int deleteParticipation(int participationId);
    List<ProjectParticipation> getParticipationsByProjectId(int projectId);
    List<ProjectParticipation> getParticipationsByStudentId(int studentId);
}
