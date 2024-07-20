package com.vanlang.DAMH_Nhom04_0102.service;

import com.vanlang.DAMH_Nhom04_0102.model.CartItem;
import com.vanlang.DAMH_Nhom04_0102.model.Order;
import com.vanlang.DAMH_Nhom04_0102.model.OrderDetail;
import com.vanlang.DAMH_Nhom04_0102.repository.OrderDetailRepository;
import com.vanlang.DAMH_Nhom04_0102.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CartService cartService; // Assuming you have a CartService

    @Transactional
    public Order createOrder(String customerName, String customerAddress, String customerNumber, String customerEmail, String customerNote, String customerPM, List<CartItem> cartItems) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setCustomerAddress(customerAddress);
        order.setCustomerNumber(customerNumber);
        order.setCustomerEmail(customerEmail);
        order.setCustomerNote(customerNote);
        order.setCustomerPM(customerPM);

        order = orderRepository.save(order);
        for (CartItem item : cartItems) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(item.getProduct());
            detail.setQuantity(item.getQuantity());
            orderDetailRepository.save(detail);
        }
        // Optionally clear the cart after order placement
        cartService.clearCard();
        return order;
    }
}
