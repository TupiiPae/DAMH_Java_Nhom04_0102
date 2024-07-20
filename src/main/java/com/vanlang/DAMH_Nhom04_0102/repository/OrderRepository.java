package com.vanlang.DAMH_Nhom04_0102.repository;

import com.vanlang.DAMH_Nhom04_0102.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
