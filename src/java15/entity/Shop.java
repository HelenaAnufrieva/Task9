package java15.entity;


import java15.entity.exceptions.FireInTheShop;
import java15.entity.exceptions.ShopRobbery;

import java.util.Random;

/**
 * Created by Администратор on 19.06.2017.
 */
public class Shop {
    public void work() throws ShopRobbery, FireInTheShop {
        Random random = new Random();
        if ((random.nextInt(150) + 1) == 1) // вероятность того, что в магазине случится ограбление
            throw new ShopRobbery();
        if ((random.nextInt(150) + 1) <= 2) // вероятность того, что в магазине будет пожар
            throw new FireInTheShop();
    }
}