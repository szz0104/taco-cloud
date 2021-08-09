package org.htsg.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Microsoft
 */
@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String home() {
        return "home";
    }
}
