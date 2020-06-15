import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1



Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.


Example 3:

Input: amount = 10, coins = [10]
Output: 1


Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
 */
public class CoinChange2 {

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        change(10, coins);
        coins = new int[]{1,2,5};
        change(100, coins);
        //System.out.println(change(10, coins));
        coins = new int[]{3,5,7,8,9,10,11};
        change(500, coins);
        //System.out.println(change(500, coins));
    }

    private static int change(int amount, int[] coins) {
        int ans = 0;
        ans = helper1(amount, coins, 0);
        System.out.println(ans);
        ans = helper2(amount, coins, 0);
        System.out.println(ans);
        ans = helper3(amount, coins);
        System.out.println(ans);

        return ans;
    }

    // Recursive
    private static int helper1(int amount, int[] coins, int n) {
        int ans = 0;
        int size = coins.length;
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (n == size && amount > 0) return 0;
        return helper1(amount-coins[n], coins, n) + helper1(amount, coins, n+1);
    }

    // DP 1-fold
    static Map<String, Integer> map = new HashMap<>();
    private static int helper2(int amount, int[] coins, int n) {
        int ans = 0;
        int size = coins.length;
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (n == size && amount > 0) return 0;
        String key = amount + "$" + n;
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            map.put(key, helper2(amount-coins[n], coins, n) + helper2(amount, coins, n+1));
        }
        return map.get(key);
    }


    // DP 2-fold array
    private static int helper3(int amount, int[] coins) {
        // create 2-fold array with size+1, so dp[0][0] really means the amount is 0 and there is no coin.
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <=coins.length; i++) {
            // if amount is 0, we return empty list
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                // the ith element is excluded, jump to next
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    // include scenario, note that coins size is the real size, without increment.
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
