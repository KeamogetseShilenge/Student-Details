package com.example.pihestudentdetails;

public class Student {
    private String ID;
    private String firstName;
    private String lastName;
    private String contact;
    private String address;

    public Student(String ID, String firstName, String lastName, String contact, String address) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
    }

    public String getStudentID() {
        return ID;
    }

    public void setStudentID(String studentID) {
        this.ID = studentID;
    }

    public String getFName() {
        return firstName;
    }

    public void setFName(String firstName) {
        this.firstName = firstName;
    }

    public String getLName() {
        return lastName;
    }

    public void setLName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
