// Version 3.1

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Create Inventory Object
        RoomInventory inventory = new RoomInventory();

        // Show initial state
        inventory.displayInventory();

        System.out.println("\n--- Updating Inventory ---\n");

        // Simulate updates
        inventory.updateAvailability("Single Room", -2);
        inventory.updateAvailability("Double Room", +1);
        inventory.updateAvailability("Suite Room", -1);

        // Show updated state
        inventory.displayInventory();
    }
}