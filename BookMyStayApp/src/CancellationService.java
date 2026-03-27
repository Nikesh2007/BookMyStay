// Version 10.1

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CancellationService {

    private RoomInventory inventory;

    // Track allocations (same as BookingService concept)
    private HashMap<String, Set<String>> allocationMap;

    // Stack for rollback (LIFO)
    private Stack<String> rollbackStack;

    public CancellationService(RoomInventory inventory,
                               HashMap<String, Set<String>> allocationMap) {
        this.inventory = inventory;
        this.allocationMap = allocationMap;
        this.rollbackStack = new Stack<>();
    }

    // Cancel booking
    public void cancelBooking(String roomType) {

        // Validate existence
        if (!allocationMap.containsKey(roomType) ||
                allocationMap.get(roomType).isEmpty()) {

            System.out.println("Cancellation Failed: No booking found for " + roomType);
            return;
        }

        // LIFO → get last allocated room
        String roomId = allocationMap.get(roomType)
                .iterator()
                .next(); // simple removal

        allocationMap.get(roomType).remove(roomId);

        // Push to rollback stack
        rollbackStack.push(roomId);

        // Restore inventory
        inventory.updateAvailability(roomType, +1);

        System.out.println("Cancelled Booking → Room ID: " + roomId
                + " | Type: " + roomType);
    }

    // Display rollback history
    public void displayRollbackStack() {

        System.out.println("\n===== ROLLBACK STACK =====");

        if (rollbackStack.isEmpty()) {
            System.out.println("No cancellations yet.");
            return;
        }

        for (String id : rollbackStack) {
            System.out.println(id);
        }
    }
}