package test;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PricingEngine {

    public double calculatePrice(Cart cart, List<Promotion> promotions) {
        double finalPrice = 0;

        Set<Product> productsProcessed = new HashSet<>();

        for (CartItem cartItem : cart.getCartItems()) {
            Product product = cartItem.getProduct();

            System.out.println("Processing product : " + product);

            if (!productsProcessed.contains(product)) {
                double price = product.getPrice();

                int quantity = cartItem.getQuantity();

                Promotion applicablePromotion = getApplicablePromotion(product, promotions);

                if (null != applicablePromotion) {
                    if (applicablePromotion.isComboOffer()) {

                        boolean applyComboOffer = applyComboOffer(cart, applicablePromotion);

                        if (applyComboOffer) {
                            // apply the promotional price one time and manage the rest of the quantities separately
                            finalPrice += applicablePromotion.getPrice();

                            List<Product> promotionalProducts = applicablePromotion.getProducts();
                            List<Integer> promotionalQuantities = applicablePromotion.getQuantity();

                            for (int index = 0; index < promotionalProducts.size(); index++) {
                                Product promotionalProduct = promotionalProducts.get(index);
                                int promotionalQuantity = promotionalQuantities.get(index);

                                CartItem cartItemProduct = cart.getCartItems().stream().filter(x -> x.getProduct().equals(promotionalProduct)).findFirst().get();
                                int leftOverQuantity = cartItemProduct.getQuantity() % promotionalQuantity;
                                finalPrice += leftOverQuantity * price;
                            }


                            productsProcessed.addAll(promotionalProducts);
                        } else {
                            finalPrice += quantity * price;
                        }
                    } else {
                        int promotionalQuantity = applicablePromotion.getQuantity().get(0);
                        int applicablePromotionalQuantity = quantity / promotionalQuantity;
                        int leftOverQuantity = quantity % promotionalQuantity;

                        finalPrice += applicablePromotionalQuantity * applicablePromotion.getPrice() + leftOverQuantity * price;
                    }
                } else {
                    finalPrice += quantity * price;
                }

                productsProcessed.add(product);
            }
        }

        return finalPrice;
    }

    // if cart items contains all the products and quantity is adequate then only apply the promotion
    private boolean applyComboOffer(Cart cart, Promotion applicablePromotion) {
        List<Product> promotionalProducts = applicablePromotion.getProducts();
        List<Integer> promotionalQuantities = applicablePromotion.getQuantity();

        for (int index = 0; index < promotionalProducts.size(); index++) {
            Product promotionalProduct = promotionalProducts.get(index);
            int promotionalQuantity = promotionalQuantities.get(index);

            Optional<CartItem> cartItemProduct = cart.getCartItems().stream().filter(cartItem -> cartItem.getProduct().equals(promotionalProduct)).findFirst();

            if (cartItemProduct.isPresent()) {
                if (cartItemProduct.get().getQuantity() / promotionalQuantity == 0) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * This search method could be optimized further.
     * One way of doing this is preparing a map which would reduce the search to O(1)
     *
     * @param product
     * @param promotions
     * @return
     */
    private Promotion getApplicablePromotion(Product product, List<Promotion> promotions) {
        for (Promotion promotion : promotions) {
            if (promotion.getProducts().contains(product)) {
                return promotion;
            }
        }
        return null;
    }
}
