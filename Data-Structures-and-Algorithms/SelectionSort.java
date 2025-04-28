public class SelectionSort {
    public static void main(String[] args) {
        // Sample list of test scores
        int[] testScores = {85, 92, 78, 96, 89, 73, 91};

        // Call the method to sort in descending order
        selectionSortDescending(testScores);

        // Print the sorted scores
        System.out.print("Test scores sorted in descending order: ");
        for (int score : testScores) {
            System.out.print(score + " ");
        }
    }

    public static void selectionSortDescending(int[] arr) {
        // TODO: Write the logic to sort the scores in descending order using selection sort
        int n = arr.length;

        for(int i = 0; i < n; i++){
            int maxIdx = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] > arr[maxIdx])
                    maxIdx = j;
            }

            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }
}
