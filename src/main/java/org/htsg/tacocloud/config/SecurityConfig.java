package org.htsg.tacocloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author Microsoft
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 所有的HTTP请求路径都需要认证;
     * 不需要特定的角色和权限;
     * 没有登录页面;
     * 认证过程是通过HTTP Basic 认证对话框实现的;
     * 系统只有一个用户，用户名为user.
     */

    @Resource
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                // 配置一个用户
//                .withUser("htsg")
//                // 密码{加密方式}
//                .password("{noop}000000")
//                // 授权方式
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("user")
//                .password("{noop}111111")
//                .authorities("ROLE_USER");

//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, enabled from Users where username=?")
//                .authoritiesByUsernameQuery("select username, authority from UserAuthorities where username=?")
//                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 认证用户访问权限
                .antMatchers("/design", "/orders")
                .access("hasRole('ROLE_USER')")
                // 无条件允许访问其它
                .antMatchers("/", "/**").access("permitAll")
                // 自定义登录页面
                .and()
                .formLogin()
                .loginPage("/login")
                // 自定义注销页面
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")
                .and()
                .headers()
                .frameOptions()
                .sameOrigin();
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
