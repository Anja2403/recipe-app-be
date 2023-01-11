package com.onboarding.anja.recipes.controller;

import com.onboarding.anja.recipes.entity.IngredientEntity;
import com.onboarding.anja.recipes.projections.CreateIngredientProjection;
import com.onboarding.anja.recipes.projections.IngredientProjection;
import com.onboarding.anja.recipes.projections.UserProjection;
import com.onboarding.anja.recipes.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin("http://localhost:3000")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    public IngredientProjection createIngredient(@RequestBody CreateIngredientProjection request) {
        return ingredientService.createIngredient(request);
    }

    @GetMapping
    public List<IngredientProjection> findAll() {
        return ingredientService.findAllIngredients();
    }

    @GetMapping("/{id}")
    public IngredientProjection findById(@PathVariable Long id) {
        return ingredientService.findById(id);
    }
}
