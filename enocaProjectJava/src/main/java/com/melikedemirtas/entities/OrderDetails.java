package com.melikedemirtas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // İlgili sipariş

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Sipariş edilen ürün

    @Column(name = "price", nullable = false)
    private Double price; // Sipariş esnasındaki ürün fiyatı

    @Column(name = "quantity", nullable = false)
    private Integer quantity; // Sipariş edilen ürün miktarı

    @Column(name = "subtotal", nullable = false)
    private Double subtotal; // price * quantity
}
