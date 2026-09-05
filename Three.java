public class Three {
    public static void main(String[] args) {
        
    }

    public static boolean isArmstrong(int n){
        int temp = n;
        int armstrongNumber = 0;
        int reminder;

        while (n > 0) {
            reminder = n % 10;
            armstrongNumber = armstrongNumber + (reminder * reminder * reminder); // Math.pow(remainder, 3)
            n = n / 10;
        }

        if (temp == armstrongNumber) {
            return true;
        }

        return false;
    }

    public static boolean isPrime(int n){   // check for prime nums
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime2(int n){   // check for prime nums bit optimised compared to above
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void tableOfNum(int n){   // printing the table of a num
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
        }
    }

    public static int sumOfDigits(int n){
        int sum = 0;
        int reminder;

        while (n > 0) {
            reminder = n % 10;
            sum = sum + reminder;
            n = n / 10;
        }

        return sum;
    }

    public static void numPattern(int n){   // Printing num pattern(1, 12, 123)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void alphabetPattern(int n){   // printing alphabets pattern (a, ab, abc)
        for (int i = 1; i <= n; i++) {
            for (char c = 'A'; c < 'A' + i; c++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
