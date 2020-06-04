package com.etf.telfor.data;

public class Session {
    int sessionId=-1;
    String room;
    String dateTime;
    Section section;
    Chairperson chairperson;
    AuthorPaper authorPaper;

    public Session() {
    }

    public Session(String room, String dateTime, Section section, Chairperson chairperson, AuthorPaper authorPaper) {
        this.room = room;
        this.dateTime = dateTime;
        this.section = section;
        this.chairperson = chairperson;
        this.authorPaper = authorPaper;
    }

    public Session(int sessionId, String room, String dateTime, Section section, Chairperson chairperson, AuthorPaper authorPaper) {
        this.sessionId = sessionId;
        this.room = room;
        this.dateTime = dateTime;
        this.section = section;
        this.chairperson = chairperson;
        this.authorPaper = authorPaper;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Chairperson getChairperson() {
        return chairperson;
    }

    public void setChairperson(Chairperson chairperson) {
        this.chairperson = chairperson;
    }

    public AuthorPaper getAuthorPaper() {
        return authorPaper;
    }

    public void setAuthorPaper(AuthorPaper authorPaper) {
        this.authorPaper = authorPaper;
    }
}
