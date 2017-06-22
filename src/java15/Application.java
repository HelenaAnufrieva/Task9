package java15;

import java15.entity.Cashier;
import java15.entity.Customer;
import java15.entity.Register;
import java15.entity.cashiers.NiceCashier;
import java15.entity.cashiers.StrangeCashier;
import java15.entity.cashiers.NormalCashier;
import java15.entity.customers.CustomerWithCreditCard;
import java15.entity.customers.NormalCustomer;
import java15.entity.customers.SlowlyCustomer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        Application app = new Application();

        ExecutorService pool = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            System.out.println("REGISTER NUMBER: " + (i + 1));
            pool.submit(app.newRegister());
            Thread.currentThread().sleep(200);
        }
        pool.shutdown();
        System.out.println("Shop is closed!");
    }

    private Register newRegister()
    {
        Register register = new Register(randomCashier());
        for (int j = 0; j < 20; j++) {
            register.newCustomer(randomCustomer());
        }
        return register;
    }

    private Customer randomCustomer()
    {
        if(new Random().nextInt(2) == 0)

            return new CustomerWithCreditCard();
        else {
            if(new Random().nextBoolean())
                return new NormalCustomer();
            else return new SlowlyCustomer();
        }
    }

    private Cashier randomCashier()
    {
        if(new Random().nextInt(2) == 0) {
            System.out.println("Nice Cashier");
            return new NiceCashier();

        }
        else {
            if(new Random().nextBoolean()) {
                System.out.println(" Normal Cashier");
                return new NormalCashier();

            }
            else {
                System.out.println("Strange Cashier");
                return new StrangeCashier();
            }
        }
    }

}







