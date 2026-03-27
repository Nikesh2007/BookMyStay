public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        // Initialize booking history
        BookingHistory history = new BookingHistory();

        // Simulate confirmed bookings (from Use Case 6)
        Reservation r1 = new Reservation("Nikesh", "Single Room");
        Reservation r2 = new Reservation("Kawin", "Double Room");
        Reservation r3 = new Reservation("Sabari", "Suite Room");

        // Add to history
        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        // Initialize report service
        BookingReportService reportService = new BookingReportService(history);

        // Display full history
        reportService.displayAllBookings();

        // Generate summary
        reportService.generateReport();
    }
}