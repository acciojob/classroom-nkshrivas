package com.driver;

import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    
    HashMap<String,Student> studentDb=new HashMap<>();
    HashMap<String,Teacher> teacherDb=new HashMap<>();
    HashMap<Student,Teacher> pairDb=new HashMap<>();


    public void addStudent(Student student){
        studentDb.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherDb.put(teacher.getName(),teacher);
    }
    
    public void addStudentTeacher(String student,String teacher){
        pairDb.put(studentDb.get(student),teacherDb.get(teacher));
    }

    public Student getStudent(String name) {
        return studentDb.get(name);
    }

    public Teacher getTeacher(String name) {
        return teacherDb.get(name);
    }

    public List<String> getStudentByTeacherName(String teacher) {
        List<String> stu=new ArrayList<>();

        for(Map.Entry<Student, Teacher> entry:pairDb.entrySet()){
            if(entry.getValue().getName().equals(teacher)){
                stu.add(entry.getKey().getName());
            }
        }
        return stu;

    }

    public List<String> getAllStudent() {
       return studentDb.keySet().stream().toList();
    }

    public void deleteTeacherByName(String teacher) {
        for(Map.Entry<Student, Teacher> entry:pairDb.entrySet()){
            if(entry.getValue().equals(teacher)){
                studentDb.remove(entry.getKey().getName());
                pairDb.remove(entry.getKey().getName());
                System.out.println("everything remove");
            }
        }
        teacherDb.remove(teacher);
    }

    public void deleteAllTeacher() {
        teacherDb.clear();
    }
}
