package com.onboarding.anja.recipes.projections;

import java.util.List;

public class UserProjection {
    private Long id;
    private String firstName;
    private String lastName;
    private List<RecipeProjection> recipes;
    private AddressProjection address;

    public UserProjection() {
    }

    public UserProjection(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressProjection getAddress() {
        return address;
    }

    public void setAddress(AddressProjection address) {
        this.address = address;
    }

    public List<RecipeProjection> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeProjection> recipes) {
        this.recipes = recipes;
    }
}
