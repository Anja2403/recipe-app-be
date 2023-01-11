package com.onboarding.anja.recipes.entity;

import javax.persistence.*;

@Entity
@Table(name = "types")
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String mobileNumber;
    @Column
    private String homeNumber;

    @ManyToOne
    private UserEntity user;

    public TypeEntity() {
    }

    public TypeEntity(Long id, String mobileNumber, String homeNumber) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
