package com.example.eunjong.swfestival;

public class User {

    String userID;
    String userPassword;
    String userName;
    String userStudentNumber;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStudentNumber() {
        return userStudentNumber;
    }

    public void setUserStudentNumber(String userStudentNumber) {
        this.userStudentNumber = userStudentNumber;
    }

    public User(String userID, String userPassword, String userName, String userStudentNumber) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userStudentNumber = userStudentNumber;
    }
}
