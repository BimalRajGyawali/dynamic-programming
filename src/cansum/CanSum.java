package src.cansum;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSum(remainder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);

        return false;
    }

    public static void main(String[] args) {
        CanSum canSum = new CanSum();
        System.out.println(canSum.canSum(7, new int[] { 2, 3 }, new HashMap<>()));
        System.out.println(canSum.canSum(7, new int[] { 5, 3, 4, 7 }, new HashMap<>()));
        System.out.println(canSum.canSum(7, new int[] { 2, 4 }, new HashMap<>()));
        System.out.println(canSum.canSum(8, new int[] { 2, 3, 5 }, new HashMap<>()));
        System.out.println(canSum.canSum(300, new int[] { 7, 14 }, new HashMap<>()));

    }

}
