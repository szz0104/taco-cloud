package org.htsg.tacocloud.controller;

import org.htsg.tacocloud.entity.Ingredient;
import org.htsg.tacocloud.repository.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Microsoft
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    final
    IngredientRepository ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String source) {
        return ingredientRepository.findById(source);
    }
}
