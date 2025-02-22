/**
 * Implementation of the Heap Sort algorithm.
 */
public class HeapSort {
    /**
     * Sorts an array using the heap sort algorithm.
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * @param arr the array to be sorted
     */
    public void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
            
        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * Helper method to maintain heap property.
     * @param arr array to heapify
     * @param n size of heap
     * @param i root index
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    /**
     * Main method to test the heap sort implementation.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(arr);

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);

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
