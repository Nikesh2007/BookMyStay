// Version 12.1

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class PersistenceService {

    private static final String FILE_NAME = "system_data.ser";

    // Save data to file
    public void saveData(RoomInventory inventory, BookingHistory history) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            // Save inventory map + booking history
            oos.writeObject(inventory.getInventoryMap());
            oos.writeObject(history.getBookings());

            System.out.println("Data saved successfully ✅");

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from file
    public void loadData(RoomInventory inventory, BookingHistory history) {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            // Read data
            HashMap<String, Integer> inventoryMap =
                    (HashMap<String, Integer>) ois.readObject();

            List<Reservation> bookings =
                    (List<Reservation>) ois.readObject();

            // Restore state
            inventory.setInventoryMap(inventoryMap);
            history.setBookings(bookings);

            System.out.println("Data loaded successfully ✅");

        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");

        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}