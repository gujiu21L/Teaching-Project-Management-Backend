package com.gujiu21l.tp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectParticipation implements Serializable {
    private int ParticipationID;
    private int ProjectID;
    private int StudentID;
    private String Role;
}