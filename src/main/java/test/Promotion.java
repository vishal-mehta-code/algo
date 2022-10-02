package test;

import java.util.List;

class Promotion {
    private boolean comboOffer;
    private List<Product> products;
    private List<Integer> quantity;
    private double price;
    private int priority;

    public boolean isComboOffer() {
        return comboOffer;
    }

    public void setComboOffer(boolean comboOffer) {
        this.comboOffer = comboOffer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
