package mynewproject;

import java.util.Arrays;

public class GenericSorter{

    // Generic method to sort any array of Comparable types
    public static <T extends Comparable<T>> void sortArray(T[] array) {
        Arrays.sort(array);   // uses natural ordering
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        // Sorting Integer array
        Integer[] intArray = {5, 2, 9, 1, 3};
        System.out.println("Original Integer Array: " + Arrays.toString(intArray));
        sortArray(intArray);

        // Sorting String array
        String[] strArray = {"Banana", "Apple", "Mango", "Cherry"};
        System.out.println("Original String Array: " + Arrays.toString(strArray));
        sortArray(strArray);
    }
}