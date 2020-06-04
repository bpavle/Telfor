package com.etf.telfor.data;

public class Chairperson {
    int chairpersonId=-1;
    String firstName;
    String lastName;

    public Chairperson(int chairpersonId, String firstName, String lastName) {
        this.chairpersonId = chairpersonId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Chairperson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Chairperson() {
    }

    public int getChairpersonId() {
        return chairpersonId;
    }

    public void setChairpersonId(int chairpersonId) {
        this.chairpersonId = chairpersonId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
