class AttendanceSheet {
    private String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxStudents) {
        presentStudents = new String[maxStudents];
        presentCount = 0;
    }

    public void markPresent(String name) {

        // Check if student is already present
        if (isPresent(name)) {
            return;
        }

        // Check if the array is full
        if (presentCount >= presentStudents.length) {
            System.out.println("Attendance sheet is full.");
            return;
        }

        presentStudents[presentCount] = name;
        presentCount++;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class Main5 {
    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());

        System.out.println("Ben present: " + sheet.isPresent("Ben"));

        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}