package com.gujiu21l.tp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Serializable {
    private int StudentID;
    private String Name;
    private String Email;
    private String Major;
}