import java.util.*;

interface Transport {
    double calculateFare();
}

class Bus implements Transport {
    double distance;

    Bus(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }
}

class Train implements Transport {
    double distance;

    Train(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro implements Transport {
    double distance;
    double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare() {
        return (1.50 + (0.20 * distance))
                * peakHourFactor;
    }
}

public class Main5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            Transport transport;

            if (type.equals("BUS")) {

                double distance = sc.nextDouble();

                transport = new Bus(distance);

            } else if (type.equals("TRAIN")) {

                double distance = sc.nextDouble();

                transport = new Train(distance);

            } else {

                double distance = sc.nextDouble();
                double peakHourFactor = sc.nextDouble();

                transport =
                    new Metro(distance, peakHourFactor);
            }

            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}