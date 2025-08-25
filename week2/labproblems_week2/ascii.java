package labproblems_week2;
import java.util.Scanner;

public class ascii {
    public static char toUpperCase(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char)(ch - 32);
        }
        return ch;
    }

    public static char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char)(ch + 32);
        }
        return ch;
    }

    public static String convertToUpper(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            sb.append(toUpperCase(ch));
        }
        return sb.toString();
    }

    public static String convertToLower(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            sb.append(toLowerCase(ch));
        }
        return sb.toString();
    }

    public static String convertToTitleCase(String str) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (char ch : str.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                sb.append(ch);
                newWord = true;
            } else if (newWord) {
                sb.append(toUpperCase(ch));
                newWord = false;
            } else {
                sb.append(toLowerCase(ch));
            }
        }
        return sb.toString();
    }

    public static void compareWithBuiltIn(String str) {
        System.out.printf("%-20s %-20s %-20s\n", "Conversion", "ASCII Method", "Built-in Method");
        System.out.printf("%-20s %-20s %-20s\n", "Uppercase", convertToUpper(str), str.toUpperCase());
        System.out.printf("%-20s %-20s %-20s\n", "Lowercase", convertToLower(str), str.toLowerCase());
        System.out.printf("%-20s %-20s %-20s\n", "Title Case", convertToTitleCase(str), toTitleCaseBuiltIn(str));
    }

    private static String toTitleCaseBuiltIn(String str) {
        String[] words = str.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                sb.append(Character.toUpperCase(words[i].charAt(0)));
                if (words[i].length() > 1) {
                    sb.append(words[i].substring(1).toLowerCase());
                }
            }
            if (i < words.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println();
        compareWithBuiltIn(input);
        sc.close();
    }
}
