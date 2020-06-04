package com.etf.telfor.data;

public class Paper {
    private int paperId = -1;
    private String title;
    private String paper_abstract;
    private String keywords;

    public Paper() {
    }

    public Paper(String title, String paper_abstract, String keywords) {
        this.title = title;
        this.paper_abstract = paper_abstract;
        this.keywords = keywords;
    }

    public Paper(int paperId, String title, String paper_abstract, String keywords) {
        this.paperId = paperId;
        this.title = title;
        this.paper_abstract = paper_abstract;
        this.keywords = keywords;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPaper_abstract() {
        return paper_abstract;
    }

    public void setPaper_abstract(String paper_abstract) {
        this.paper_abstract = paper_abstract;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}

