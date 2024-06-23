package com.gujiu21l.tp.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentVO implements Serializable {
    private int StudentID;
    private String Name;
    private String Email;
    private String Major;
    private int ParticipationCount; // 学生参与的项目数量
}
