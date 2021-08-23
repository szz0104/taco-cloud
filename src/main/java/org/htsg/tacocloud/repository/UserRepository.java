package org.htsg.tacocloud.repository;

import org.htsg.tacocloud.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Microsoft
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return User 对象
     */
    User findByUsername(String username);
}
