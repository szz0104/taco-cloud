package org.htsg.tacocloud.repository;

import org.htsg.tacocloud.entity.Ingredient;

/**
 * @author Microsoft
 */
public interface IngredientRepository {
    /**
     * 查找所有类型配料
     *
     * @return Iterable
     */
    Iterable<Ingredient> findAll();

    /**
     * 根据配料id查询配料
     *
     * @param id 配料标识
     * @return Ingredient
     */
    Ingredient findById(String id);

    /**
     * 添加配料
     *
     * @param ingredient 配料对象
     * @return Ingredient
     */
    Ingredient save(Ingredient ingredient);
}
