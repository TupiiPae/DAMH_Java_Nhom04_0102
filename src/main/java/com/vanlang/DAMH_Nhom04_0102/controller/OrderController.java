package com.vanlang.DAMH_Nhom04_0102.controller;

import com.vanlang.DAMH_Nhom04_0102.model.CartItem;
import com.vanlang.DAMH_Nhom04_0102.service.CartService;
import com.vanlang.DAMH_Nhom04_0102.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;

    @GetMapping("/checkout")
    public String checkout() {
        return "cart/checkout";
    }

    @PostMapping("/submit")
    public String submitOrder(String customerName, String customerAddress, String customerNumber, String customerEmail, String customerNote, String customerPM) {
        List<CartItem> cartItems = cartService.getCartItems();
        if (cartItems.isEmpty()) {
            return "redirect:/cart"; // Redirect if cart is empty
        }
        orderService.createOrder(customerName, customerAddress, customerNumber, customerEmail, customerNote, customerPM, cartItems);
        return "redirect:/order/confirmation";
    }


    @GetMapping("/confirmation")
    public String orderConfirmation(Model model) {
        model.addAttribute("message", "Your order has been successfully placed.");
        return "cart/order-confirmation";
    }
}


