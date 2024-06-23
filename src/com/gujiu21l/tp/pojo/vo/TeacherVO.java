package com.gujiu21l.tp.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherVO implements Serializable {
    private int TeacherID;
    private String Name;
    private String Email;
    private String Department;
    private int ProjectCount; // 教师参与的项目数量
}
