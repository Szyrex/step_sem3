public class week3 {
//SumOfNaturalNumbers
    static void sumOfNaturalNumbers(int n) {
        int counter = 1;
        int sum = 0;

        while (counter <= n) {
            sum = sum + counter;
            counter++;
        }

        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }

    public static void main(String[] args) {
        int n = 5;
        sumOfNaturalNumbers(n);
    }
}