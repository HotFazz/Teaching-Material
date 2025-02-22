/**
 * Implementation of the QuickSort algorithm.
 */
public class QuickSort {
    /**
     * Sorts an array using the quicksort algorithm.
     * Time Complexity: O(n log n) average, O(n²) worst
     * Space Complexity: O(log n)
     * @param arr the array to be sorted
     * @param low the starting index
     * @param high the ending index
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Helper method for quickSort to partition the array.
     * @param arr array to be partitioned
     * @param low starting index
     * @param high ending index
     * @return the partition index
     */
    private int partition(int[] arr, int low, int high) {
        // Using the rightmost element as pivot
        int pivot = arr[high];
        
        // Index of smaller element
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // Place pivot in its correct position
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Helper method to swap two elements in an array.
     * @param arr array containing elements
     * @param i first element index
     * @param j second element index
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Main method to test the quicksort implementation.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Original array:");
        printArray(arr);

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    /**
     * Utility method to print an array.
     * @param arr array to print
     */
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
