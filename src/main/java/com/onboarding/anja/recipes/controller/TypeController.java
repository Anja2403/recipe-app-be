package com.onboarding.anja.recipes.controller;

import com.onboarding.anja.recipes.projections.CreateTypeProjection;
import com.onboarding.anja.recipes.projections.TypeProjection;
import com.onboarding.anja.recipes.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping
    public TypeProjection createNewType(@RequestBody CreateTypeProjection request) {
        return typeService.createNewType(request);
    }

    @GetMapping("/{id}")
    public TypeProjection getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id);
    }

}
