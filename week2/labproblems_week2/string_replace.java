
package labproblems_week2;
import java.util.*;

public class string_replace {
    public static ArrayList<Integer> findOccurrences(String text, String find) {
        ArrayList<Integer> positions = new ArrayList<>();
        int index = 0;
        while ((index = text.indexOf(find, index)) != -1) {
            positions.add(index);
            index += find.length();
        }
        return positions;
    }

    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i <= text.length() - find.length()) {
            if (text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        // Append any remaining characters
        result.append(text.substring(i));
        return result.toString();
    }

    public static boolean compareWithBuiltIn(String manual, String text, String find, String replace) {
        String builtIn = text.replace(find, replace);
        return manual.equals(builtIn);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main text:");
        String text = sc.nextLine();
        System.out.println("Enter the substring to find:");
        String find = sc.nextLine();
        System.out.println("Enter the substring to replace with:");
        String replace = sc.nextLine();

        ArrayList<Integer> positions = findOccurrences(text, find);
        System.out.println("Occurrences at positions: " + positions);

        String manualResult = manualReplace(text, find, replace);
        System.out.println("Manual replace result: " + manualResult);

        String builtInResult = text.replace(find, replace);
        System.out.println("Built-in replace() result: " + builtInResult);

        boolean isSame = compareWithBuiltIn(manualResult, text, find, replace);
        System.out.println("Manual result matches built-in: " + isSame);
    }
}
