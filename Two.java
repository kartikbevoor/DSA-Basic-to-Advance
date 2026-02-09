import java.util.Scanner;

public class Two {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        System.out.println(isLeapyear(year));

        sc.close();
    }

    public static boolean isLeapyear(int year){  // check for leap year
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0 )) {
            return true;
        }

        return false;
    }

    public static void swap(int a, int b){   // swap two nums
        // int temp = a;
        // a = b;
        // b = temp;
        
        // or

        a = a + b;
        b = a - b;
        a = a - b;
    }

    public static int factorial(int n){     // factorial using for loop
        if (n <= 0) {
            return -1;
        }
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * 1;
        }

        return fact;
    }

    public static int factorial2(int n){     // factorial using recursion
        if (n <= 0) {
            return -1;
        }

        if (n == 1) {
            return 1;
        }

        return n * (factorial2(n - 1));
    }

    public static void fibonacciSeries(int n){    // fibonacci series using while loop
        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);

        int count = 2;

        while (count != n) {
            int c = a + b;
            System.out.println(c);
            a = b;
            b = c;
            count++;
        }
    }

    public static void fibonacciSeries2(int a, int b, int count, int n) { // // fibonacci series using while recursion
        if (count >= n) {
            return; 
        }

        int c = a + b;
        System.out.println(c);

        fibonacciSeries2(b, c, count + 1, n);
    }

    public static int reverseNum(int n){   // reverse a number
        int reverse = 0;
        while (n > 0) {
            int temp = n % 10;
            reverse = reverse * 10 + temp;
            n = n / 10;
        }

        return reverse;
    }

    public static boolean isPallindrome(int n){   // check for pallindrome
        int temp1 = n;

        int reverse = 0;
        while (n > 0) {
            int temp = n % 10;
            reverse = reverse * 10 + temp;
            n = n / 10;
        }

        return (reverse == temp1) ? true : false;
    }

}
