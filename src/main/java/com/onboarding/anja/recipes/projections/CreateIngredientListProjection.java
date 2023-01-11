package com.onboarding.anja.recipes.projections;

public class CreateIngredientListProjection {
    private Long id;
    private Integer quantity;

    public CreateIngredientListProjection() {
    }


    public CreateIngredientListProjection(Long id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
