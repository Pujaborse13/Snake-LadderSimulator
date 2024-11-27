import java.util.Random;

public class SnakeAndLadder {
    public static void main(String[] args) {
        System.out.println("Welcome to the Snake and Ladder Game!");

        int playerPosition = 0;
        final int WINNING_POSITION = 100;
        Random random = new Random();

        while (playerPosition < WINNING_POSITION) {
            int dieRoll = random.nextInt(6) + 1;
            System.out.println("Player rolls the die and gets: " + dieRoll);

            int option = random.nextInt(3);
            switch (option) {
                case 0: // No Play
                    System.out.println("Option: No Play. Player stays at the same position.");
                    break;

                case 1: // Ladder
                    System.out.println("Option: Ladder! Player moves ahead by " + dieRoll + " positions.");
                    playerPosition += dieRoll;
                    break;

                case 2: // Snake
                    System.out.println("Option: Snake! Player moves behind by " + dieRoll + " positions.");
                    playerPosition -= dieRoll;
                    break;
            }
            if (playerPosition < 0) {
                playerPosition = 0;
                System.out.println("Player moves below 0 and restarts from 0.");
            }
            if (playerPosition > WINNING_POSITION) {
                playerPosition -= dieRoll;
                System.out.println("Player cannot move beyond position 100.");
            }

            System.out.println("Player's current position: " + playerPosition);
            System.out.println("-------------------------------------------------");
        }

        System.out.println("Congratulations! Player reached the winning position: " + WINNING_POSITION);
    }

}