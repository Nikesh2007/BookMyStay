// Version 9.1

import java.util.Set;

public class BookingValidator {

    private RoomInventory inventory;

    public BookingValidator(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Validate booking request
    public void validate(Reservation reservation) throws InvalidBookingException {

        String roomType = reservation.getRoomType();

        // 1. Validate room type
        Set<String> validTypes = Set.of("Single Room", "Double Room", "Suite Room");

        if (!validTypes.contains(roomType)) {
            throw new InvalidBookingException("Invalid Room Type: " + roomType);
        }

        // 2. Check availability
        int available = inventory.getAvailability(roomType);

        if (available <= 0) {
            throw new InvalidBookingException("No rooms available for: " + roomType);
        }
    }

    // Validate inventory update
    public void validateInventoryUpdate(String roomType, int change) throws InvalidBookingException {

        int current = inventory.getAvailability(roomType);

        if (current + change < 0) {
            throw new InvalidBookingException("Inventory cannot go negative for: " + roomType);
        }
    }
}