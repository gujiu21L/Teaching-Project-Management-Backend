package com.gujiu21l.tp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher implements Serializable {
    private int TeacherID;
    private String Name;
    private String Email;
    private String Department;
}
