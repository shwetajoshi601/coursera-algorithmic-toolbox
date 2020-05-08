import java.util.*;

public class GCD {

  /**
   * Naive algorithm:
   * For each number upto a and b -> check if it divides a and b completely
   * find the max number that divides
   */
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  /**
   * Efficient algorithm: Euclidean method
   * Calculates using a property GCD(a, b)=GCD(a`, b)
   * where a` = a%b
   */
  private static int euclid_gcd(int a, int b) {
    // stop when the greater number is reduced to 0
    if(a > b && b == 0)
      return a;

    // divide greater number by the smaller one and take its remainder
    if(a > b)
      // find the gcd of (small no., remainder)
      return euclid_gcd(b, a%b);
    else
      return euclid_gcd(a, b%a);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    // System.out.println(gcd_naive(a, b));
    System.out.println(euclid_gcd(a, b));
  }
}
