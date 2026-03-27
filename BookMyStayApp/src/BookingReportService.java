// Version 8.1

import java.util.List;

public class BookingReportService {

    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // Display all bookings
    public void displayAllBookings() {

        System.out.println("===== BOOKING HISTORY =====");

        List<Reservation> list = history.getAllReservations();

        if (list.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : list) {
            r.displayReservation();
        }
    }

    // Generate summary report
    public void generateSummary() {

        List<Reservation> list = history.getAllReservations();

        System.out.println("\n===== BOOKING SUMMARY =====");
        System.out.println("Total Bookings: " + list.size());
    }
}