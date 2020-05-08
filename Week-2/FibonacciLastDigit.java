import java.util.*;

public class FibonacciLastDigit {
    // Naive solution: calculate the Nth Fibonacci number and then take mod
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    // Store only the last digits of every fibonacci number
    // summing last digits of previous two numbers will give current last digit
    // less space and faster computation on digits
    private static int getFibonacciLastDigit(int n) {

        // edge cases
        if(n==0)
            return 0;
        
        if(n==1)
            return 1;
        
        int[] fib_nums = new int[n+1];
    
        fib_nums[0] = 0;
        fib_nums[1] = 1;
    
        for(int i=2; i<=n; i++) {
            // storing last digits
            fib_nums[i] = (fib_nums[i-1] + fib_nums[i-2]) % 10;
        }
    
        return fib_nums[n];
      }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // System.out.println(getFibonacciLastDigitNaive(n));
        System.out.println(getFibonacciLastDigit(n));
    }
}

