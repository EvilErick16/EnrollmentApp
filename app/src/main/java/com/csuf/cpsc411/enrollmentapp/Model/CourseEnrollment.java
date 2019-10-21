package com.csuf.cpsc411.enrollmentapp.Model;

public class CourseEnrollment {
    // Course Information
    private String mCourseId;
    private String mGrade;

    // Constructor
    public CourseEnrollment(String courseId, String grade) {
        this.mCourseId = courseId;
        this.mGrade = grade;
    }

    // Get and Set functions
    public String getCourseId() {
        return mCourseId;
    }

    public void setCourseId(String courseId) {
        this.mCourseId = courseId;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        this.mGrade = grade;
    }
}
