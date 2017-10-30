package javaee.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by Deny on 15.04.2017.
 */
@Component

public class CartFacade {
    @Autowired
    private HttpSession httpSession;

    public Cart getCart(){

        Cart cart = (Cart) httpSession.getAttribute("cart");
        if(cart == null) {
            cart = new Cart();
            httpSession.setAttribute("cart", cart);
        }
        return cart;
    }
}
