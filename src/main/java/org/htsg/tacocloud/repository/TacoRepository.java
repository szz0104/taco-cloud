package org.htsg.tacocloud.repository;

import org.htsg.tacocloud.entity.Taco;

/**
 * @author Microsoft
 */
public interface TacoRepository {
    /**
     * 保存煎饼(设计)对象
     *
     * @param design 煎饼(设计)对象
     * @return Taco
     */
    Taco save(Taco design);
}
