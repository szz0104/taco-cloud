package org.htsg.tacocloud.repository;

import org.htsg.tacocloud.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Microsoft
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
