import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumLastDigit(long n) {

        if(n<=1)
            return n;

        long a=0;
        long b=1;
        long c=0;
        long sumLastDigit=1;

        for(int i=2; i<=n; i++) {
            c=(a+b) % 10;
            sumLastDigit = (sumLastDigit + c) % 10;
            a=b;
            b=c;
        }

        return sumLastDigit;
    }

    private static long getFibonacciLastDigitPisano(long n) {
        int pisano_period=60;

        long nEarly = n % pisano_period;

        return getFibonacciSumLastDigit(nEarly);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        // System.out.println(getFibonacciSumNaive(n));
        // System.out.println(getFibonacciSumLastDigit(n));
        System.out.println(getFibonacciLastDigitPisano(n));
        scanner.close();
    }
}

