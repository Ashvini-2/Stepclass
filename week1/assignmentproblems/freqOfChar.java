import java.util.Scanner;


public class freqOfChar {
   // Method to find unique characters in a string
   public static char[] uniqueCharacters(String text) {
       StringBuilder unique = new StringBuilder();
       for (int i = 0; i < text.length(); i++) {
           char ch = text.charAt(i);
           boolean isUnique = true;
           for (int j = 0; j < unique.length(); j++) {
               if (unique.charAt(j) == ch) {
                   isUnique = false;
                   break;
               }
           }
           if (isUnique) {
               unique.append(ch);
           }
       }
       char[] uniqueArr = new char[unique.length()];
       for (int i = 0; i < unique.length(); i++) {
           uniqueArr[i] = unique.charAt(i);
       }
       return uniqueArr;
   }


   // Method to find frequency of characters and return as 2D array
   public static String[][] characterFrequencies(String text) {
       int[] freq = new int[256]; // ASCII size
       for (int i = 0; i < text.length(); i++) {
           freq[text.charAt(i)]++;
       }
       char[] uniqueChars = uniqueCharacters(text);
       String[][] result = new String[uniqueChars.length][2];
       for (int i = 0; i < uniqueChars.length; i++) {
           result[i][0] = String.valueOf(uniqueChars[i]);
           result[i][1] = String.valueOf(freq[uniqueChars[i]]);
       }
       return result;
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a string: ");
       String input = sc.nextLine();


       String[][] frequencies = characterFrequencies(input);


       System.out.println("Character\tFrequency");
       for (String[] pair : frequencies) {
           System.out.println(pair[0] + "\t\t" + pair[1]);
       }
       sc.close();
   }
}

