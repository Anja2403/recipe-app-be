package com.onboarding.anja.recipes.projections;

public class TypeProjection {
    private Long id;
    private String mobileNumber;
    private String homeNumber;

    private UserWithoutTypesProjection user;

    public TypeProjection() {
    }

    public TypeProjection(Long id, String mobileNumber, String homeNumber, UserWithoutTypesProjection user) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.user = user;
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

    public UserWithoutTypesProjection getUser() {
        return user;
    }

    public void setUser(UserWithoutTypesProjection user) {
        this.user = user;
    }
}
