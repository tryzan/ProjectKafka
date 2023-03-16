package com.unittestdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "BuyerId")
    private Account buyer;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "ProductId")
    private Products products;

    @Column(name = "Quantity")
    private Integer quantity;

    @ManyToOne
    @NotNull
    @JoinColumn(name="ShipmentId")
    private Shipment shipment;
}
