class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 2, 3500);
    }

    public void displayDetails() {
        System.out.println("Room Type: " + getType());
        System.out.println("Beds: " + getBeds());
        System.out.println("Price: ₹" + getPrice());
    }
}