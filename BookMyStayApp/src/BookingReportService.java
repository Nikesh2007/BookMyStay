// Version 12.2 (Fully Compatible)

import java.util.List;

public class BookingReportService {

    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // Primary method
    public void displayBookings() {

        System.out.println("===== BOOKING HISTORY =====");

        List<Reservation> list = history.getBookings();

        if (list.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Reservation r : list) {
            r.displayReservation();
        }
    }

    // 🔥 Compatibility method (fixes your error)
    public void displayAllBookings() {
        displayBookings();
    }

    // Report
    public void generateReport() {

        List<Reservation> list = history.getBookings();

        System.out.println("\n===== REPORT =====");
        System.out.println("Total Bookings: " + list.size());
    }
}