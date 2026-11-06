import java.util.Scanner;
 
public class TollBooth {
 
    enum Vehicle {
        BIKE, CAR, TRUCK
    }
 
    record VehicleInfo(String name, int toll) {
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;
 
        System.out.println("Welcome to Toll Booth!");
 
        while (true) {
            System.out.print("Enter vehicle (BIKE, CAR, TRUCK): ");
            Vehicle vehicle = Vehicle.valueOf(sc.next().toUpperCase());
 
            VehicleInfo info = switch (vehicle) {
                case BIKE -> new VehicleInfo("Bike", 20);
                case CAR -> new VehicleInfo("Car", 50);
                case TRUCK -> new VehicleInfo("Truck", 150);
            };
 
            totalToll += info.toll();
 
            switch (vehicle) {
                case BIKE -> bikeCount++;
                case CAR -> carCount++;
                case TRUCK -> truckCount++;
            }
 
            System.out.println(info.name() + " toll: " + info.toll());
            System.out.println("Total toll collected: " + totalToll);
 
            System.out.print("Continue? (YES/NO): ");
            if (sc.next().equalsIgnoreCase("NO")) {
                break;
            }
        }
 
        System.out.println("\n--- Toll Booth Summary ---");
        System.out.println("Total toll: " + totalToll);
        System.out.println("Bikes: " + bikeCount);
        System.out.println("Cars: " + carCount);
        System.out.println("Trucks: " + truckCount);
 
        int maxCount = Math.max(bikeCount,
                        Math.max(carCount, truckCount));
 
        System.out.print("Most frequent: ");
 
        if (maxCount == 0) {
            System.out.println("None");
        } else {
            boolean first = true;
 
            if (bikeCount == maxCount) {
                System.out.print("bike");
                first = false;
            }
 
            if (carCount == maxCount) {
                System.out.print(first ? "car" : ", car");
                first = false;
            }
 
            if (truckCount == maxCount) {
                System.out.print(first ? "truck" : ", truck");
            }
 
            System.out.println();
        }
 
        sc.close();
    }
}
