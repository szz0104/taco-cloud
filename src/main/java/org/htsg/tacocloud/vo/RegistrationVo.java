package org.htsg.tacocloud.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.htsg.tacocloud.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Microsoft
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegistrationVo {
    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password),
                fullName, street, city, state, zip, phone);
    }
}
