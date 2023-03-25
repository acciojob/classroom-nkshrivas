package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    StudentRepository sr=new StudentRepository();
    public void addStudent(Student st) {
        sr.addStudent(st);
    }
    public void addTeacher(Teacher teacher) {
        sr.addTeacher(teacher);
    }

    public void addTeacherStudentPair(String student, String teacher) {
        sr.addStudentTeacher(student,teacher);

    }

    public Student getStudent(String name) {
       return sr.getStudent(name);
    }

    public Teacher getTeacher(String name) {
        return sr.getTeacher(name);
    }

    public List<String> getStudentByTeacherName(String teacher) {
        List<String> stud= sr.getStudentByTeacherName(teacher);
        return stud;
    }

    public List<String> getAllStudent() {
        return sr.getAllStudent();
    }

    public void deleteTeacherByName(String teacher) {
        sr.deleteTeacherByName(teacher);
    }

    public void deleteAllTeacher() {
        sr.deleteAllTeacher();
    }
}
