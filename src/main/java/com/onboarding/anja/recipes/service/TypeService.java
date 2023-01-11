package com.onboarding.anja.recipes.service;

import com.onboarding.anja.recipes.entity.TypeEntity;
import com.onboarding.anja.recipes.entity.UserEntity;
import com.onboarding.anja.recipes.mappers.TypeMapper;
import com.onboarding.anja.recipes.projections.CreateTypeProjection;
import com.onboarding.anja.recipes.projections.TypeProjection;
import com.onboarding.anja.recipes.repository.RecipeRepository;
import com.onboarding.anja.recipes.repository.TypeRepository;
import com.onboarding.anja.recipes.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private UserRepository userRepository;


    public TypeProjection createNewType(CreateTypeProjection request) {
    TypeEntity typeEntity = TypeMapper.toEntity(request);

    // Storte to database
    TypeEntity entity = typeRepository.save(typeEntity);

    Optional<UserEntity> userById = userRepository.findById(request.getUserId());
    if(userById.isPresent()) {
        UserEntity userEntity = userById.get();
        userEntity.getTypes().add(entity);

        UserEntity savedUser = userRepository.save(userEntity);

        entity.setUser(savedUser);
        typeRepository.save(entity);
    }

    return TypeMapper.toProjection(typeEntity);
    }

    public TypeProjection getTypeById(Long id) {
        Optional<TypeEntity> typeById = typeRepository.findById(id);
        if(typeById.isPresent()) {
            TypeEntity type = typeById.get();
            return TypeMapper.toProjection(type);
        }
        return null;
    }
}
