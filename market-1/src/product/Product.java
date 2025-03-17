package product;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID=1L;
    private String barcode;
    private String name;
    private int stock;
    private double price;

    public Product (String barcode,String name,int stock,double price){
        this.barcode=barcode;
        this.name=name;
        this.stock=stock;
        this.price=price;
    }
    public void toPrint(){
        System.out.println("\n"+"Barcode: " + this.barcode);
        System.out.println("Name: " + this.name);
        System.out.println("Stock: " + this.stock);
        System.out.println("Price: " + this.price);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
