package src.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    long fib(int n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2) return 1;

        long value = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, value);

        return memo.get(n);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(3, new HashMap<>()));
        System.out.println(fibonacci.fib(5, new HashMap<>()));
        System.out.println(fibonacci.fib(50, new HashMap<>()));
    }
}
