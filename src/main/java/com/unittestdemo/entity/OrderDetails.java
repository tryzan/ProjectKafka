package com.unittestdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="OrderDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "OrderId")
    private Orders orders;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "ProductId")
    private Products products;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "ShipmentId")
    private Shipment shipment;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "SubTotal")
    private BigDecimal subTotal;
}
