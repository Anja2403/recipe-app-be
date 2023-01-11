package com.onboarding.anja.recipes.service;

import com.onboarding.anja.recipes.entity.IngredientDetailsEntity;
import com.onboarding.anja.recipes.entity.IngredientEntity;
import com.onboarding.anja.recipes.mappers.IngredientMapper;
import com.onboarding.anja.recipes.projections.CreateIngredientProjection;
import com.onboarding.anja.recipes.projections.IngredientProjection;
import com.onboarding.anja.recipes.repository.IngredientDetailsRepository;
import com.onboarding.anja.recipes.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientDetailsRepository ingredientDetailsRepository;



    public IngredientProjection createIngredient(CreateIngredientProjection request) {
       IngredientEntity ingredientEntity = IngredientMapper.toEntity(request);
        // 1. store data to ingredient_details table
        IngredientDetailsEntity ingredientDetailsEntity = new IngredientDetailsEntity();
        ingredientDetailsEntity.setSalt(request.getSalt());
        ingredientDetailsEntity.setCarbohydrates(request.getCarbohydrates());
        ingredientDetailsEntity.setFats(request.getFats());
        ingredientDetailsEntity.setNumberOfCalories(request.getNumberOfCalories());

        IngredientDetailsEntity detailsEntity = ingredientDetailsRepository.save(ingredientDetailsEntity);

        // 2. connect those date to ingredient
        ingredientEntity.setDetails(detailsEntity);

        // 3. store everything to db
       IngredientEntity entity = ingredientRepository.save(ingredientEntity);

       return IngredientMapper.toProjection(entity);
    }


    public List<IngredientProjection> findAllIngredients() {
        List<IngredientEntity> allIngredients = ingredientRepository.findAll();
        List<IngredientProjection> result = allIngredients.stream().map(IngredientMapper::toProjection).collect(Collectors.toList());
        return result;
    }

    public IngredientProjection findById(Long id) {

        Optional<IngredientEntity> ingredient = ingredientRepository.findById(id);
        if(ingredient.isPresent()) {
            IngredientProjection ingredientProjection = IngredientMapper.toProjection(ingredient.get());
            return ingredientProjection;
        }
        return null;

    }
}
