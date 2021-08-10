package org.htsg.tacocloud.repository;

import org.htsg.tacocloud.entity.Order;

/**
 * @author Microsoft
 */
public interface OrderRepository {
    /**
     * 保存订单
     *
     * @param order 订单对象
     * @return Order
     */
    Order save(Order order);
}
