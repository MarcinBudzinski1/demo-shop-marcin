package com.example.demoshopmarcin.orders;

import com.example.demoshopmarcin.BaseEntity;
import com.example.demoshopmarcin.products.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@ToString
@Table(name = "order_lines")
public class OrderLine extends BaseEntity implements Serializable {

    @OneToOne
    private Product product;

    private Integer quantity;

    @Column(name = "product_price")
    private BigDecimal productPrice;
}
