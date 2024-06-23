package com.gujiu21l.tp.service.impl;

import com.gujiu21l.tp.dao.ProjectParticipationDao;
import com.gujiu21l.tp.dao.impl.ProjectParticipationDaoImpl;
import com.gujiu21l.tp.pojo.ProjectParticipation;
import com.gujiu21l.tp.service.ProjectParticipationService;

import java.util.List;

public class ProjectParticipationServiceImpl implements ProjectParticipationService {
    private ProjectParticipationDao participationDao = new ProjectParticipationDaoImpl();

    @Override
    public List<ProjectParticipation> getAllParticipations() {
        return participationDao.getAllParticipations();
    }

    @Override
    public ProjectParticipation getParticipationById(int participationId) {
        return participationDao.getParticipationById(participationId);
    }

    @Override
    public int addParticipation(ProjectParticipation participation) {
        return participationDao.addParticipation(participation);
    }

    @Override
    public int updateParticipation(ProjectParticipation participation) {
        return participationDao.updateParticipation(participation);
    }

    @Override
    public int deleteParticipation(int participationId) {
        return participationDao.deleteParticipation(participationId);
    }

    @Override
    public List<ProjectParticipation> getParticipationsByProjectId(int projectId) {
        return participationDao.getParticipationsByProjectId(projectId);
    }

    @Override
    public List<ProjectParticipation> getParticipationsByStudentId(int studentId) {
        return participationDao.getParticipationsByStudentId(studentId);
    }
}
