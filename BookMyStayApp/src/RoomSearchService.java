// Version 4.1

class RoomSearchService {

    private RoomInventory inventory;

    // Constructor
    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Search available rooms (READ-ONLY)
    public void searchAvailableRooms() {

        System.out.println("===== AVAILABLE ROOMS =====\n");

        // Create room objects (Domain Model)
        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getType());

            // Show only available rooms
            if (available > 0) {
                room.displayDetails();
                System.out.println("Available: " + available);
                System.out.println();
            }
        }
    }
}