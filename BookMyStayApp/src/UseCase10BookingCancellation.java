public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Initialize queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add booking requests
        queue.addRequest(new Reservation("Nikesh", "Single Room"));
        queue.addRequest(new Reservation("Kawin", "Single Room"));

        // Booking service
        BookingService bookingService = new BookingService(inventory, queue);

        // Process bookings
        bookingService.processBookings();

        // Initialize cancellation service
        CancellationService cancelService =
                new CancellationService(inventory, bookingService.getAllocationMap());

        System.out.println("\n===== CANCELLATION =====");

        // Cancel bookings
        cancelService.cancelBooking("Single Room");
        cancelService.cancelBooking("Single Room");
        cancelService.cancelBooking("Single Room"); // should fail

        // Show rollback history
        cancelService.displayRollbackStack();

        // Final inventory
        System.out.println("\n===== FINAL INVENTORY =====");
        inventory.displayInventory();
    }
}