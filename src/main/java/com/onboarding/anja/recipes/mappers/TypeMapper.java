package com.onboarding.anja.recipes.mappers;

import com.onboarding.anja.recipes.entity.TypeEntity;
import com.onboarding.anja.recipes.projections.CreateTypeProjection;
import com.onboarding.anja.recipes.projections.TypeProjection;

public class TypeMapper {

    public static TypeEntity toEntity(CreateTypeProjection request) {
    TypeEntity typeEntity = new TypeEntity();
    typeEntity.setMobileNumber(request.getMobileNumber());
    typeEntity.setHomeNumber(request.getHomeNumber());

    return typeEntity;
    }

    public static TypeProjection toProjection(TypeEntity entity) {
    TypeProjection projection = new TypeProjection();
    projection.setId(entity.getId());
    projection.setMobileNumber(entity.getMobileNumber());
    projection.setHomeNumber(entity.getHomeNumber());
    projection.setUser(UserMapper.toUserWithoutTypesProjection(entity.getUser()));

    return projection;
    }
}
