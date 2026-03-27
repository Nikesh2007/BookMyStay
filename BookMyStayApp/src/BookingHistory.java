// Version 12.2 (Fully Compatible)

import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    private List<Reservation> bookings;

    // Constructor
    public BookingHistory() {
        bookings = new ArrayList<>();
    }

    // ✅ Primary method
    public void addBooking(Reservation reservation) {
        bookings.add(reservation);
    }

    // 🔥 Compatibility method (fixes your error)
    public void addReservation(Reservation reservation) {
        bookings.add(reservation);
    }

    // Get bookings
    public List<Reservation> getBookings() {
        return bookings;
    }

    // Compatibility method
    public List<Reservation> getAllReservations() {
        return bookings;
    }

    // For persistence
    public void setBookings(List<Reservation> bookings) {
        this.bookings = bookings;
    }
}