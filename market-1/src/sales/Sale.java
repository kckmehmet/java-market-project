package sales;

import product.Product;

import java.util.ArrayList;

public class Sale {
    private double totalPrice;
    private long salesNumber;
    private ArrayList<Product> soldProducts;

    public Sale(long salesNumber, ArrayList<Product> soldProducts, double totalPrice) {
        this.salesNumber = salesNumber;
        this.soldProducts = soldProducts;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ArrayList<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public long getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(long salesNumber) {
        this.salesNumber = salesNumber;
    }



}
