package com.onboarding.anja.recipes.mappers;

import com.onboarding.anja.recipes.entity.RecipeEntity;
import com.onboarding.anja.recipes.entity.UserEntity;
import com.onboarding.anja.recipes.projections.*;
import org.apache.catalina.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserProjection toUserProjection(UserEntity userEntity) {
        UserProjection userProjection = new UserProjection();
        userProjection.setId(userEntity.getId());
        userProjection.setFirstName((userEntity.getFirstName()));
        userProjection.setLastName((userEntity.getLastName()));

        List<RecipeEntity> entityRecipes = userEntity.getRecipes();
        if (entityRecipes != null) {
            List<RecipeProjection> result = entityRecipes.stream().map(RecipeMapper::toProjection).collect(Collectors.toList());
            userProjection.setRecipes(result);
        }

        AddressProjection addressProjection = new AddressProjection();
        addressProjection.setId(userEntity.getAddress().getId());
        addressProjection.setStreet(userEntity.getAddress().getStreet());
        addressProjection.setZipCode(userEntity.getAddress().getZipCode());
        addressProjection.setCity(userEntity.getAddress().getCity());

        userProjection.setAddress(addressProjection);

        return userProjection;

    }

    public static UserWithoutRecipesProjection toUserWithoutRecipesProjection(UserEntity userEntity) {
        UserWithoutRecipesProjection userProjection = new UserWithoutRecipesProjection();
        userProjection.setId(userEntity.getId());
        userProjection.setFirstName((userEntity.getFirstName()));
        userProjection.setLastName((userEntity.getLastName()));


        AddressProjection addressProjection = new AddressProjection();
        addressProjection.setId(userEntity.getAddress().getId());
        addressProjection.setStreet(userEntity.getAddress().getStreet());
        addressProjection.setZipCode(userEntity.getAddress().getZipCode());
        addressProjection.setCity(userEntity.getAddress().getCity());

        userProjection.setAddress(addressProjection);

        return userProjection;
    }

    public static UserWithoutTypesProjection toUserWithoutTypesProjection(UserEntity userEntity) {
        UserWithoutTypesProjection userProjection = new UserWithoutTypesProjection();
        userProjection.setId(userEntity.getId());
        userProjection.setFirstName((userEntity.getFirstName()));
        userProjection.setLastName((userEntity.getLastName()));


        AddressProjection addressProjection = new AddressProjection();
        addressProjection.setId(userEntity.getAddress().getId());
        addressProjection.setStreet(userEntity.getAddress().getStreet());
        addressProjection.setZipCode(userEntity.getAddress().getZipCode());
        addressProjection.setCity(userEntity.getAddress().getCity());

        userProjection.setAddress(addressProjection);

        return userProjection;
    }


    public static UserEntity toUserEntity (CreateUserProjection userProjection) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userProjection.getEmail());
        userEntity.setFirstName(userProjection.getFirstName());
        userEntity.setLastName(userProjection.getLastName());
        userEntity.setPassword(userProjection.getPassword());

        return userEntity;

    }

    public static UserEntity toUserEntity (UserProjection userProjection) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userProjection.getFirstName());
        userEntity.setLastName(userProjection.getLastName());

        return userEntity;

    }
}
