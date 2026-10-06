class Scorecard {
    private boolean[] results;
    private int answerCount;
    private int score;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answerCount = 0;
        score = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answerCount >= results.length) {
            System.out.println("Cannot record more answers.");
            return;
        }

        results[answerCount] = correct;

        if (correct) {
            score++;
        }

        answerCount++;
    }

    public int getScore() {
        return score;
    }
}

public class Main2 {
    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}