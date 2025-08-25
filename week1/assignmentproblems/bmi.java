import java.util.Scanner;


public class bmi {
   // Method to calculate BMI and status for each person
   public static String[][] calculateBMI(double[][] data) {
       String[][] result = new String[data.length][4];
       for (int i = 0; i < data.length; i++) {
           double weight = data[i][0];
           double heightCm = data[i][1];
           double heightM = heightCm / 100.0;
           double bmi = weight / (heightM * heightM);
           String status;
           if (bmi < 18.5) {
               status = "Underweight";
           } else if (bmi < 25) {
               status = "Normal";
           } else if (bmi < 30) {
               status = "Overweight";
           } else {
               status = "Obese";
           }
           result[i][0] = String.format("%.2f", heightCm);
           result[i][1] = String.format("%.2f", weight);
           result[i][2] = String.format("%.2f", bmi);
           result[i][3] = status;
       }
       return result;
   }


   // Method to process the input data and return the result array
   public static String[][] processBMI(double[][] data) {
       return calculateBMI(data);
   }


   // Method to display the result in tabular format
   public static void displayResult(String[][] result) {
       System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
       for (String[] row : result) {
           System.out.printf("%-10s %-10s %-10s %-15s%n", row[0], row[1], row[2], row[3]);
       }
   }


   // Main method
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       double[][] data = new double[10][2];
       for (int i = 0; i < 10; i++) {
           System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
           data[i][0] = sc.nextDouble();
           System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
           data[i][1] = sc.nextDouble();
       }
       String[][] result = processBMI(data);
       System.out.println("\nBMI Results:");
       displayResult(result);
       sc.close();
   }
}

