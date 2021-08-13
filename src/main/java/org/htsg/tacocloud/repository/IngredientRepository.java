package org.htsg.tacocloud.repository;

import org.htsg.tacocloud.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Microsoft
 */
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
