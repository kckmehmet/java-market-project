package sales;

import CashRegister.CashRegister;
import product.Product;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class SalesService {

    ArrayList<Sale> sales = new ArrayList<>();
    AtomicLong idGenerator = new AtomicLong(1000L);

    public Sale createSale(ArrayList<Product> products, double totalPrice, CashRegister cashRegister) {
        if (products.size() > 0 || totalPrice > 0) {
            try {
                Sale sale = new Sale(idGenerator.incrementAndGet(), products, totalPrice,cashRegister);
                cashRegister.setCash(cashRegister.getCash()+totalPrice);
                sales.add(sale);
                return sale;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("please add something to your shopping cart");
            return null;
        }
    }

    public void getSales() {
        if (sales.size() > 0) {
            System.out.println("");
            System.out.printf("%-10s %-8s %-15s", "Sales Number", "Total Product", "Total Price");
            System.out.println("");
            System.out.println("-------------------------------------------------------------");
            for (Sale sale : sales) {
                System.out.printf("%-10s %-8s %-15.2f%n",
                        sale.getSalesNumber(), sale.getSoldProducts().size(), sale.getTotalPrice());
            }
        } else {
            System.out.println("No registered sale found");
        }
    }

    public void getSoldProduct(Sale sale) {
        if (sale==null) {
            System.out.println("");
            System.out.printf("%-8s %-20s %-15s", "Barcode", "Product Name", "Price");
            System.out.println("");
            System.out.println("-------------------------------------------------------------");
            for (Product product : sale.getSoldProducts()) {
                System.out.printf("%-8s %-20s %-10d %-15.2f%n",
                        product.getBarcode(), product.getName(), product.getPrice());
            }
        }else {
            System.out.println("Please enter a valid sale");
        }

    }

}
