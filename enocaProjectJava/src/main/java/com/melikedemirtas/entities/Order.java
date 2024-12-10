package com.melikedemirtas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "order_code", nullable = false, unique = true)
    private String orderCode; // Siparişin benzersiz kodu

    @Column(name = "total_price", nullable = false)
    private Double totalPrice; // Toplam sipariş tutarı

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate; // Sipariş tarihi
}
