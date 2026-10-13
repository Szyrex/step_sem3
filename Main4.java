import java.util.Scanner;

interface NightService {
    double applyNightCharge(double fare);
}

abstract class Cab {
    double km;
    static final double MIN_FARE = 100.0;

    Cab(double km) {
        this.km = km;
    }

    abstract double calculateBaseFare();

    abstract String getType();

    double calculateFare(boolean night) {
        double fare = Math.max(calculateBaseFare(), MIN_FARE);

        if (night && this instanceof NightService) {
            fare = ((NightService) this).applyNightCharge(fare);
        }

        return fare;
    }

    boolean supportsNightService() {
        return this instanceof NightService;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 10;
    }

    String getType() {
        return "MINI";
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 14;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SEDAN";
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 18;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SUV";
    }
}

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        boolean[] nightTrips = new boolean[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            nightTrips[i] = time.equals("NIGHT");

            switch (type) {
                case "MINI":
                    cabs[i] = new Mini(km);
                    break;
                case "SEDAN":
                    cabs[i] = new Sedan(km);
                    break;
                case "SUV":
                    cabs[i] = new SUV(km);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            Cab cab = cabs[i];

            if (nightTrips[i] && !cab.supportsNightService()) {
                System.out.println(cab.getType()
                        + ": night service not available");
            } else {
                double fare = cab.calculateFare(nightTrips[i]);

                System.out.printf("%s: %.2f%n",
                        cab.getType(), fare);

                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}