package com.uyghur.thymeleafdemo.model;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;

    private String country;
    private String favorateLanguage;
    private List<String> os;


    public Student(){

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavorateLanguage() {
        return favorateLanguage;
    }

    public void setFavorateLanguage(String favorateLanguage) {
        this.favorateLanguage = favorateLanguage;
    }

    public List<String> getOs() {
        return os;
    }

    public void setOs(List<String> os) {
        this.os = os;
    }
}
