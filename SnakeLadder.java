import java.util.Random;

public class SnakeLadder {
    private static int position = 0;
    private static final int SNAKE = -1;
    private static final int LADDER = 0;
    private static int noOfRolls = 0;

    // For random number generation
    private static Random random;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    private static int roll() {
        noOfRolls++;
        return random.nextInt(6) + 1; // [1,6]
    }

    private static int snakeOrLadder() {
        return random.nextInt(3) - 1; // -1,0,1
    }

    public static void main(String[] args) {
        while (position < 100) {
            int roll = roll();
            switch (snakeOrLadder()) {
                case SNAKE:
                    position -= roll;
                    if (position < 0)
                        position = 0;
                    break;
                case LADDER:
                    position += roll;
                    if (position > 100)
                        position -= roll;
                    break;
                default:
                    // no play
            }
            System.out.println("Current: " + position);
        }
        System.out.println("No of throws: " + noOfRolls);
    }
}
