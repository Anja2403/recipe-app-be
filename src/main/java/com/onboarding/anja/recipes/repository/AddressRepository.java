package com.onboarding.anja.recipes.repository;

import com.onboarding.anja.recipes.entity.AddressEntity;
import com.onboarding.anja.recipes.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
