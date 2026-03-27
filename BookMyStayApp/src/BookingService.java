import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BookingService {

    private RoomInventory inventory;
    private BookingRequestQueue requestQueue;

    // Track all allocated room IDs (no duplicates)
    private Set<String> allocatedRoomIds;

    // Map → Room Type → Set of Room IDs
    private HashMap<String, Set<String>> allocationMap;

    private int idCounter = 1;

    // Constructor
    public BookingService(RoomInventory inventory, BookingRequestQueue requestQueue) {
        this.inventory = inventory;
        this.requestQueue = requestQueue;

        allocatedRoomIds = new HashSet<>();
        allocationMap = new HashMap<>();
    }

    // Process bookings (FIFO)
    public void processBookings() {

        System.out.println("\n===== PROCESSING BOOKINGS =====\n");

        // ✅ Correct variable (IMPORTANT FIX)
        while (!requestQueue.isEmpty()) {

            Reservation request = requestQueue.getNextRequest();
            String roomType = request.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Store globally (no duplicates)
                allocatedRoomIds.add(roomId);

                // Store by room type
                allocationMap.putIfAbsent(roomType, new HashSet<>());
                allocationMap.get(roomType).add(roomId);

                // Update inventory
                inventory.updateAvailability(roomType, -1);

                // Confirm booking
                System.out.println("Booking Confirmed: "
                        + request.getGuestName()
                        + " | " + roomType
                        + " | Room ID: " + roomId);

            } else {
                System.out.println("Booking Failed: "
                        + request.getGuestName()
                        + " | No rooms available for " + roomType);
            }
        }
    }

    // Generate unique room ID
    private String generateRoomId(String roomType) {

        String id;

        do {
            id = roomType.substring(0, 2).toUpperCase() + idCounter++;
        } while (allocatedRoomIds.contains(id));

        return id;
    }

    // 🔥 IMPORTANT for Use Case 10 (Cancellation)
    public HashMap<String, Set<String>> getAllocationMap() {
        return allocationMap;
    }
}