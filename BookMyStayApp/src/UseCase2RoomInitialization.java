public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        int singleAvailable = 10;
        int doubleAvailable = 5;
        int suiteAvailable = 2;

        System.out.println("===== HOTEL ROOM DETAILS =====\n");

        r1.displayDetails();
        System.out.println("Available Rooms: " + singleAvailable);
        System.out.println();

        r2.displayDetails();
        System.out.println("Available Rooms: " + doubleAvailable);
        System.out.println();

        r3.displayDetails();
        System.out.println("Available Rooms: " + suiteAvailable);
    }
}