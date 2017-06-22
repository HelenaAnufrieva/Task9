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
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            pool.submit(app.newRegister());
        }
        pool.shutdown();
   
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
            return new NiceCashier();
        }
        else {
            if(new Random().nextBoolean()) {
                return new NormalCashier();
            }
            else {
                return new StrangeCashier();
            }
        }
    }

}



