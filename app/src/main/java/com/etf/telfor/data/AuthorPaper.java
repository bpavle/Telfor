package com.etf.telfor.data;

public class AuthorPaper {
    int authorPaperId=-1;
    Author author;
    Paper paper;
    String index;

    public AuthorPaper() {
    }

    public AuthorPaper(Author author, Paper paper, String index) {
        this.author = author;
        this.paper = paper;
        this.index = index;
    }

    public AuthorPaper(int authorPaperId, Author author, Paper paper, String index) {
        this.authorPaperId = authorPaperId;
        this.author = author;
        this.paper = paper;
        this.index = index;
    }

    public int getAuthorPaperId() {
        return authorPaperId;
    }

    public void setAuthorPaperId(int authorPaperId) {
        this.authorPaperId = authorPaperId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
