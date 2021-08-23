package org.htsg.tacocloud.controller;

import org.htsg.tacocloud.entity.Ingredient;
import org.htsg.tacocloud.entity.Order;
import org.htsg.tacocloud.entity.Taco;
import org.htsg.tacocloud.entity.User;
import org.htsg.tacocloud.repository.IngredientRepository;
import org.htsg.tacocloud.repository.TacoRepository;
import org.htsg.tacocloud.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Microsoft
 */
@Controller
@RequestMapping(value = "/design")
@SessionAttributes("order")
public class DesignTacoController {
    @Resource
    IngredientRepository ingredientRepository;

    @Resource
    TacoRepository tacoRepository;

    @Resource
    UserRepository userRepository;

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Taco design() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model, Principal principal) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);

        return "design";
    }

    @PostMapping
    public String processDesign(
            @Valid Taco taco, Errors errors,
            @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            return "design";
        }

        Taco saved = tacoRepository.save(taco);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> type.equals(x.getType()))
                .collect(Collectors.toList());
    }
}
