package com.onboarding.anja.recipes.projections;

public class IngredientDetailsProjection {

    private Long id;
    private Integer numberOfCalories;
    private Double carbohydrates;
    private Double salt;
    private Double fats;
    public IngredientDetailsProjection() {
    }

    public IngredientDetailsProjection(Long id, Integer numberOfCalories, Double carbohydrates, Double salt, Double fats) {
        this.id = id;
        this.numberOfCalories = numberOfCalories;
        this.carbohydrates = carbohydrates;
        this.salt = salt;
        this.fats = fats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfCalories() {
        return numberOfCalories;
    }

    public void setNumberOfCalories(Integer numberOfCalories) {
        this.numberOfCalories = numberOfCalories;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getSalt() {
        return salt;
    }

    public void setSalt(Double salt) {
        this.salt = salt;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }
}
