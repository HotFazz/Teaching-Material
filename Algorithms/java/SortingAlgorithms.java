/**
 * A collection of sorting algorithms implementations.
 */
public class SortingAlgorithms {
    /**
     * Sorts an array using the bubble sort algorithm.
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * @param arr the array to be sorted
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // Array is sorted
        }
    }

    /**
     * Sorts an array using the selection sort algorithm.
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * @param arr the array to be sorted
     */
    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    /**
     * Sorts an array using the insertion sort algorithm.
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * @param arr the array to be sorted
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Sorts an array using the merge sort algorithm.
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * @param arr the array to be sorted
     * @param left the starting index
     * @param right the ending index
     */
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Prevents overflow
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * Helper method for mergeSort to merge two sorted subarrays.
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

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
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    /**
     * Helper method for heapSort to maintain heap property.
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
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

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
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Helper method for quickSort to partition the array.
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Helper method to swap two elements in an array.
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
} 