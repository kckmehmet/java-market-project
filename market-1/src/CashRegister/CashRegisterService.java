package CashRegister;

import java.util.ArrayList;

public class CashRegisterService {

    ArrayList<CashRegister> registers = new ArrayList<>();

    public CashRegister createRegister(int id, String name) {
        CashRegister cashRegister = new CashRegister(id, name, 0);
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
