package com.gujiu21l.tp.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectVO implements Serializable {
    private int ProjectID;
    private String ProjectName;
    private String StartDate;
    private String EndDate;
    private String TeacherID;
}
