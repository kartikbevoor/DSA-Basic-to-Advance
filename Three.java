public class Three {
    public static void main(String[] args) {
        
    }

    public static boolean isPrime(int n){   // check for prime nums
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime2(int n){   // check for prime nums
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
            for (char c = 'A'; c < 'A' + 1; c++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
