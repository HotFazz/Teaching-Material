#include <iostream>
using namespace std;

void selection_sort(int arr[], int n) {
    int i, j, minIdx, temp;

    //Move boundry of unsorted subarray one by one 
    for (i = 0; i < n - 1; i++) {

        // Find the minimum element in the unsorted array
        minIdx = i;

        for(j = i + 1; j < n; j++)
            if (arr[j] < arr[minIdx])
                minIdx = j;
    
        // Swap the found minimum element with the first element
        temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;

    } 
}

//Function to print an array 
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++)
        cout << arr[i] << " ";
    cout << endl;
}


// Main function 
int main() {
    int arr[] = {64, 24, 43, 2, 123, 63, 45, 77, 86, 3};
    int n = sizeof(arr)/sizeof(arr[0]);
    selection_sort(arr, n);
    cout << "The sorted array is: \n";
    printArray(arr, n);
    return 0;
}