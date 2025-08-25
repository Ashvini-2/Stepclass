package labproblems_week2;
import java.util.Scanner;

public class stringtypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String performance comparison
        System.out.print("Enter number of iterations for string operations: ");
        int iterations = sc.nextInt();
        sc.nextLine();

        PerformanceResult stringResult = testStringConcat(iterations);
        PerformanceResult builderResult = testStringBuilder(iterations);
        PerformanceResult bufferResult = testStringBuffer(iterations);

        System.out.println("\nPerformance Comparison:");
        System.out.printf("%-15s %-20s %-20s\n", "Method", "Time (ms)", "Final Length");
        System.out.printf("%-15s %-20d %-20d\n", "String", stringResult.timeTaken, stringResult.length);
        System.out.printf("%-15s %-20d %-20d\n", "StringBuilder", builderResult.timeTaken, builderResult.length);
        System.out.printf("%-15s %-20d %-20d\n", "StringBuffer", bufferResult.timeTaken, bufferResult.length);

        // Caesar Cipher
        System.out.print("\nEnter text to encrypt: ");
        String text = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        System.out.println("\nOriginal Text & ASCII:");
        displayAscii(text);

        String encrypted = encryptCaesar(text, shift);
        System.out.println("\nEncrypted Text & ASCII:");
        displayAscii(encrypted);

        String decrypted = decryptCaesar(encrypted, shift);
        System.out.println("\nDecrypted Text & ASCII:");
        displayAscii(decrypted);

        System.out.println("\nDecryption " + (text.equals(decrypted) ? "successful!" : "failed!"));
        sc.close();
    }

    static class PerformanceResult {
        long timeTaken;
        int length;
        PerformanceResult(long timeTaken, int length) {
            this.timeTaken = timeTaken;
            this.length = length;
        }
    }

    static PerformanceResult testStringConcat(int n) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + "a";
        }
        long end = System.currentTimeMillis();
        return new PerformanceResult(end - start, s.length());
    }

    static PerformanceResult testStringBuilder(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        return new PerformanceResult(end - start, sb.length());
    }

    static PerformanceResult testStringBuffer(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        return new PerformanceResult(end - start, sb.length());
    }

    static String encryptCaesar(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                char ch = (char) (((c - 'A' + shift) % 26 + 26) % 26 + 'A');
                result.append(ch);
            } else if (c >= 'a' && c <= 'z') {
                char ch = (char) (((c - 'a' + shift) % 26 + 26) % 26 + 'a');
                result.append(ch);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    static String decryptCaesar(String text, int shift) {
        return encryptCaesar(text, -shift);
    }

    static void displayAscii(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c + "(" + (int)c + ") ");
        }
        System.out.println();
    }
    
}
