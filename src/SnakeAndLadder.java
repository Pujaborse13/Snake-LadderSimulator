import java.util.Random;

public class SnakeAndLadder {
    public static void main(String[] args) {
        System.out.println("Welcome to the Snake and Ladder Game!");

        int player1Position = 0;
        int player2Position = 0;
        int diceRollCount = 0;
        final int WINNING_POSITION = 100;
        Random random = new Random();

        boolean isPlayer1Turn = true;
        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {

            int currentPosition = isPlayer1Turn ? player1Position : player2Position;
            String currentPlayer = isPlayer1Turn ? "Player 1" : "Player 2";

            int dieRoll = random.nextInt(6) + 1; // Generates a random number between 1 and 6
            diceRollCount++;
            System.out.println(currentPlayer + " rolls the die and gets: " + dieRoll);

            int option = random.nextInt(3);
            boolean playAgain = false;

            switch (option) {

                case 0: // No Play
                    System.out.println("Option: No Play. " + currentPlayer + " stays at the same position.");
                    break;


                case 1: // Ladder
                    System.out.println("Option: Ladder! " + currentPlayer + " moves ahead by " + dieRoll + " positions.");
                    if (currentPosition + dieRoll <= WINNING_POSITION) {
                        currentPosition += dieRoll;
                        playAgain = true; // Player gets another turn
                    } else {
                        System.out.println("Roll exceeds 100. " + currentPlayer + " stays at position " + currentPosition);
                    }
                    break;


                case 2: // Snake
                    System.out.println("Option: Snake! " + currentPlayer + " moves behind by " + dieRoll + " positions.");
                    currentPosition -= dieRoll;
                    if (currentPosition < 0) {
                        currentPosition = 0; // Reset to 0 if position goes below 0
                        System.out.println(currentPlayer + " moves below 0 and restarts from 0.");
                    }

                    break;
            }


            if (isPlayer1Turn) {
                player1Position = currentPosition;
            } else {
                player2Position = currentPosition;
            }

            System.out.println(currentPlayer + "'s position after this roll: " + currentPosition);
            System.out.println("-------------------------------------------------");

            if (currentPosition == WINNING_POSITION) {
                System.out.println("Congratulations! " + currentPlayer + " wins the game!");
                break;
            }
            if (!playAgain) {
                isPlayer1Turn = !isPlayer1Turn;
            }
        }

        System.out.println("Game Over!");
        System.out.println("Total dice rolls in the game: " + diceRollCount);
        System.out.println("Player 1 final position: " + player1Position);
        System.out.println("Player 2 final position: " + player2Position);
    }

}