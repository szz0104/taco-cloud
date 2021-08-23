package org.htsg.tacocloud.service.impl;

import org.htsg.tacocloud.repository.UserRepository;
import org.htsg.tacocloud.service.impl.service.UserRepositoryUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Microsoft
 */
@Service
public class UserRepositoryUserDetailsServiceImpl implements UserRepositoryUserDetailsService {
    final
    UserRepository repository;

    public UserRepositoryUserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }
}
