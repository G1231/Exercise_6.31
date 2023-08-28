import java.util.Scanner;

class credit {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a credit card number: ");
    long number = input.nextLong();
    if (isValid(number)) {
      System.out.print(number + " is valid");
    }
    else if (isValid(number)){
      System.out.print(number + "is not valid");
    }
}


    
/** Return true if the card number is valid */
  public static boolean isValid(long number){
    boolean t = (getSize(number) >= 13 && getSize(number) <= 16) &&
			(prefixMatched(number, 4) || prefixMatched(number, 5) ||
			prefixMatched(number, 37) || prefixMatched(number, 6)) &&
			((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
      return t;
    }

  /** Get the result from Step 2 */
  public static int sumOfDoubleEvenPlace(long number){
    int sum = 0;
    number/=10;
    int a;
    while (number !=0) {
      int endnum = (int) (number %10);
      endnum *= 2;
      a = getDigit(num);
      sum += a;
      number /= 100;
    }
    return sum;
  }

  /** Return this number if it is a single digit, otherwise,
   * return the sum of the two digits */
  public static int getDigit(int number) {
    return (number<9)? number: number/10 + number%10;
  }

  /** Return sum of odd-place digits in number */
  public static int sumOfOddPlace(long number) {
    int sum = 0;
    while (number !=0){
      int endnum = (int) (number%10);
      sum += endnum;
      number /= 100;
    }
    return sum;
  }

  /** Return true if the number d is a prefix for number */
  public static boolean prefixMatched(long number, int d){
    return getPrefix(number, getSize(d)) == d;
  }

  /** Return the number of digits in d */
  public static int getSize(long number) {
    int digit = 0;
    while (number != 0) {
    number /= 10;
    digit++; }
  return digit;
  }

  /** Return the first k number of digits from number. If the
   * number of digits in number is less than k, return number. */
  public static long getPrefix(long number, int k){
    if (getSize(number) < k) {
      return number;
    } 
    else {
      while (getSize(number) > k) {
        number /= 10;
        }
      return number;
   }
  }
}