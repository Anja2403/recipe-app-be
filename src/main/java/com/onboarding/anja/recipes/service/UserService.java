package com.onboarding.anja.recipes.service;

import com.onboarding.anja.recipes.entity.AddressEntity;
import com.onboarding.anja.recipes.entity.UserEntity;
import com.onboarding.anja.recipes.mappers.UserMapper;
import com.onboarding.anja.recipes.projections.CreateUserProjection;
import com.onboarding.anja.recipes.projections.LoginUserProjection;
import com.onboarding.anja.recipes.projections.UserProjection;
import com.onboarding.anja.recipes.repository.AddressRepository;
import com.onboarding.anja.recipes.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // Spring Boot can see this service and will be able to inject it where we need it  (UserController)
public class UserService {
    @Autowired // we need UserRepository
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<UserProjection> findAll() {
        List<UserEntity> allUsers = userRepository.findAll();
        // map user entities to userprojection
        List<UserProjection> collect = allUsers.stream().map(UserMapper::toUserProjection).collect(Collectors.toList());
        return collect;
    }
    // we have userPojection we need userEntity
    public UserProjection createNewUser(CreateUserProjection request) {
        UserEntity userEntity = UserMapper.toUserEntity(request);
        //UserEntity save = userRepository.save(userEntity); // in this moment it will have id
        // 1. store data to address table
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(request.getStreet());
        addressEntity.setZipCode(request.getZipCode());
        addressEntity.setCity(request.getCity());

        AddressEntity addr = addressRepository.save(addressEntity);

        // 2. connect those date to ingredient
        userEntity.setAddress(addr);

        //3. store everything to db
        UserEntity entity = userRepository.save(userEntity);

        return UserMapper.toUserProjection(entity);
    }

//    // we have userPojection we need userEntity
//    public void createNewUser(CreateUserProjection request) {
//        UserEntity userEntity = UserMapper.toUserEntity(request);
//        UserEntity save = userRepository.save(userEntity); // in this moment it will have id
//    }



    public UserProjection findUserById(Long id) {
        Optional<UserEntity> userById = userRepository.findById(id);
        // Optional: User with that id can be found in the database, but also cannot find in the database
        // so we check if it is present

        if(userById.isPresent()) {
            UserEntity userEntity = userById.get();
            return UserMapper.toUserProjection(userEntity);
        }

        return null;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public UserProjection updateUser(UserProjection request) {
        Optional<UserEntity> originalUser = userRepository.findById(request.getId());

        if (originalUser.isPresent()) {
            UserEntity userEntity = originalUser.get();
            userEntity.setFirstName(request.getFirstName());
            userEntity.setLastName((request.getLastName()));
            UserEntity entity = userRepository.save(userEntity);
            return UserMapper.toUserProjection(entity);
        }

        return null;

    }


    public List<UserProjection> findAllUser() {
        List<UserEntity> allUser = userRepository.findAll();
        List<UserProjection> result = allUser.stream().map(UserMapper::toUserProjection).collect(Collectors.toList());
        return result;
    }

    public UserProjection login(LoginUserProjection request) {
        // 1. we need to fetch user from database by email
        Optional<UserEntity> byEmail = userRepository.findByEmail(request.getEmail());
        if (byEmail.isPresent()) {
            UserEntity userEntity = byEmail.get();
            // 2. we need to check if password from request is equals to stored password
            if(request.getPassword().equals(userEntity.getPassword())) {
                return UserMapper.toUserProjection(userEntity);
            } else {
                return null;
            }
        }

        // 3. if yes return that user, if not return null
        return null;
    }
}
