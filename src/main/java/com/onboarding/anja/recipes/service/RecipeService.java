package com.onboarding.anja.recipes.service;

import com.onboarding.anja.recipes.entity.IngredientEntity;
import com.onboarding.anja.recipes.entity.RecipeEntity;
import com.onboarding.anja.recipes.entity.RecipeIngredientEntity;
import com.onboarding.anja.recipes.entity.UserEntity;
import com.onboarding.anja.recipes.mappers.RecipeMapper;
import com.onboarding.anja.recipes.projections.CreateRecipeProjection;
import com.onboarding.anja.recipes.projections.RecipeProjection;
import com.onboarding.anja.recipes.repository.IngredientRepository;
import com.onboarding.anja.recipes.repository.RecipeIngredientRepository;
import com.onboarding.anja.recipes.repository.RecipeRepository;
import com.onboarding.anja.recipes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;


    public RecipeProjection createNewRecipe(CreateRecipeProjection request) {
        // save the recipe to the database
        RecipeEntity recipeEntity = RecipeMapper.toEntity(request);
        // we are mapping request to RecipeEntity

        // we store the recipe to the recipes table
        // save method expects to get entity --> save it to the database
        RecipeEntity entity = recipeRepository.save(recipeEntity);

        // user can exist but doesn't have to exist
        Optional<UserEntity> userById = userRepository.findById(request.getUserId());
        // to fetch our user by Id
        if(userById.isPresent()) {
            UserEntity userEntity = userById.get();
            userEntity.getRecipes().add(entity);

            // save everything
            UserEntity savedUser  = userRepository.save(userEntity);

            entity.setUser(savedUser);
            recipeRepository.save(entity); // user_id column is filled
        }
        // new part of code (06.12.2022)
        // after this line everything is saved in the database
        // we fetch all ingredients by id and we are going to the list one by one
        request.getIngredients().forEach(createIngredientListProjection -> {
            Optional<IngredientEntity> ingredientById = ingredientRepository.findById(createIngredientListProjection.getId());

            if(ingredientById.isPresent()) { // check if ingredient is present in the database
                IngredientEntity ingredientEntity = ingredientById.get();
                // in order to connect ingredient to recipe we created the new RecipeIngredientsEntity
               // store in the joining table (recipe_ingredients) some data (ingredient_id, recipe_id and quantity)
                RecipeIngredientEntity recipeIngredientEntity = new RecipeIngredientEntity();
                recipeIngredientEntity.setRecipe(entity); // we saved it already (weiter oben)
                recipeIngredientEntity.setIngredient(ingredientEntity); // we have ingredient from request
                recipeIngredientEntity.setQuantity(createIngredientListProjection.getQuantity()); // we don't have it til now
                // we take this quatity from the list

                // we need to store this connection in the database
                RecipeIngredientEntity recipeIngredient =  recipeIngredientRepository.save(recipeIngredientEntity);

                // we need to tell the recipe that a new ingredient was added
                entity.getIngredients().add(recipeIngredient);
                recipeRepository.save(entity); // save it to the database
            }

        });



        return RecipeMapper.toProjection(recipeEntity);
    }

    public RecipeProjection getRecipeById(Long id) {
        // fetching ingredient by id, checking if it is present
        Optional<RecipeEntity> recipeById = recipeRepository.findById(id);
        if(recipeById.isPresent()) {
            // fetch the recipe by Id
            RecipeEntity recipe = recipeById.get();
            return RecipeMapper.toProjection(recipe);
        }

        return null;
    }
}
