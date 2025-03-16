package CashRegister;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CashRegisterService {

    ArrayList<CashRegister> registers = new ArrayList<>();
    AtomicInteger idgenerator=new AtomicInteger(1000);
    public CashRegister createRegister(String name) {
        CashRegister cashRegister = new CashRegister(idgenerator.incrementAndGet(), name, 0);
        registers.add(cashRegister);
        return cashRegister;
    }

    public void getRegisters() {
        if (registers.size() > 0) {
            try {
                for (CashRegister register:registers){
                    System.out.println("ID: "+ register.getId());
                    System.out.println("Name: "+ register.getName());
                    System.out.println("Cash: "+ register.getCash());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No CashRegister record found");
        }
    }

}
