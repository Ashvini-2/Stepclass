package labproblems_week2;
import java.util.Scanner;
public class textformatter {
    public static String[] splitWords(String text) {
        int n = text.length();
        String[] temp = new String[n]; // max possible words
        int count = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == ' ') {
                if (start < i) {
                    temp[count++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }
        if (start < n) {
            temp[count++] = text.substring(start, n);
        }
        String[] words = new String[count];
        System.arraycopy(temp, 0, words, 0, count);
        return words;
    }

    public static String justifyTextSB(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLen + 1 + words[j].length() <= width) {
                lineLen += 1 + words[j].length();
                j++;
            }
            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) line.append(' ');
                }
                for (int k = line.length(); k < width; k++) line.append(' ');
            } else {
                int totalSpaces = width - (lineLen - gaps);
                int space = totalSpaces / gaps;
                int extra = totalSpaces % gaps;
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) {
                        for (int s = 0; s < space; s++) line.append(' ');
                        if (extra-- > 0) line.append(' ');
                    }
                }
            }
            result.append(line).append('\n');
            i = j;
        }
        return result.toString();
    }

    public static String centerAlignText(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLen + 1 + words[j].length() <= width) {
                lineLen += 1 + words[j].length();
                j++;
            }
            StringBuilder line = new StringBuilder();
            for (int k = i; k < j; k++) {
                line.append(words[k]);
                if (k != j - 1) line.append(' ');
            }
            int pad = (width - line.length()) / 2;
            StringBuilder centered = new StringBuilder();
            for (int p = 0; p < pad; p++) centered.append(' ');
            centered.append(line);
            while (centered.length() < width) centered.append(' ');
            result.append(centered).append('\n');
            i = j;
        }
        return result.toString();
    }

    public static String justifyTextConcat(String[] words, int width) {
        String result = "";
        int i = 0;
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLen + 1 + words[j].length() <= width) {
                lineLen += 1 + words[j].length();
                j++;
            }
            int gaps = j - i - 1;
            String line = "";
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line += words[k];
                    if (k != j - 1) line += " ";
                }
                while (line.length() < width) line += " ";
            } else {
                int totalSpaces = width - (lineLen - gaps);
                int space = totalSpaces / gaps;
                int extra = totalSpaces % gaps;
                for (int k = i; k < j; k++) {
                    line += words[k];
                    if (k != j - 1) {
                        for (int s = 0; s < space; s++) line += " ";
                        if (extra-- > 0) line += " ";
                    }
                }
            }
            result += line + "\n";
            i = j;
        }
        return result;
    }

    public static void displayFormattedText(String formatted, String title) {
        System.out.println(title);
        String[] lines = formatted.split("\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.printf("%2d: %-"+lines[i].length()+"s (%d chars)\n", i+1, lines[i], lines[i].length());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to format:");
        String text = sc.nextLine();
        System.out.println("Enter desired line width:");
        int width = sc.nextInt();
        sc.nextLine();

        String[] words = splitWords(text);

        long startSB = System.nanoTime();
        String justifiedSB = justifyTextSB(words, width);
        long endSB = System.nanoTime();

        long startConcat = System.nanoTime();
        String justifiedConcat = justifyTextConcat(words, width);
        long endConcat = System.nanoTime();

        String centered = centerAlignText(words, width);

        System.out.println("\nOriginal Text:\n" + text + "\n");
        displayFormattedText(justifiedSB, "Left-Justified Text (StringBuilder):");
        displayFormattedText(centered, "Center-Aligned Text:");
        System.out.println("Performance Analysis:");
        System.out.printf("StringBuilder Justification: %d ns\n", (endSB - startSB));
        System.out.printf("String Concatenation Justification: %d ns\n", (endConcat - startConcat));
    }
}
