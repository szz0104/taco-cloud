package org.htsg.tacocloud.controller;

import org.htsg.tacocloud.entity.Ingredient;
import org.htsg.tacocloud.repository.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Microsoft
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    @Resource
    IngredientRepository repository;

    @Override
    public Ingredient convert(String source) {
        Optional<Ingredient> optionalIngredient = repository.findById(source);
        return optionalIngredient.orElse(null);
    }
}
