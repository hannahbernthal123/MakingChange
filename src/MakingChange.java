/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Hannah Bernthal
 */

public class MakingChange {
    public static long[][] table;
    public static long countWays(int target, int[] coins) {
        table = new long[coins.length][target + 1];
//        // Memoization
//        return memoHelper(target, coins, coins.length - 1);

        // Tabulation

        // Fill in the 0th row with ones.
        for (int i = 0; i < coins.length; i++) {
            table[i][0] = 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {
                // Represents the spot that is the coin's value over to the left.
                long leftSpot = j - coins[i];

                // Represents the spot above.
                long upSpot = i - 1;

                long total = 0;

                // Check if the left spot is in bounds. If it isn't you add 0 from that part.
                if (leftSpot < 0) {
                    leftSpot = 0;
                }
                else {
                    // Otherwise, you add the value in that spot.
                    total += table[i][(int) leftSpot];
                }

                // Same as what you did for left, just looking up instead.
                if (upSpot < 0) {
                    upSpot = 0;
                }
                else {
                    total += table[(int) upSpot][j];
                }

                // Fill in the table with the summed values.
                table[i][j] = total;
            }
        }

        // Return the bottom right value because that represents the total possible ways.
        return table[coins.length - 1][target];

    }

    public static long memoHelper(int target, int[] coins, int index) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (index < 0) {
            return 0;
        }

        if (table[index][target] != 0) {
            return table[index][target];
        }

        long answer = 0;
        answer += memoHelper(target - coins[index], coins, index);
        table[index][target] = answer;

        answer += memoHelper(target, coins, index - 1);
        table[index][target] = answer;

        // Return included ways + excluded ways.
        return answer;
    }
}
