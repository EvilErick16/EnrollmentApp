package com.csuf.cpsc411.enrollmentapp.Model;

import java.util.ArrayList;

public class Student {
    // Student information
    // Each student has first name, last name, cwid, and course enrollment information
    private String mFirstName;
    private String mLastName;
    private int mCwid;
    private ArrayList<CourseEnrollment> mCourseEnrollments;

    // Constructor
    public Student(String FirstName, String LastName, int Cwid) {
        this.mFirstName = FirstName;
        this.mLastName = LastName;
        this.mCwid = Cwid;
    }

    // Set and Get functions
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String FirstName) {
        this.mFirstName = FirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String LastName) {
        this.mLastName = LastName;
    }

    public int getCwid() {
        return mCwid;
    }

    public void setCwid(int Cwid) {
        this.mCwid = Cwid;
    }

    public ArrayList<CourseEnrollment> getCourseEnrollments(){
        return mCourseEnrollments;
    }

    public void setCourseEnrollments(ArrayList<CourseEnrollment> courseEnrollments){
        this.mCourseEnrollments = courseEnrollments;
    }
}
