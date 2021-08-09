package org.htsg.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.htsg.tacocloud.entity.Ingredient;
import org.htsg.tacocloud.entity.Ingredient.Type;
import org.htsg.tacocloud.entity.Taco;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Microsoft
 */
@Slf4j
@Controller
@RequestMapping(value = "/design")
public class DesignTacoController {

    /**
     * 将方法参数或方法返回值绑定到命名模型属性的注释(@ModelAttribute)，暴露给 Web 视图。
     *
     * @param model Model
     */
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        ingredients.stream()
                .collect(Collectors.groupingBy(Ingredient::getType))
                .forEach((k, v) -> model.addAttribute(k.toString().toLowerCase(), v));
    }

    @GetMapping
    public String showDesignFrom(Model model) {
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }
}
