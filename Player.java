import java.util.Random;

public class Player {
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

    public boolean hasWon() {
        return position == 100;
    }

    public int getThrows() {
        return noOfRolls;
    }

    public void move() {
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
                move();
                break;
            default:
                // no play
        }
        System.out.println("Current: " + position);
    }

    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();

        while (p1.hasWon() || p2.hasWon()) {
            p1.move();
            p2.move();

        }
        System.out.println(p1.hasWon() ? "Player 1" : "Player 2" + " has Won!");
    }
}

