package CashRegister;

import java.util.concurrent.atomic.AtomicInteger;

public class CashRegister {
    private int id;
    private String name;
    private double cash;

    public CashRegister(int id, String name, double cash) {
        this.id = id;
        this.name = name;
        this.cash = cash;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
