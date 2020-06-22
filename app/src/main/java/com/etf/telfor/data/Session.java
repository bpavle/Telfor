package com.etf.telfor.data;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author Pikacu
 */
public class Session implements Serializable {
    private int sessionId=-1;
    private String room;
    private String date;
    private Section section;
    private Chairperson chairperson;
    private Paper paper;

    public Session() {
    }

    public Session(String room, String date, Section section, Chairperson chairperson, Paper paper) {
        this.room = room;
        this.date = date;
        this.section = section;
        this.chairperson = chairperson;
        this.paper = paper;
    }

    public Session(int sessionId, String room, String date, Section section, Chairperson chairperson, Paper paper) {
        this.sessionId = sessionId;
        this.room = room;
        this.date = date;
        this.section = section;
        this.chairperson = chairperson;
        this.paper = paper;
    }



    /**
     * @return the sessionId
     */
    public int getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the section
     */
    public Section getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(Section section) {
        this.section = section;
    }

    /**
     * @return the chairperson
     */
    public Chairperson getChairperson() {
        return chairperson;
    }

    /**
     * @param chairperson the chairperson to set
     */
    public void setChairperson(Chairperson chairperson) {
        this.chairperson = chairperson;
    }

    /**
     * @return the paper
     */
    public Paper getPaper() {
        return paper;
    }

    /**
     * @param paper the paper to set
     */
    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    @Override
    public String toString() {
        return "Session{" + "sessionId=" + sessionId + ", room=" + room + ", date=" + date + ", section=" + section + ", chairperson=" + chairperson + ", paper=" + paper + '}';
    }

}
