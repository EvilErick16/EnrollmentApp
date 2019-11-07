package com.csuf.cpsc411.enrollmentapp.Model;

import java.util.ArrayList;

public class StudentEnrollments {
    // Data
    private static final StudentEnrollments ourInstance = new StudentEnrollments();
    private ArrayList<Student> mStudents;

    // Constructor
    private StudentEnrollments(){
        createStudentObjects();
    }

    // Setters and Getters
    static public StudentEnrollments getInstance() {
        return ourInstance;
    }

    public ArrayList<Student> getStudents() {
        return mStudents;
    }

    public void setStudents(ArrayList<Student> students){
        this.mStudents = students;
    }

    private void createStudentObjects(){
        mStudents = new ArrayList<>();

        Student s1 = new Student("Erick", "Juarez", 890);
        Student s2 = new Student("Jane", "Smith", 891);
        Student s3 = new Student("John", "Cena", 892);
        Student s4 = new Student("Randy", "Webb", 893);

        mStudents.add(s1);
        mStudents.add(s2);
        mStudents.add(s3);
        mStudents.add(s4);
    }
}
