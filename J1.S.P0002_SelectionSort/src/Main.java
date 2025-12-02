/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tuan Tran
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Step 1: Prompt user to enter the number of elements in the array
        int numberOfArray = getInt("Enter number of array:", "Please enter integer number > 0",
                "Please enter integer number", 1, Integer.MAX_VALUE);

        // Step 2: Generate an array with random integers
//        int[] unsortedArray = generateRandomArray(numberOfArray);
        // test interface
        //int[] unsortedArray = {2, 6, 3, 6, 8, 6, 1, 2, 9, 8};
        //Test altholigim
        int[] unsortedArray = {5, 1, 12, -5, 16, 2, 12, 14};

        // Step 3: Dispay the unsorted array
        System.out.print("Unsorted array: ");
        displayArray(unsortedArray);

        // Step 4: Sort the array using bubble sort
        //selectionSort(unsortedArray);
        selectionSortTest(unsortedArray);

        // Step 5: Display the sorted array
        System.out.print("Sorted array: ");
        displayArray(unsortedArray);
    }

    public static int getInt(String mssInfo, String mssErrRange,
            String mssErrDataTye, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //Loop until input valid number
        int number;
        do {
            try {
                System.out.println(mssInfo);
                String line = sc.nextLine();
                //Check number is empty
                if (line.trim().isEmpty()) {
                    System.out.println("Can not empty!");
                } else {
                    number = Integer.parseInt(line);
                    //Check number is in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println(mssErrRange);
                    }
                }
                //Invalid format integer
            } catch (NumberFormatException e) {
                System.out.println(mssErrDataTye);
            }
        } while (true);
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        //Loop throught each element in array
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        // Iterates through each element of the array.
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            //Finds the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                // If a smaller element is found, update its index
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swaps the found minimum element with the first element of the unsorted part.
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void selectionSortTest(int[] array) {
        int n = array.length;
        System.out.printf("%-25s | %s%n", "Sorted Part", "Unsorted Part");
        System.out.println("--------------------------|----------------------------------------");
        // Iterates through each element of the array.
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            //Finds the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                // If a smaller element is found, update its index
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Get the subarrays representing the sorted and unsorted parts
            String sortedPart = Arrays.toString(Arrays.copyOfRange(array, 0, i));
            String unsortedPart = Arrays.toString(Arrays.copyOfRange(array, i, n));

            // Print the current state of the array before the swap
            System.out.printf("%-25s | %s%n", sortedPart, unsortedPart);

            // Swap the found minimum element with the first element of the unsorted part
            if (minIndex != i) {
                System.out.println("   -> Unsorted Part: Min element: " + array[minIndex] + ", First element: " + array[i] + " -> Swap");
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            } else {
                System.out.println("   -> The element is already in place. No swap needed.");
            }
            System.out.println();
        }
    }

    public static void displayArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
