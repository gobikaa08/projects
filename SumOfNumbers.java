
}    // Program Title: Sum of Numbers from 1 to 100
// Aim: To calculate the sum of all numbers from 1 to 100
package mynewproject;

public class SumOfNumbers {
    public static void main(String[] args) {
        int sum = 0;

        // Loop from 1 to 100
        for (int i = 50; i <= 100; i++) {
            sum += i;
        }
                                                                               
        // Print the result
        System.out.println("Sum of numbers from 1 to 100 is: " + sum);

        // --- Extra Test Cases ---
        System.out.println("Sum from 1 to 50 is: " + calculateSum(1, 50));
        System.out.println("Sum from 1 to 10 is: " + calculateSum(1, 10));
        System.out.println("Sum from 50 to 100 is: " + calculateSum(50, 100));
        System.out.println("Sum from 1 to 1 is: " + calculateSum(1, 1));
    }

    // Method to calculate sum between two numbers (inclusive)
    public static int calculateSum(int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) {
            total += i;
        }
        return total;
    }                  