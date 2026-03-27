import java.util.*;

public class BookingService {

    private RoomInventory inventory;
    private BookingRequestQueue requestQueue;

    private Set<String> allocatedRoomIds;
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

        // ✅ FIXED HERE
        while (!requestQueue.isEmpty()) {

            Reservation request = requestQueue.getNextRequest();
            String roomType = request.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique ID
                String roomId = generateRoomId(roomType);

                allocatedRoomIds.add(roomId);

                allocationMap.putIfAbsent(roomType, new HashSet<>());
                allocationMap.get(roomType).add(roomId);

                // Update inventory
                inventory.updateAvailability(roomType, -1);

                System.out.println("Booking Confirmed: "
                        + request.getGuestName()
                        + " | " + roomType
                        + " | ID: " + roomId);

            } else {
                System.out.println("Booking Failed: "
                        + request.getGuestName()
                        + " | No rooms available");
            }
        }
    }

    // Unique ID generator
    private String generateRoomId(String roomType) {

        String id;

        do {
            id = roomType.substring(0, 2).toUpperCase() + idCounter++;
        } while (allocatedRoomIds.contains(id));

        return id;
    }
}