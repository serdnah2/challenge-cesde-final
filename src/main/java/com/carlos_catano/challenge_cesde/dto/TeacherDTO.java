package com.carlos_catano.challenge_cesde.dto;

public class TeacherDTO {
    private Long id;
    private String name;
    private String document;
    private String email;

    public TeacherDTO(Long id, String name, String document, String email) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
    }

    public TeacherDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}