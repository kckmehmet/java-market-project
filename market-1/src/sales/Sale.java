package sales;

import CashRegister.CashRegister;
import product.Product;

import java.util.ArrayList;

public class Sale {
    private double totalPrice;
    private long salesNumber;
    private ArrayList<Product> soldProducts;
    private CashRegister cashRegister;

    public Sale(long salesNumber, ArrayList<Product> soldProducts, double totalPrice,CashRegister cashRegister) {
        this.salesNumber = salesNumber;
        this.soldProducts = soldProducts;
        this.totalPrice = totalPrice;
        this.cashRegister=cashRegister;
    }

    public CashRegister getCashRegister(){return cashRegister;}

    public void setCashRegister(CashRegister cashRegister){this.cashRegister=cashRegister;}

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
