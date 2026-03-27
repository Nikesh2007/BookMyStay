// Version 8.1

import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    // Get all reservations (read-only access)
    public List<Reservation> getAllReservations() {
        return history;
    }
}
