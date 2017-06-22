package java15.entity.exceptions;

public class FireInTheShop extends RuntimeException { // Runtime
    private String message; // = "Fire"
    public FireInTheShop()
    {
        this.message = "Shop is on fire!!!";
    }
    public void message ()
    {
        System.out.println(message);
    }
}