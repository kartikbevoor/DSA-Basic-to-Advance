import java.util.Scanner;

public class Two {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        System.out.println(isLeapyear(year));

        sc.close();
    }

    // a leap year is the year which is either divisible by 400 or it is divisible by 4 and not by 100
    public static boolean isLeapyear(int year){  // check for leap year
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0 )) {
            return true;
        }

        return false;
    }

    public static void swap(int a, int b){   // swap two nums
        // int temp = a;    // using temporery variable 
        // a = b;
        // b = temp;
        
        a = a + b;  // or without using third variable
        b = a - b;
        a = a - b;
    }

    public static int factorial(int n){     // factorial using for loop
        if (n <= 0) {
            return -1;
        }

        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
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

    public static boolean isPallindrome2(int n){
        // convert number to char array
        // char[] charArray = String.valueOf(number).toCharArray();
        // char[] charArray = String.valueOf(number).toCharArray(); // this is for double or float
        char[] charArray = Integer.toString(n).toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] == charArray[right]) {
                left++;
                right--;
            }else{
                return false;
            }
        }
    
        return true;
    }

    // Converting a number to string
    // String str = String.valueOf(number);
    // String str = Integer.toString(number);
    // String str = Double.toString(d);

}
