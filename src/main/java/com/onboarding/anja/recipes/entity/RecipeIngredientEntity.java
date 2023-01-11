package com.onboarding.anja.recipes.entity;

import javax.persistence.*;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RecipeEntity recipe;

    @ManyToOne
    private IngredientEntity ingredient;

    @Column
    private Integer quantity;

    public RecipeIngredientEntity() {
    }

    public RecipeIngredientEntity(Long id, RecipeEntity recipe, IngredientEntity ingredient, Integer quantity) {
        this.id = id;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public IngredientEntity getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientEntity ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
