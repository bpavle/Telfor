package com.etf.telfor.data;

public class Section {
    int sectionId=-1;
    String title;

    public Section() {
    }

    public Section(int sectionId, String title) {
        this.sectionId = sectionId;
        this.title = title;
    }

    public Section(String title) {
        this.title = title;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
