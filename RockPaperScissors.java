import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") &&
             computerMove.equalsIgnoreCase("Scissors")) ||

            (playerMove.equalsIgnoreCase("Paper") &&
             computerMove.equalsIgnoreCase("Rock")) ||

            (playerMove.equalsIgnoreCase("Scissors") &&
             computerMove.equalsIgnoreCase("Paper"))) {

            return "Player Wins";
        }
        else{
        return "Computer Wins";
        }
    }

    static String getComputerMove() {

        Random random = new Random();

        int choice = random.nextInt(3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rounds = 5;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Rock-Paper-Scissors Game");
        System.out.println("Enter Rock, Paper, or Scissors");

        for (int i = 0; i < rounds; i++) {

            System.out.print("Round " + (i + 1) + " - Your move: ");
            playerMoves[i] = sc.nextLine();

            computerMoves[i] = getComputerMove();

            results[i] = playRound(
                playerMoves[i],
                computerMoves[i]
            );

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println(
                "Computer: " + computerMoves[i]
            );

            System.out.println(
                "Result: " + results[i]
            );

            System.out.println();
        }

        double winPercentage =
            ((double) wins / rounds) * 100;

        System.out.println("Final Summary");
        System.out.println("-----------------------------------------------");
        System.out.printf(
            "%-8s %-15s %-15s %-15s%n",
            "Round", "Player Move", "Computer Move", "Result"
        );
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < rounds; i++) {

            System.out.printf(
                "%-8d %-15s %-15s %-15s%n",
                (i + 1),
                playerMoves[i],
                computerMoves[i],
                results[i]
            );
        }

        System.out.println("-----------------------------------------------");

        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf(
            "Win %%  : %.1f%%%n",
            winPercentage
        );

        sc.close();
    }
}