public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        BookingValidator validator = new BookingValidator(inventory);

        // Test cases
        Reservation valid = new Reservation("Nikesh", "Single Room");
        Reservation invalidType = new Reservation("Kawin", "Luxury Room");
        Reservation noAvailability = new Reservation("Sabari", "Suite Room");

        try {
            // Valid booking
            validator.validate(valid);
            System.out.println("Booking Valid for: " + valid.getGuestName());

            // Invalid room type
            validator.validate(invalidType);

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Force inventory to zero
            inventory.updateAvailability("Suite Room", -2);

            // Now this should fail
            validator.validate(noAvailability);

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Negative inventory test
            validator.validateInventoryUpdate("Single Room", -20);

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nSystem is still running safely ✅");
    }
}