import java.util.Scanner;

abstract class Student {
    String name;
    static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    boolean usesBus() {
        return false;
    }

    double calculateTotalFee() {
        double total = calculateTuition();

        if (usesBus()) {
            total += TRANSPORT_FEE;
        }

        return total;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000.0;
    }

    boolean usesBus() {
        return true;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] students = new Student[n];
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    students[i] = new Scholar(name);
                    break;
            }
        }

        for (Student s : students) {
            double fee = s.calculateTotalFee();

            System.out.printf("%s: %.2f%n", s.name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}