package com.onboarding.anja.recipes.projections;

public class IngredientWithQuantityProjection extends IngredientProjection{
    // we need everything in IngredientProjection too
    // we added the field quantity
    private Integer quantity;

    public IngredientWithQuantityProjection() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
