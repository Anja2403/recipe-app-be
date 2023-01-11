package com.onboarding.anja.recipes.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "recipe") // one recipe will have many connections
    private Set<RecipeIngredientEntity> ingredients = new HashSet<>(); // empty Set



    public RecipeEntity() {
    }

    public RecipeEntity(Long id, String description) {
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


    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<RecipeIngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<RecipeIngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }
}
