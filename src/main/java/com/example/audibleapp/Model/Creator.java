package com.example.audibleapp.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "creator")
public class Creator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creator_ID")
    private int creatorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "bio")
    private String bio;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "nationality")
    private String nationality;

    // Constructors
    public Creator() {
    }

    public Creator(String name, String password, String bio, String qualification, String nationality) {
        this.name = name;
        this.password = password;
        this.bio = bio;
        this.qualification = qualification;
        this.nationality = nationality;
    }

    // Getters and Setters
    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "creatorId=" + creatorId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                ", qualification='" + qualification + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}