import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib_recursive(int n) {
    if (n <= 1)
      return n;

    return calc_fib_recursive(n - 1) + calc_fib_recursive(n - 2);
  }

  private static long calc_fib(int n) {

    // edge cases
    if(n==0)
      return 0;
    
    if(n==1)
      return 1;

    // array to store the fibonacci series
    long[] fib_nums = new long[n+1];

    fib_nums[0] = 0;
    fib_nums[1] = 1;

    // iterate upto n
    for(int i=2; i<=n; i++) {
        // current element = sum of previous two elements
        fib_nums[i] = fib_nums[i-1] + fib_nums[i-2];
    }

    return fib_nums[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    // iterative is much more efficient than recursive
    // in recursive we calculate the same thing over and over again
    // F(4) calculates F(1) to F(3), F(5) calculates them again
    System.out.println(calc_fib(n));
    // System.out.println(calc_fib_recursive(n));
    in.close();
  }
}
