package com.onboarding.anja.recipes.projections;

import org.apache.tomcat.jni.Address;

public class UserWithoutTypesProjection {
    private Long id;
    private String firstName;
    private String LastName;

    private AddressProjection address;

    public UserWithoutTypesProjection() {
    }

    public UserWithoutTypesProjection(Long id, String firstName, String lastName, AddressProjection address) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public AddressProjection getAddress() {
        return address;
    }

    public void setAddress(AddressProjection address) {
        this.address = address;
    }
}
