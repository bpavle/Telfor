package com.etf.telfor.data;

public class Author {

    private int authorId = -1;
    private String firstName;
    private String lastName;
    private String username;
    private String country;
    private String institution;

    public Author(){};
    public Author(int authorId,String firstName,String lastName,String username,String country,String institution){
        this.authorId= authorId;
        this.firstName=firstName;
        this.lastName = lastName;
        this.username = username;
        this.country=country;
        this.institution=institution;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Author(String firstName, String lastName, String username, String country, String institution){

        this.firstName=firstName;
        this.lastName = lastName;
        this.username = username;

        this.country=country;
        this.institution=institution;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
