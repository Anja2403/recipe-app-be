package com.onboarding.anja.recipes.projections;

import java.util.List;

public class RecipeProjection {
    private Long id;
    private String description;

    private UserWithoutRecipesProjection user;

    private List<IngredientWithQuantityProjection> ingredients;

    public RecipeProjection() {
    }

    public RecipeProjection(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserWithoutRecipesProjection getUser() {
        return user;
    }

    public void setUser(UserWithoutRecipesProjection user) {
        this.user = user;
    }

    public List<IngredientWithQuantityProjection> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientWithQuantityProjection> ingredients) {
        this.ingredients = ingredients;
    }
}
