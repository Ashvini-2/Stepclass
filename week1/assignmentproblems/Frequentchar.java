import java.util.Scanner;


public class Frequentchar {

   // Method to find frequency of characters using charAt()
   public static int[][] findCharFrequencies(String text) {
       int[] freq = new int[256]; // For all ASCII characters


       // Count frequencies
       for (int i = 0; i < text.length(); i++) {
           freq[text.charAt(i)]++;
       }


       // Count unique characters
       int uniqueCount = 0;
       for (int i = 0; i < 256; i++) {
           if (freq[i] > 0) uniqueCount++;
       }


       // Prepare result array
       int[][] result = new int[uniqueCount][2];
       int idx = 0;
       for (int i = 0; i < 256; i++) {
           if (freq[i] > 0) {
               result[idx][0] = i;        // ASCII value of character
               result[idx][1] = freq[i];  // Frequency
               idx++;
           }
       }
       return result;
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a string: ");
       String input = sc.nextLine();


       int[][] frequencies = findCharFrequencies(input);


       System.out.println("Character frequencies:");
       for (int i = 0; i < frequencies.length; i++) {
           char ch = (char) frequencies[i][0];
           int count = frequencies[i][1];
           System.out.println("'" + ch + "' : " + count);
       }
       sc.close();
   }
}


