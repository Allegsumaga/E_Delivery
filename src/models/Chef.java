package models;

<<<<<<< HEAD
public class Chef {
    public static void main(String[] args) {
        // This main method can be developed later
        System.out.println("Chef.java data receiver.");
=======
import java.util.List;

public class Chef {
    public static void receiveOrder(List<String> dishes) {
        // Process the received dishes
        System.out.println("Chef received the following order:");
        for (String dish : dishes) {
            System.out.println("- " + dish);
            // Add your logic to handle each dish (e.g., prepare, cook, etc.)
        }
>>>>>>> bronze
    }
}

