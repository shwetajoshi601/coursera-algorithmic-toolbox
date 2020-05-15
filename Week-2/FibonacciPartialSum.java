import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    private static int getFibonacciPartialSum(long from, long to) {
        
        // sum of last digits is a periodic sequence
        // hence take pisano period of mod 10 -> 60.
        // recalculate the smaller from and two values
        from=from%60;
        to=to%60;

        // to may become less than from due to mod operation
        // hence, add 60 - sequence length to it
        if(to < from)
            to+=60;
        
        // edge case - both zero, no need to calculate anything, sum is 0.
        if(from==0 && to==0)
            return 0;
        
        // for inputs of from < 1 sum initialisation is 1.
        // e.g.: from=1, to=2. sum=2, if sum is kept 0, in the looping, the sum is calculated as 1 since we loop only upto "to"
        int sumLastDigit=from <=1 ? 1 : 0;

        // to calculate fibonacci
        int a=0, b=1, c=0;

        for(long i=2; i<=to; i++) {
            // only keep track of last digits of the sum
            c=(a+b) % 10;
            // partial sum beginning
            if(i >= from)
                // keep track of the last digit of the sum
                sumLastDigit=(sumLastDigit + c) % 10;
            a=b;
            b=c;
        }

        return sumLastDigit;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        // System.out.println(getFibonacciPartialSumNaive(from, to));
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

