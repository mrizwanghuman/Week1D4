package com.example.admin.week1d4;

/**
 * Created by  Admin on 11/9/2017.
 */

public class Person {
    String FirstName;
    String Lastname;

    public Person(String firstName, String lastname) {
        FirstName = firstName;
        Lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FirstName='" + FirstName + '\'' +
                ", Lastname='" + Lastname + '\'' +
                '}';
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }
}
