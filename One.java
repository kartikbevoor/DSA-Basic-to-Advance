import java.util.Scanner;

public class One{   // In java the file name and the name of the class, which contains main function has to be same
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a + b);

        sc.close();
    }

    public static void checkEvenOrOdd(int num){ // find the given number even or odd
        if (num % 2 == 0) {
            System.out.println("Even");
        }
        else{
            System.out.println("Odd");
        }

        // OR

        System.out.println(num % 2 == 0 ? "Even" : "Odd");
    }

    public static int largestOfTwoNums(int a, int b){  // find largest of two nums
        if (a == b) {
            return -1;
        }

        return a > b ? a : b;
        // return Math.max(a, b);
    }

    public static int largestOfThreeNums(int a, int b, int c){  // find largest of three nums
        int max = a;
        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
        // return Math.max(a, Math.max(b, c)); // using Math.max(a, b) function
    }

    public static void checkPositiveOrNegative(int n){  // check for positive or negative
        if (n == 0) {
            System.out.println("Zero");
        }
        System.out.println(n > 0 ? "Positive" : "Negative");
    }
}