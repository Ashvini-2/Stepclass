import java.util.Scanner;


public class uniquechar {


   // Method to find the length of the text without using String.length()
   public static int getLength(String text) {
       int count = 0;
       try {
           while (true) {
               text.charAt(count);
               count++;
           }
       } catch (IndexOutOfBoundsException e) {
           // End of string reached
       }
       return count;
   }


   // Method to find unique characters in a string using charAt()
   public static char[] findUniqueChars(String text) {
       int len = getLength(text);
       char[] uniqueTemp = new char[len];
       int uniqueCount = 0;


       for (int i = 0; i < len; i++) {
           char current = text.charAt(i);
           boolean isUnique = true;
           for (int j = 0; j < i; j++) {
               if (text.charAt(j) == current) {
                   isUnique = false;
                   break;
               }
           }
           if (isUnique) {
               uniqueTemp[uniqueCount++] = current;
           }
       }


       // Create a new array with the exact size of unique characters
       char[] uniqueChars = new char[uniqueCount];
       for (int i = 0; i < uniqueCount; i++) {
           uniqueChars[i] = uniqueTemp[i];
       }
       return uniqueChars;
   }


   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter a string: ");
       String input = scanner.nextLine();


       int length = getLength(input);
       System.out.println("Length of the string: " + length);


       char[] uniqueChars = findUniqueChars(input);
       System.out.print("Unique characters: ");
       for (char c : uniqueChars) {
           System.out.print(c + " ");
       }
       System.out.println();
       scanner.close();
   }
}

