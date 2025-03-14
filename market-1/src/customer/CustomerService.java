package customer;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class CustomerService {

    ArrayList<Customer> customers=new ArrayList<>();
    private AtomicLong idGenerate=new AtomicLong(1000L);
    public Customer createCustomer(String firstName,String lastName,String email,double balance){
        try {
            if (firstName!=null||lastName!=null||email!=null||balance>=0){
                Customer customer=new Customer(firstName,lastName,email,balance);
                customer.setId(idGenerate.incrementAndGet());
                customers.add(customer);
                return customer;
            }else {
                System.out.println("You must enter valid data for the customer. No value can be left blank");
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void getCustomers(){
        try {
            for (Customer customer:customers){
                System.out.println("Customer ID: "+customer.getId());
                System.out.println("Name: "+customer.getFirstName()+" "+customer.getLastName());
                System.out.println("Email: "+customer.getEmail());
                System.out.println("Balance: "+customer.getBalance());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
