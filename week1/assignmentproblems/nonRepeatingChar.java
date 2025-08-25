import java.util.Scanner;


public class nonRepeatingChar {
   // Method to find the first non-repeating character in a string
   public static char firstNonRepeatingChar(String text) {
       int[] freq = new int[256]; 

       // Count frequency of each character
       for (int i = 0; i < text.length(); i++) {
           freq[text.charAt(i)]++;
       }


       // Find the first character with frequency 1
       for (int i = 0; i < text.length(); i++) {
           if (freq[text.charAt(i)] == 1) {
               return text.charAt(i);
           }
       }


       return '\0'; 
    }


   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter a string: ");
       String input = scanner.nextLine();


       char result = firstNonRepeatingChar(input);


       if (result != '\0') {
           System.out.println("First non-repeating character: " + result);
       } else {
           System.out.println("No non-repeating character found.");
       }
       scanner.close();
   }

}