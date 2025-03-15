package product;

import java.util.ArrayList;

public class ProductService {
    ArrayList<Product> products = new ArrayList<>();

    private boolean checkProduct(String barcode, String name, int stock, double price) {
        if (barcode != null || barcode.length() > 0 && barcode.length() == 8 || stock >= 0 || price > 0) {
            return true;
        } else return false;
    }

    public Product createProduct(String barcode, String name, int stock, double price) {
        if (checkProduct(barcode, name, stock, price)) {
            try {
                Product product = new Product(barcode, name, stock, price);
                products.add(product);
                System.out.println("product created successfully");
                return product;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("You must enter valid data for the product (barcode, name, stock, price).");
            return null;
        }
    }

    public void getProducts() {
        if (products.size() > 0) {
            System.out.println("");
            System.out.printf("%-8s %-20s %-10s %-15s", "Barcode", "Name", "Stock", "Price");
            System.out.println("");
            System.out.println("-------------------------------------------------------------");
            for (Product product : products) {
                System.out.printf("%-8s %-20s %-10d %-15.2f%n", product.getBarcode(), product.getName(), product.getStock(), product.getPrice());
            }
        } else {
            System.out.println("No registered products found");
        }

    }

    public Product getProductByName(String name) {
        if (name == null) {
            System.out.println("Please enter a valid product name");
            return null;
        } else {
            Product product = products.stream()
                    .filter(pro -> pro.getName().equals(name))
                    .findFirst()
                    .orElse(null);
            if (product == null) {
                product = products.stream()
                        .filter(pro -> pro.getName().contains(name))
                        .findFirst()
                        .orElse(null);
                if (product == null)
                    System.out.println("No product found with the name you are looking for, You can try searching by barcode.");
            }
            return product;
        }
    }

    public Product getProductByBorcode(String barcode) {
        if (barcode != null || barcode.length() > 0) {
            try {
                Product product = products.stream()
                        .filter(pro -> pro.getBarcode().equals(barcode))
                        .findFirst()
                        .orElse(null);
                if (product == null) {
                    System.out.println("No product found with the barcode you are looking for");
                    return null;
                } else {
                    System.out.println("The product you are looking for was found");
                    product.toPrint();
                    return product;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Please enter a valid product barcode");
            return null;
        }
    }

    public void editProduct(String barcode, String newBarcode, String newName, int newStock, double newPrice) {
        if (!checkProduct(newBarcode, newName, newStock, newPrice) || barcode == null || barcode.length() == 0) {
            System.out.println("Please enter valid values");
        } else {
            Product product = products.stream()
                    .filter(pro -> pro.getBarcode().equals(barcode))
                    .findFirst()
                    .orElse(null);
            if (product == null) {
                System.out.println("No products found for this barcode");
            } else {
                product.setBarcode(newBarcode);
                product.setName(newName);
                product.setStock(newStock);
                product.setPrice(newPrice);
                System.out.println("The product was successfully edited");
                product.toPrint();
            }
        }
    }

    public void deleteProduct(String barcode) {
        if (barcode == null || barcode.length() == 0) {
            System.out.println("Please enter valid barcode");
        } else {
            Product product = products.stream()
                    .filter(pro -> pro.getBarcode().equals(barcode))
                    .findFirst()
                    .orElse(null);
            if (product == null) {
                System.out.println("No product found with the barcode you are looking for");
            } else {
                products.remove(product);
                System.out.println("product successfully removed");
            }
        }
    }

}
