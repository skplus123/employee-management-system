package com.springboot.ems.dto;

public class EmployeeDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String emailId;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String firstname, String lastname, String emailId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailId = emailId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
