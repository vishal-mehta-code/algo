package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class PricingEngineTest {
    PricingEngine pricingEngine = new PricingEngine();

    @Test
    public void testPrice1() {
        // Define the products available
        Product product1 = new Product();
        product1.setSkuId("A");
        product1.setPrice(50);

        Product product2 = new Product();
        product2.setSkuId("B");
        product2.setPrice(30);

        Product product3 = new Product();
        product3.setSkuId("C");
        product3.setPrice(20);

        Product product4 = new Product();
        product4.setSkuId("D");
        product4.setPrice(15);


        // Prepare a cart
        Cart cart = new Cart();

        CartItem cartItem1 = new CartItem();
        cartItem1.setProduct(product1);
        cartItem1.setQuantity(1);

        CartItem cartItem2 = new CartItem();
        cartItem2.setProduct(product2);
        cartItem2.setQuantity(1);

        CartItem cartItem3 = new CartItem();
        cartItem3.setProduct(product3);
        cartItem3.setQuantity(1);

        CartItem cartItem4 = new CartItem();
        cartItem4.setProduct(product4);
        cartItem4.setQuantity(1);

        cart.addToCart(cartItem1);
        cart.addToCart(cartItem2);
        cart.addToCart(cartItem3);
        cart.addToCart(cartItem4);

        // Define the available promotions
        Promotion promotion1 = new Promotion();
        promotion1.setProducts(Arrays.asList(product1));
        promotion1.setQuantity(Arrays.asList(3));
        promotion1.setPrice(130);
        promotion1.setPriority(1);

        Promotion promotion2 = new Promotion();
        promotion2.setProducts(Arrays.asList(product2));
        promotion2.setQuantity(Arrays.asList(2));
        promotion2.setPrice(45);
        promotion2.setPriority(1);

        Promotion promotion3 = new Promotion();
        promotion3.setComboOffer(true);
        promotion3.setProducts(Arrays.asList(product3, product4));
        promotion3.setQuantity(Arrays.asList(1, 1));
        promotion3.setPrice(30);
        promotion3.setPriority(1);

        Assertions.assertEquals(110.0, pricingEngine.calculatePrice(cart, Arrays.asList(promotion1, promotion2, promotion3)));

    }

    /**
     * Scenario A
     * 1 * A 50
     * 1 * B 30
     * 1 * C 20
     * ======
     * Total 100
     */
    @Test
    public void testPrice2() {
        // Define the products available
        Product product1 = new Product();
        product1.setSkuId("A");
        product1.setPrice(50);

        Product product2 = new Product();
        product2.setSkuId("B");
        product2.setPrice(30);

        Product product3 = new Product();
        product3.setSkuId("C");
        product3.setPrice(20);

        Product product4 = new Product();
        product4.setSkuId("D");
        product4.setPrice(15);


        // Prepare a cart
        Cart cart = new Cart();

        CartItem cartItem1 = new CartItem();
        cartItem1.setProduct(product1);
        cartItem1.setQuantity(1);

        CartItem cartItem2 = new CartItem();
        cartItem2.setProduct(product2);
        cartItem2.setQuantity(1);

        CartItem cartItem3 = new CartItem();
        cartItem3.setProduct(product3);
        cartItem3.setQuantity(1);

        cart.addToCart(cartItem1);
        cart.addToCart(cartItem2);
        cart.addToCart(cartItem3);


        // Define the available promotions
        Promotion promotion1 = new Promotion();
        promotion1.setProducts(Arrays.asList(product1));
        promotion1.setQuantity(Arrays.asList(3));
        promotion1.setPrice(130);
        promotion1.setPriority(1);

        Promotion promotion2 = new Promotion();
        promotion2.setProducts(Arrays.asList(product2));
        promotion2.setQuantity(Arrays.asList(2));
        promotion2.setPrice(45);
        promotion2.setPriority(1);

        Promotion promotion3 = new Promotion();
        promotion3.setComboOffer(true);
        promotion3.setProducts(Arrays.asList(product3, product4));
        promotion3.setQuantity(Arrays.asList(1, 1));
        promotion3.setPrice(30);
        promotion3.setPriority(1);

        double price = pricingEngine.calculatePrice(cart, Arrays.asList(promotion1, promotion2, promotion3));

        Assertions.assertEquals(100.0, price);

    }

    /**
     * Scenario B
     * 5 * A 130 + 2*50
     * 5 * B 45 + 45 + 30
     * 1 * C 20
     * ======
     * Total 370
     */
    @Test
    public void testPrice3() {
        // Define the products available
        Product product1 = new Product();
        product1.setSkuId("A");
        product1.setPrice(50);

        Product product2 = new Product();
        product2.setSkuId("B");
        product2.setPrice(30);

        Product product3 = new Product();
        product3.setSkuId("C");
        product3.setPrice(20);

        Product product4 = new Product();
        product4.setSkuId("D");
        product4.setPrice(15);


        // Prepare a cart
        Cart cart = new Cart();

        CartItem cartItem1 = new CartItem();
        cartItem1.setProduct(product1);
        cartItem1.setQuantity(5);

        CartItem cartItem2 = new CartItem();
        cartItem2.setProduct(product2);
        cartItem2.setQuantity(5);

        CartItem cartItem3 = new CartItem();
        cartItem3.setProduct(product3);
        cartItem3.setQuantity(1);

        cart.addToCart(cartItem1);
        cart.addToCart(cartItem2);
        cart.addToCart(cartItem3);


        // Define the available promotions
        Promotion promotion1 = new Promotion();
        promotion1.setProducts(Arrays.asList(product1));
        promotion1.setQuantity(Arrays.asList(3));
        promotion1.setPrice(130);
        promotion1.setPriority(1);

        Promotion promotion2 = new Promotion();
        promotion2.setProducts(Arrays.asList(product2));
        promotion2.setQuantity(Arrays.asList(2));
        promotion2.setPrice(45);
        promotion2.setPriority(1);

        Promotion promotion3 = new Promotion();
        promotion3.setComboOffer(true);
        promotion3.setProducts(Arrays.asList(product3, product4));
        promotion3.setQuantity(Arrays.asList(1, 1));
        promotion3.setPrice(30);
        promotion3.setPriority(1);

        double price = pricingEngine.calculatePrice(cart, Arrays.asList(promotion1, promotion2, promotion3));

        Assertions.assertEquals(370.0, price);
    }

    /**
     * Scenario C
     * 3 * A 130
     * 5 * B 45 + 45 + 1 * 30
     * 1 * C -
     * 1 * D 30
     * ======
     * Total 280
     */
    @Test
    public void testPrice4() {
        // Define the products available
        Product product1 = new Product();
        product1.setSkuId("A");
        product1.setPrice(50);

        Product product2 = new Product();
        product2.setSkuId("B");
        product2.setPrice(30);

        Product product3 = new Product();
        product3.setSkuId("C");
        product3.setPrice(20);

        Product product4 = new Product();
        product4.setSkuId("D");
        product4.setPrice(15);


        // Prepare a cart
        Cart cart = new Cart();

        CartItem cartItem1 = new CartItem();
        cartItem1.setProduct(product1);
        cartItem1.setQuantity(3);

        CartItem cartItem2 = new CartItem();
        cartItem2.setProduct(product2);
        cartItem2.setQuantity(5);

        CartItem cartItem3 = new CartItem();
        cartItem3.setProduct(product3);
        cartItem3.setQuantity(1);

        CartItem cartItem4 = new CartItem();
        cartItem4.setProduct(product4);
        cartItem4.setQuantity(1);

        cart.addToCart(cartItem1);
        cart.addToCart(cartItem2);
        cart.addToCart(cartItem3);
        cart.addToCart(cartItem4);


        // Define the available promotions
        Promotion promotion1 = new Promotion();
        promotion1.setProducts(Arrays.asList(product1));
        promotion1.setQuantity(Arrays.asList(3));
        promotion1.setPrice(130);
        promotion1.setPriority(1);

        Promotion promotion2 = new Promotion();
        promotion2.setProducts(Arrays.asList(product2));
        promotion2.setQuantity(Arrays.asList(2));
        promotion2.setPrice(45);
        promotion2.setPriority(1);

        Promotion promotion3 = new Promotion();
        promotion3.setComboOffer(true);
        promotion3.setProducts(Arrays.asList(product3, product4));
        promotion3.setQuantity(Arrays.asList(1, 1));
        promotion3.setPrice(30);
        promotion3.setPriority(1);

        double price = pricingEngine.calculatePrice(cart, Arrays.asList(promotion1, promotion2, promotion3));

        Assertions.assertEquals(280.0, price);
    }

}
