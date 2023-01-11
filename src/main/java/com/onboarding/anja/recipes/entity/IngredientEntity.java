package com.onboarding.anja.recipes.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;



    @OneToOne
    @JoinColumn(name = "details_id")
    private IngredientDetailsEntity details;

    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredientEntity> recipe = new HashSet<>();


    public IngredientEntity() {
    }

    public IngredientEntity(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public IngredientDetailsEntity getDetails() {
        return details;
    }

    public void setDetails(IngredientDetailsEntity details) {
        this.details = details;
    }

    public Set<RecipeIngredientEntity> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<RecipeIngredientEntity> recipe) {
        this.recipe = recipe;
    }
}
