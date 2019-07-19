package com.example.demoshopmarcin.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdersController {

    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/placeOrder")
    public String makeOrder(Model model){
        model.addAttribute("order", orderService.placeOrder());
        return "orderOrdered";
    }
}
