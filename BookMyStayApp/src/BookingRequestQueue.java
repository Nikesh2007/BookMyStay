import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private Queue<Reservation> queue;

    // Constructor
    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add request (ENQUEUE)
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Request Added: " + reservation.getGuestName());
    }

    // Get next request (DEQUEUE)
    public Reservation getNextRequest() {
        return queue.poll(); // removes and returns first element
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Display all requests (without removing)
    public void displayQueue() {
        System.out.println("\n===== BOOKING REQUEST QUEUE =====");

        for (Reservation r : queue) {
            r.displayReservation();
        }
    }
}