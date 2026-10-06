import java.util.Scanner;

interface Vehicle {
    double calculateCharge();
}

class Bike implements Vehicle {
    int hours;

    Bike(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return hours * 10;
    }
}

class Car implements Vehicle {
    int hours;

    Car(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        if (hours == 1) {
            return 30;
        }

        return 30 + (hours - 1) * 20;
    }
}

class Truck implements Vehicle {
    int hours;

    Truck(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {

        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }
}

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            if (type.equals("BIKE")) {
                vehicle = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicle = new Car(hours);
            } else {
                vehicle = new Truck(hours);
            }

            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n", type, charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}