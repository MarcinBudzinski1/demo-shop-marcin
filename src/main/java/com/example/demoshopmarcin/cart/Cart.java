package com.example.demoshopmarcin.cart;

import com.example.demoshopmarcin.orders.OrderLine;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Cart {

private List<OrderLine> orderLineList = Lists.newArrayList();
}
