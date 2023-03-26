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
    HashMap<String,List<String>> teacherStudent = new HashMap<>();


    public void addStudent(Student student){
        studentDb.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherDb.put(teacher.getName(),teacher);
    }
    
    public void addStudentTeacher(String student,String teacher){
        List<String> students = teacherStudent.get(teacher);

        if(students==null){
            students = new ArrayList<>();
        }

        students.add(student);

        teacherStudent.put(teacher,students);


        return ;
    }

    public Student getStudent(String name) {
        return studentDb.get(name);
    }

    public Teacher getTeacher(String name) {
        return teacherDb.get(name);
    }

    public List<String> getStudentByTeacherName(String teacher) {
        return teacherStudent.get(teacher);
    }

    public List<String> getAllStudent() {
        List<String> allSrtudents=new ArrayList<>();
        for(Map.Entry<String,Student> entry:studentDb.entrySet()){
            allSrtudents.add(entry.getKey());
        }

       return allSrtudents;
    }

    public void deleteTeacherByName(String teacher) {
        for(String str : teacherStudent.get(teacher)){

            studentDb.remove(str);

        }
        teacherStudent.remove(teacher);
        teacherDb.remove(teacher);
    }

    public void deleteAllTeacher() {
        for(String teacher : teacherDb.keySet())
        {
            for(String str : teacherStudent.get(teacher)){

                studentDb.remove(str);

            }
            teacherStudent.remove(teacher);
            teacherDb.remove(teacher);

        }
    }
}
