package org.htsg.tacocloud.controller;

import org.htsg.tacocloud.entity.Order;
import org.htsg.tacocloud.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * @author Microsoft
 */
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
    final
    OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid Order order,
            Errors errors,
            SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        orderRepository.save(order);

        // 将当前处理程序的会话处理标记为完成，允许清除会话属性。
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
