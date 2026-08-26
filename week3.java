public class week3 {
    //VotingEligibilityChecker
    static void checkVotingEligibility(int age) {
        boolean eligible = age >= 18;
        if (eligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        int age = 20;
        checkVotingEligibility(age);
    }
}