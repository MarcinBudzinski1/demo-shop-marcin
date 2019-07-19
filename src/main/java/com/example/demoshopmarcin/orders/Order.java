package com.example.demoshopmarcin.orders;

import com.example.demoshopmarcin.BaseEntity;
import com.example.demoshopmarcin.users.User;
import com.example.demoshopmarcin.users.UserAddress;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Orders")
@ToString()
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity implements Serializable {

    private String customerName;
    private BigDecimal totalCost;
    private UserAddress userAddress;
    private UserAddress deliveryAddress;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;
    @ManyToOne
    private User customer;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;




}
