package test;

import java.util.Objects;

public class Product {
    private String skuId;
    private double price;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return skuId.equals(product.skuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuId);
    }
}
