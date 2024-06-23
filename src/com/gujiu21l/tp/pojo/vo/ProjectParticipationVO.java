package com.gujiu21l.tp.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectParticipationVO implements Serializable {
    private int ParticipationID;
    private int ProjectID;
    private String ProjectName;
    private int StudentID;
    private String StudentName;
    private String Role;
}
