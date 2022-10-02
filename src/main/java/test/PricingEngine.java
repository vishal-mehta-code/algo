package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PricingEngine {

    public double calculatePrice(Cart cart, List<Promotion> promotions) {
        double finalPrice = 0;

        Set<Product> promotionsApplied = new HashSet<>();

        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();

            if (!promotionsApplied.contains(product)) {
                String skuId = product.getSkuId();
                double price = product.getPrice();

                int quantity = cartItem.getQuantity();

                promotionsApplied.add(product);
            }
        }

        return finalPrice;
    }
}
