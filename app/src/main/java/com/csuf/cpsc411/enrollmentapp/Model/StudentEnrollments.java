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

    public void addStudent(Student student){
        this.mStudents.add(student);
    }

    public int getLastIndex(){
       return mStudents.size() - 1;
    }

    public ArrayList<Vehicle> getStudentCars(int index){
        return mStudents.get(index).getVehicles();
    }

    private void createStudentObjects(){
        mStudents = new ArrayList<>();
        ArrayList<Vehicle> cars = new ArrayList<>();

        Student s1 = new Student("Erick", "Juarez", 890);
        Student s2 = new Student("Jane", "Smith", 891);
        Student s3 = new Student("John", "Cena", 892);
        Student s4 = new Student("Randy", "Webb", 893);

        mStudents.add(s1);
        mStudents.add(s2);
        mStudents.add(s3);
        mStudents.add(s4);

        Vehicle v1 = new Vehicle("Toyota", "Corolla", 2004);
        cars.add(v1);
        s1.setVehicles(cars);

        cars = new ArrayList<>();
        Vehicle v2 = new Vehicle("BMW", "M2", 2017);
        Vehicle v3 = new Vehicle("Lexus", "LFA", 2015);
        cars.add(v2);
        cars.add(v3);
        s2.setVehicles(cars);
    }
}
