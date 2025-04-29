public class MergeSort {

    public static void main(String[] args) {
        // Initialize an array of strings
        String[] strings = {"apple", "banana", "kiwi", "grapefruit", "pear", "orange"};
        
        // Call the mergeSortByLength method to sort the array by string length
        mergeSortByLength(strings, 0, strings.length - 1);
        
        // Print the sorted array
        System.out.println("Sorted strings by length: ");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static void mergeSortByLength(String[] arr, int start, int end) {
        // implement method here
        if (start < end) {
            // Find the middle point of the array
            int middle = (start + end) / 2;

            // Recursively sort the left half
            mergeSort2(arr, start, middle);

            // Recursively sort the right half
            mergeSort2(arr, middle + 1, end);

            // Merge the sorted halves
            merge2(arr, start, middle, end);
        }

    }

    public static void merge2(String[] arr, int left, int middle, int right) {
        // implement method here
        // Calculate the sizes of the two sub-arrays
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays for the left and right halves
        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Initialize indices for merging
        int i = 0, j = 0, k = left;

        // Merge the two sorted arrays based on string length
        while (i < n1 && j < n2) {
            if (leftArray[i].length() <= rightArray[j].length()) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left array
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right array
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

    }
}
