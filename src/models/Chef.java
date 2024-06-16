package models;

import java.util.List;

public class Chef {
    public static void receiveOrder(List<String> dishes) {
        // Process the received dishes
        System.out.println("Chef received the following order:");
        for (String dish : dishes) {
            System.out.println("- " + dish);
            // Add your logic to handle each dish (e.g., prepare, cook, etc.)
        }
    }
}

