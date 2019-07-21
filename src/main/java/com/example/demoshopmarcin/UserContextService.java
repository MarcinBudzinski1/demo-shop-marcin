package com.example.demoshopmarcin;

import com.example.demoshopmarcin.orders.OrderLine;
import com.example.demoshopmarcin.products.Product;
import com.example.demoshopmarcin.users.RoleType;
import com.google.gson.Gson;
import com.example.demoshopmarcin.cart.Cart;
import lombok.Getter;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Optional;

@Service
@SessionScope
public class UserContextService {

    @Getter
    private Cart cart = new Cart();
    private static Gson gson =new Gson();

    public String loggedUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        return authentication.getName();
    }

    public void clearCart() {
        cart = new Cart();
    }

    public void addProductToCart(Product product){
        List<OrderLine> orderLines =cart.getOrderLineList();
        Optional<OrderLine> first =orderLines.stream().filter(e->e.getProduct().getId().equals(product.getId())).findFirst();
        if (first.isPresent()){first.get().setQuantity(first.get().getQuantity()+1);}
        else {
            OrderLine orderLine = new OrderLine();
            orderLine.setProduct(product);
            orderLine.setProductPrice(product.getPrice());
            orderLine.setQuantity(1);
            orderLines.add(orderLine);
        }
    }

    public String getCartAsJson() {
        return gson.toJson(cart);
    }

    public boolean user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(e -> RoleType.USER.getRoleName().equalsIgnoreCase(e.getAuthority()))) {
            return true;
        }
        return false;
    }


}
