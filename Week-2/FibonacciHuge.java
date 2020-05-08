import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    /**
     * Function to calculate the length of the repeating sequence
     * This is called Pisano Period
     */
    private static long getPisano(long m) {

        long prev=0;
        long current=1;
        long num=0;

        int i=0;

        // A property of pisano is that it can at most be equal to m squared.
        for(; i<= m*m; ++i) {
            // find the current number % m
            num=(prev+current) % m;
            // for the next iteration prev is current
            prev=current;
            // current is the new calculated value
            current=num;
            
            // This sequence always begins from 0 1.
            // Since it is periodic, the next repeating sequence will begin from 0 1
            // Hence, if 0 1 is encountered, stop the loop.
            if(prev==0 && current==1) {
                break;
            }
        }

        // 1 is added for correct count after looping
        return i+1;
    }

    private static long calc_fib(long n, long m) {

        // edge cases
        if(n==0)
            return 0;
        if(n==1)
            return 1;
    
        // Fn=Fn-1 + Fn-2.
        // a and b are previous two numbers
        // c is the current number
        long a=0;
        long b=1;
        long c=0;

        for(long i=2; i<=n; i++) {
            // calculate the mod sequence
            c=(a+b) % m;
            a=b;
            b=c;
        }
    
        return c;
      }

    private static long getFibonacciHugePisano(long n, long m) {

        /**
         * To find Fn mod m
         * We know that this sequence is periodic.
         * Hence we find the length of the sequence for m.
         * Example: n=10, m=2
         */

        // length for m=2 -> 3 -> Repeating sequence is 011 011 011
        long length=getPisano(m);

        /**
         * Now if we divide n by the length we get the first fibonacci number where this sequence ends.
         * Fn is a sequence of n numbers. So n/length gives number of sequences
         * The remainder gives the first sequence -> we call this Fn2.
         * Essentially, Fn mod m = Fn2 mod m -> repeating sequence
         */
        long n2= n % length;

        /**
         * Instead of going up to n, we find the sequence only up to n2.
         */
        // write fibo func to find n2 fibonacci number
        long fib_n2=calc_fib(n2, m);

        // take its mod as Fn mod m = Fn2 mod m
        long res=fib_n2 % m;

        return res;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugePisano(n, m));
        scanner.close();
    }
}

