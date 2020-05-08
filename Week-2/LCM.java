import java.util.*;

public class LCM {
  
  private static long lcm_naive(int a, int b) {
    // Iterate through numbers upto the product of a and b
    for (long l = 1; l <= (long) a * b; ++l)
    // check if it is divisible by both the numbers
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  /*
    Find LCM using the property: GCD * LCM = a * b
  */
  private static int euclid_gcd(int a, int b) {
    // find GCD using Euclidean method
    if(a > b && b == 0)
      return a;

    if(a > b)
      return euclid_gcd(b, a%b);
    else
      return euclid_gcd(a, b%a);
  }

  private static long lcm_efficient(int a, int b) {

    // if any number is 0, the LCM is 0
    if(a==0 || b==0)
      return 0;

    // find product
    long product=(long)a*b;

    // LCM: product/GCD
    int gcd=euclid_gcd(a, b);
    long lcm=product/gcd;

    return lcm;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    // System.out.println(lcm_naive(a, b));
    System.out.println(lcm_efficient(a, b));
  }
}
