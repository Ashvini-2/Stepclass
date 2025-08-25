import java.util.*;
public class length {
        public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("CAUGHT AN0 EXCEPTION " + e);
       
        }
        return count;
    }


    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter a string:");
        String str = sc.nextLine();
        int l = getStringLength(str); // Use custom method
        System.out.println("Length of string: " + l);
        sc.close();
    }
    }
