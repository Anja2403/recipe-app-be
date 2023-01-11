package com.onboarding.anja.recipes.mappers;


import com.onboarding.anja.recipes.entity.IngredientEntity;
import com.onboarding.anja.recipes.entity.RecipeIngredientEntity;
import com.onboarding.anja.recipes.projections.CreateIngredientProjection;
import com.onboarding.anja.recipes.projections.IngredientDetailsProjection;
import com.onboarding.anja.recipes.projections.IngredientProjection;
import com.onboarding.anja.recipes.projections.IngredientWithQuantityProjection;

public class IngredientMapper {
    public static IngredientEntity toEntity(CreateIngredientProjection projection) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setPrice(projection.getPrice());
        ingredientEntity.setName(projection.getName());

        return ingredientEntity;
    }

    public static IngredientProjection toProjection(IngredientEntity entity) {
        IngredientProjection ingredientProjection = new IngredientProjection();
        ingredientProjection.setId(entity.getId());
        ingredientProjection.setName((entity.getName()));
        ingredientProjection.setPrice(entity.getPrice());

        IngredientDetailsProjection ingredientDetailsProjection = new IngredientDetailsProjection();
        ingredientDetailsProjection.setId(entity.getDetails().getId()); // we have a getter for details
        ingredientDetailsProjection.setCarbohydrates(entity.getDetails().getCarbohydrates());
        ingredientDetailsProjection.setFats(entity.getDetails().getFats());
        ingredientDetailsProjection.setSalt(entity.getDetails().getSalt());
        ingredientDetailsProjection.setNumberOfCalories(entity.getDetails().getNumberOfCalories());

        ingredientProjection.setDetails(ingredientDetailsProjection);

        return ingredientProjection;
    }

    public static IngredientWithQuantityProjection toProjectionWithQuantity(RecipeIngredientEntity entity) {
        IngredientWithQuantityProjection ingredient = new IngredientWithQuantityProjection();

        ingredient.setId(entity.getIngredient().getId()); // .get
        ingredient.setName(entity.getIngredient().getName());
        ingredient.setPrice(entity.getIngredient().getPrice());
        ingredient.setQuantity(entity.getQuantity());

        IngredientDetailsProjection ingredientDetailsProjection = new IngredientDetailsProjection();
        ingredientDetailsProjection.setId(entity.getIngredient().getDetails().getId()); // we have a getter for details
        ingredientDetailsProjection.setCarbohydrates(entity.getIngredient().getDetails().getCarbohydrates());
        ingredientDetailsProjection.setFats(entity.getIngredient().getDetails().getFats());
        ingredientDetailsProjection.setSalt(entity.getIngredient().getDetails().getSalt());
        ingredientDetailsProjection.setNumberOfCalories(entity.getIngredient().getDetails().getNumberOfCalories());

        ingredient.setDetails(ingredientDetailsProjection);

        return ingredient;
    }
}
