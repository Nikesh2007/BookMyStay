public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        // Initialize Queue
        BookingRequestQueue requestQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Nikesh", "Single Room");
        Reservation r2 = new Reservation("Kawin", "Double Room");
        Reservation r3 = new Reservation("Sabari", "Suite Room");

        // Add requests (FIFO order)
        requestQueue.addRequest(r1);
        requestQueue.addRequest(r2);
        requestQueue.addRequest(r3);

        // Display queue
        requestQueue.displayQueue();
    }
}