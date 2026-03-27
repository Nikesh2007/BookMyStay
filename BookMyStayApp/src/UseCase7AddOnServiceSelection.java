public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        // Assume reservation already exists (from Use Case 6)
        String reservationId = "SI101"; // example ID

        // Initialize Service Manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Create services
        Service wifi = new Service("WiFi", 200);
        Service breakfast = new Service("Breakfast", 500);
        Service spa = new Service("Spa", 1000);

        // Add services to reservation
        manager.addService(reservationId, wifi);
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);

        // Display services
        manager.displayServices(reservationId);

        // Show total cost
        double total = manager.calculateTotalCost(reservationId);
        System.out.println("\nTotal Add-On Cost: ₹" + total);
    }
}