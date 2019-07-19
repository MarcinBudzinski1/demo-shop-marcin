package com.example.demoshopmarcin.orders;

import com.example.demoshopmarcin.UserContextService;
import com.example.demoshopmarcin.cart.Cart;
import com.example.demoshopmarcin.cart.CartService;
import com.example.demoshopmarcin.products.ProductRepository;
import com.example.demoshopmarcin.users.Customer;
import com.example.demoshopmarcin.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private UserContextService userContextService;
    private OrdersRepository ordersRepository;
    private UserRepository<Customer> userRepository;
    private CartService cartService;
    private ProductRepository productRepository;

    @Autowired
    public OrderService(UserContextService userContextService, OrdersRepository ordersRepository, UserRepository<Customer> userRepository, CartService cartService, ProductRepository productRepository) {
        this.userContextService = userContextService;
        this.ordersRepository = ordersRepository;
        this.userRepository = userRepository;
        this.cartService = cartService;
        this.productRepository = productRepository;
    }

    public Order placeOrder(){
        Cart cart = userContextService.getCart();
        String loggedUserEmail =userContextService.loggedUserEmail();
        Customer customer = userRepository.findByUsername((loggedUserEmail));

        cart.getOrderLineList()
                .stream()
                .peek(p->p.getProduct().setStockAmount(p.getProduct().getStockAmount() - p.setQuantity()))
                .map(OrderLine::getProduct).forEach(productRepository::save);

        Order order = ordersRepository.save(new Order(
                customer.getUsername(),
                cartService.calculateTotalCartPrice(cart),
                customer.getUserAddress(),
                customer.getUserAddress(),
                cart.getOrderLineList(),
                customer,
                OrderStatus.STARTED));
        userContextService.clearCart();
        return order;
    }
}
