// Version 11.1

public class ConcurrentBookingProcessor extends Thread {

    private BookingService bookingService;

    public ConcurrentBookingProcessor(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void run() {

        // Critical Section → Only one thread executes at a time
        synchronized (bookingService) {
            bookingService.processBookings();
        }
    }
}