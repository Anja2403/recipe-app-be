package com.onboarding.anja.recipes.projections;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CreateRecipeProjection {
    @NotNull// if it is not empty everything is ok
    private String description;

    @NotNull
    private Long userId;

    private List<CreateIngredientListProjection> ingredients; // we will provide just id of ingredient (Long)

    public CreateRecipeProjection() {
    }

    public CreateRecipeProjection(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CreateIngredientListProjection> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<CreateIngredientListProjection> ingredients) {
        this.ingredients = ingredients;
    }
}
