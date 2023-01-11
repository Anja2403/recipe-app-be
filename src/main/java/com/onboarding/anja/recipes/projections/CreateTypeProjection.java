package com.onboarding.anja.recipes.projections;

public class CreateTypeProjection {
    private String mobileNumber;
    private String homeNumber;

    private Long userId;

    public CreateTypeProjection() {
    }

    public CreateTypeProjection(String mobileNumber, String homeNumber, Long userId) {
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
