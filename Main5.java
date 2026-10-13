import java.util.Scanner;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    double hours;
    static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }

    boolean supportsSaver() {
        return this instanceof SaverMode;
    }

    double getUnits(boolean saver) {
        double units = calculateUnits();

        if (saver && this instanceof SaverMode) {
            units = ((SaverMode) this).applySaver(units);
        }

        return units;
    }

    double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }

    String getType() {
        return "AC";
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }

    String getType() {
        return "WASHER";
    }
}

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Appliance[] appliances = new Appliance[n];
        boolean[] saverModes = new boolean[n];
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            String mode = "";
            if (sc.hasNextLine()) {
                mode = sc.nextLine().trim();
            }

            saverModes[i] = mode.equals("SAVER");

            switch (type) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;
                case "AC":
                    appliances[i] = new AC(hours);
                    break;
                case "TV":
                    appliances[i] = new TV(hours);
                    break;
                case "WASHER":
                    appliances[i] = new Washer(hours);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            Appliance appliance = appliances[i];
            boolean saver = saverModes[i];

            if (saver && !appliance.supportsSaver()) {
                System.out.println(appliance.getType()
                        + ": saver mode not supported");
                continue;
            }

            double units = appliance.getUnits(saver);
            double cost = appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                appliance.getType(), units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}