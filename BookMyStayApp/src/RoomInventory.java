// Version 12.1

import java.util.HashMap;

public class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 10);
        inventory.put("Double Room", 5);
        inventory.put("Suite Room", 2);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int change) {
        int current = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, current + change);
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("===== ROOM INVENTORY =====");
        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " : " + inventory.get(roomType));
        }
    }

    // 🔥 Needed for Use Case 12 (Persistence)
    public HashMap<String, Integer> getInventoryMap() {
        return inventory;
    }

    public void setInventoryMap(HashMap<String, Integer> map) {
        this.inventory = map;
    }
}