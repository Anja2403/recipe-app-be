package com.onboarding.anja.recipes.mappers;

import com.onboarding.anja.recipes.entity.RecipeEntity;
import com.onboarding.anja.recipes.projections.CreateRecipeProjection;
import com.onboarding.anja.recipes.projections.IngredientProjection;
import com.onboarding.anja.recipes.projections.IngredientWithQuantityProjection;
import com.onboarding.anja.recipes.projections.RecipeProjection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeMapper {
    public static RecipeEntity toEntity(CreateRecipeProjection request) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setDescription(request.getDescription());

        return recipeEntity;
    }

    public static RecipeProjection toProjection(RecipeEntity entity) {
        RecipeProjection projection = new RecipeProjection();

        projection.setId(entity.getId());
        projection.setDescription(entity.getDescription());
        projection.setUser(UserMapper.toUserWithoutRecipesProjection(entity.getUser()));


        List<IngredientWithQuantityProjection> ingredients = entity.getIngredients().stream().map(IngredientMapper::toProjectionWithQuantity).collect(Collectors.toList());

        // we need to set this ingredients (type is list with quantity projection)
        projection.setIngredients(ingredients);

        return projection;
    }
}
