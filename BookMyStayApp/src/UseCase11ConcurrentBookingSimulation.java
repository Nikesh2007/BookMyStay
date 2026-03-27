public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        // Shared Inventory (CRITICAL RESOURCE)
        RoomInventory inventory = new RoomInventory();

        // Shared Queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Simulate multiple guests adding requests
        queue.addRequest(new Reservation("Nikesh", "Single Room"));
        queue.addRequest(new Reservation("Kawin", "Single Room"));
        queue.addRequest(new Reservation("Sabari", "Single Room"));
        queue.addRequest(new Reservation("Priyan", "Single Room"));

        // Shared Booking Service
        BookingService bookingService = new BookingService(inventory, queue);

        // Multiple Threads (Simulating multiple users)
        ConcurrentBookingProcessor t1 = new ConcurrentBookingProcessor(bookingService);
        ConcurrentBookingProcessor t2 = new ConcurrentBookingProcessor(bookingService);
        ConcurrentBookingProcessor t3 = new ConcurrentBookingProcessor(bookingService);

        // Start threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        // Final Inventory
        System.out.println("\n===== FINAL INVENTORY =====");
        inventory.displayInventory();
    }
}