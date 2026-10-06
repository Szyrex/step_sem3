import java.util.*;

interface Question {
    double calculateScore();
}

class MCQQuestion implements Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    MCQQuestion(String questionText, String correctAnswer,
                String studentAnswer, double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TFQuestion implements Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    TFQuestion(String questionText, String correctAnswer,
               String studentAnswer, double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class EssayQuestion implements Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    EssayQuestion(String questionText, String correctAnswer,
                  String studentAnswer, double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {

        String[] keywords = correctAnswer.split(",");

        int matched = 0;

        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class Main4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            // Extract quoted strings
            List<String> values = new ArrayList<>();

            int index = 0;

            while (index < line.length()) {

                int start = line.indexOf('"', index);

                if (start == -1) {
                    break;
                }

                int end = line.indexOf('"', start + 1);

                values.add(line.substring(start + 1, end));

                index = end + 1;
            }

            String[] firstPart = line.split(" ", 2);

            String type = firstPart[0];

            double points =
                    Double.parseDouble(
                        line.substring(line.lastIndexOf(" ") + 1));

            String questionText = values.get(0);
            String correctAnswer = values.get(1);
            String studentAnswer = values.get(2);

            Question question;

            if (type.equals("MCQ")) {

                question = new MCQQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);

            } else if (type.equals("TF")) {

                question = new TFQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);

            } else {

                question = new EssayQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);

            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}