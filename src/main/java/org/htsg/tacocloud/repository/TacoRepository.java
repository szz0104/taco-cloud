package org.htsg.tacocloud.repository;

import org.htsg.tacocloud.entity.Taco;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Microsoft
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
