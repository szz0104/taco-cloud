package org.htsg.tacocloud.controller;

import org.htsg.tacocloud.repository.UserRepository;
import org.htsg.tacocloud.vo.RegistrationVo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Microsoft
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Resource
    UserRepository userRepository;

    final
    PasswordEncoder passwordEncoder;

    public RegistrationController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationVo registrationVo) {
        if (userRepository.findByUsername(registrationVo.getUsername()) == null) {
            userRepository.save(registrationVo.toUser(passwordEncoder));
        }
        return "redirect:/login";
    }
}
