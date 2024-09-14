package com.example.pract2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class workerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Size(max = 20, min = 3, message = "От 3 до 20 символов")
    private String Name;
    @Size(max = 20, min = 5, message = "От 5 до 20 символов")
    private String LastName;
    @Size(max = 20, min = 5, message = "От 5 до 20 символов")
    private String FirstName;
    @Size(max = 20, min = 1, message = "От 1 до 20 символов")
    private String Job;




    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }
}

