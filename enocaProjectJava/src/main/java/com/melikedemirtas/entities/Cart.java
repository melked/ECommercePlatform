package com.melikedemirtas.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity {

    @Column(name = "total_price", nullable = false)
    private Double totalPrice = 0.0;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
