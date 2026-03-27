public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();

        PersistenceService persistence = new PersistenceService();

        // Load previous state (if exists)
        persistence.loadData(inventory, history);

        System.out.println("\n===== CURRENT STATE =====");
        inventory.displayInventory();

        // Simulate new booking
        Reservation r1 = new Reservation("Nikesh", "Single Room");
        history.addBooking(r1);
        inventory.updateAvailability("Single Room", -1);

        System.out.println("\nAfter New Booking:");
        inventory.displayInventory();

        // Save state before exit
        persistence.saveData(inventory, history);
    }
}