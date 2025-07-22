
import java.util.*;

class Room {
    String type;
    boolean isAvailable;

    Room(String type) {
        this.type = type;
        this.isAvailable = true;
    }
}

public class HotelReservationSystem {
    static Map<Integer, Room> rooms = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rooms.put(101, new Room("Standard"));
        rooms.put(102, new Room("Deluxe"));
        rooms.put(201, new Room("Suite"));

        int choice;
        do {
            System.out.println("\n1. View Rooms\n2. Book Room\n3. Cancel Booking\n4. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (int no : rooms.keySet()) {
                        Room r = rooms.get(no);
                        System.out.println("Room " + no + " (" + r.type + ") - " + (r.isAvailable ? "Available" : "Booked"));
                    }
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomToBook = sc.nextInt();
                    if (rooms.containsKey(roomToBook) && rooms.get(roomToBook).isAvailable) {
                        rooms.get(roomToBook).isAvailable = false;
                        System.out.println("Room booked successfully!");
                    } else System.out.println("Invalid or already booked room.");
                    break;
                case 3:
                    System.out.print("Enter room number to cancel: ");
                    int roomToCancel = sc.nextInt();
                    if (rooms.containsKey(roomToCancel) && !rooms.get(roomToCancel).isAvailable) {
                        rooms.get(roomToCancel).isAvailable = true;
                        System.out.println("Booking cancelled.");
                    } else System.out.println("Invalid or not booked room.");
                    break;
            }
        } while (choice != 4);

        sc.close();
    }
}
