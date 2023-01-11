package com.onboarding.anja.recipes.entity;

import javax.persistence.*;

@Entity
@Table(name = "ingredient_details")
public class IngredientDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer numberOfCalories;
    @Column
    private Double fats;
    @Column
    private Double salt;
    @Column
    private Double carbohydrates;

    @OneToOne(mappedBy = "details") //how you
    private IngredientEntity ingredient;

    public IngredientDetailsEntity() {

    }

    public IngredientDetailsEntity(Long id, Integer numberOfCalories, Double fats, Double salt, Double carbohydrates) {
        this.id = id;
        this.numberOfCalories = numberOfCalories;
        this.fats = fats;
        this.salt = salt;
        this.carbohydrates = carbohydrates;
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

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public Double getSalt() {
        return salt;
    }

    public void setSalt(Double salt) {
        this.salt = salt;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public IngredientEntity getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientEntity ingredient) {
        this.ingredient = ingredient;
    }
}
