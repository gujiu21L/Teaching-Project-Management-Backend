
package com.gujiu21l.tp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project implements Serializable {
    private int ProjectID;
    private String ProjectName;
    private Date StartDate;
    private Date EndDate;
    private int TeacherID;
}