import java.util.Arrays;

public class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public Candidate(
            String name,
            double cgpa,
            int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // CGPA-only eligibility
    static boolean isEligible(double cgpa) {

        return cgpa >= 7.5;
    }

    // Combined CGPA + coding score eligibility
    static boolean isEligible(
            double cgpa,
            int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Calculate composite score
    private double getCompositeScore() {

        return (cgpa * 10) + codingScore;
    }

    // Compare candidates by composite score
    // in descending order
    @Override
    public int compareTo(Candidate other) {

        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }

    static String shortlistAndRank(
            Candidate[] candidates) {

        // Temporary array for shortlisted candidates
        Candidate[] shortlisted =
            new Candidate[candidates.length];

        int count = 0;

        // Find eligible candidates
        for (Candidate candidate : candidates) {

            if (isEligible(candidate.cgpa) ||
                isEligible(
                    candidate.cgpa,
                    candidate.codingScore
                )) {

                shortlisted[count] = candidate;
                count++;
            }
        }

        // Create an array containing only
        // shortlisted candidates
        Candidate[] finalList =
            Arrays.copyOf(shortlisted, count);

        // Sort using Candidate's compareTo()
        Arrays.sort(finalList);

        // Build output
        StringBuilder result =
            new StringBuilder();

        for (int i = 0; i < finalList.length; i++) {

            result.append(i + 1)
                  .append(". ")
                  .append(finalList[i].name)
                  .append(" (")
                  .append(
                      String.format(
                          "%.1f",
                          finalList[i].getCompositeScore()
                      )
                  )
                  .append(")");

            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

            new Candidate("Aisha", 8.2, 40),

            new Candidate("Rohit", 6.8, 65),

            new Candidate("Meena", 6.0, 90),

            new Candidate("Karan", 7.5, 20)
        };

        String result =
            shortlistAndRank(candidates);

        System.out.println(result);
    }
}