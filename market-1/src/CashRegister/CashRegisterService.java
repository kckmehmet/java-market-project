package CashRegister;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CashRegisterService {

    private ArrayList<CashRegister> registers=new ArrayList<>();
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

    public void dataSave(String fileName){
        try (ObjectOutputStream objectOutput=new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutput.writeObject(registers);
            System.out.println("files saved successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<CashRegister> dataLoad(String fileName){
        try (ObjectInputStream objectInput=new ObjectInputStream(new FileInputStream(fileName));){
            ArrayList<CashRegister> loadRegisters= (ArrayList<CashRegister>) objectInput.readObject();
            return loadRegisters;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
