package com.vanlang.DAMH_Nhom04_0102.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerAddress;
    private String customerNumber;
    private String customerEmail;
    private String customerNote;
    private String customerPM;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}


