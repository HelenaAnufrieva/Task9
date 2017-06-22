package java15.entity.exceptions;

public class ShopRobbery extends RuntimeException {
    private String message;
    public ShopRobbery()
    {
        this.message = "Shop is robbing now!!!";
    }
    public void message ()
    {
        System.out.println(message);
    }
}