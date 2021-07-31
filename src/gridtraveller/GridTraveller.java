package src.gridtraveller;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    long travel(int m, int n, Map<String, Long> memo) {
        String key = m + "," + n;

        if (memo.containsKey(key)) return memo.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;

        long value = travel(m - 1, n, memo) + travel(m, n - 1, memo);
        memo.put(key, value);

        return value;
    }

    public static void main(String[] args) {
        GridTraveller gridTraveller = new GridTraveller();
        System.out.println(gridTraveller.travel(3, 3, new HashMap<>()));
        System.out.println(gridTraveller.travel(5, 5, new HashMap<>()));
        System.out.println(gridTraveller.travel(60, 60, new HashMap<>()));
    }

}
