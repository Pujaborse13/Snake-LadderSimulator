import java.util.Random;

public class SnakeAndLadder  {
    public static void main(String[] args) {
        System.out.println("Welcome to the Snake and Ladder Game!");

        int playerPosition = 0;
        System.out.println("Starting Position of Player: " + playerPosition);

        Random random = new Random();
        int dieRoll = random.nextInt(6) + 1;
        System.out.println("Player rolls the die and gets: " + dieRoll);
    }
}