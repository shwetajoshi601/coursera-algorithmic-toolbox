import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    private static int getPisano(long n) {
        long a=0, b=1, c=0;

        int i=2;
        for(; i<=n; i++) {
            long fib = a+b;
            c=(fib*fib) % 10;

            a=b;
            b=c;

            if(b==0 && c==1)
                break;
        }

        return i;
    }

    // Efficient function to get sum of squares of fibonacci numbers
    private static int getFibonacciSumSquares(long n) {
        
        // since only the last digit is considered, we always do Fn % 10. 
        // Fn mod m is a periodic sequence. Hence, the pisano period is used.
        // Pisano period for mod 10 is 60. Hence we reduce n by taking n % 60
        n = n % 60;

        // edge cases
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        int a=0, b=1, c=0;
        // we use the formula for sum of squares of fibonacci numbers: Fn*(Fn-1 + Fn)
        // prev represents Fn-1
        int prev= n<=2 ? 1 : 0;

        // find the last digit of fibonacci numbers upto n
        for(long i=2; i<=n; i++) {
            // the last digit of square will be the same as the last digit of the number itself.
            c=(a+b) % 10;
            // to get Fn-1
            if(i==n-1)
                prev=c;
            a=b;
            b=c;
        }
        
        // we apply the formula only on the last digits -> last digit of an addition and multiplication will be the operation performed on the last digits
        // Here, c=Fn, prev=Fn-1 -> % 10 to take last digits after addition and multiplication
        return (c*((prev+c)%10)) % 10;

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        // long s = getFibonacciSumSquaresNaive(n);
        // System.out.println(s);
        System.out.print(getFibonacciSumSquares(n));
        scanner.close();
    }
}

