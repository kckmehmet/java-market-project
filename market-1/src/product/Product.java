package product;

public class Product {
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
}
