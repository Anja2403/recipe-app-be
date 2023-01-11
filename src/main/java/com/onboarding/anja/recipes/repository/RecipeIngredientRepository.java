package com.onboarding.anja.recipes.repository;

import com.onboarding.anja.recipes.entity.RecipeIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredientEntity, Long> {
}
