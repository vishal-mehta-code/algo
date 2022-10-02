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

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
