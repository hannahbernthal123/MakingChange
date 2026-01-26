/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Hannah Bernthal
 */

public class MakingChange {
    public static long countWays(int target, int[] coins) {
        long[][] memoizationTable = new long[target + 1][coins.length];

        int index = 0;
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (index == coins.length) {
            return 0;
        }



        return 0;
    }
}
