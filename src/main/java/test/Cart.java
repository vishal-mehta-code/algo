package test;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> addToCart(CartItem cartItem) {
        cartItems.add(cartItem);
        return cartItems;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
