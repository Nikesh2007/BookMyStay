public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Initialize Inventory (State)
        RoomInventory inventory = new RoomInventory();

        // Initialize Search Service
        RoomSearchService searchService = new RoomSearchService(inventory);

        // Perform Search (READ ONLY)
        searchService.searchAvailableRooms();
    }
}