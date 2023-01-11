package com.onboarding.anja.recipes.repository;

import com.onboarding.anja.recipes.entity.IngredientDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDetailsRepository extends JpaRepository<IngredientDetailsEntity, Long> {
}
