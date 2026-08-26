public class week3 {
//NumberClassifier
    static void classifyNumber(int number) {

        if (number > 0) {
            System.out.println("Positive");
        } 
        else if (number < 0) {
            System.out.println("Negative");
        } 
        else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {
        int number = 15;
        classifyNumber(number);
    }
}
