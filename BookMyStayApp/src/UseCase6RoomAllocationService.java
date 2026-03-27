public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Initialize Inventory
        RoomInventory inventory = new RoomInventory();

        // Initialize Queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add booking requests
        queue.addRequest(new Reservation("Nikesh", "Single Room"));
        queue.addRequest(new Reservation("Kawin", "Single Room"));
        queue.addRequest(new Reservation("Sabari", "Suite Room"));
        queue.addRequest(new Reservation("Priyan", "Suite Room")); // may fail if full

        // Initialize Booking Service
        BookingService bookingService = new BookingService(inventory, queue);

        // Process bookings
        bookingService.processBookings();

        // Final inventory
        System.out.println("\n===== FINAL INVENTORY =====");
        inventory.displayInventory();
    }
}