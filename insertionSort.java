public class insertionsort {
    public static void insertionSort(int arr[]) {
        for (int i=0; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            while (prev>=0 && arr[prev]>curr) {
                arr[prev+1]=arr[prev];
                prev--;
                
            }
            // insertion
            arr[prev+1]=curr;
        }
    }

    public static void recursiveInsertionSort(int arr[], int n) { // O(n^2)
        // base case
        if (n<=1){
            return;
        }
        recursiveInsertionSort(arr, n-1);
        int last = arr[n-1];
        int j = arr[n-2];
        while (j>=0 && arr[j] > last) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }
    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]= {5,4,1,3,2};
        int n = arr.length;
        insertionSort(arr);
        printArr(arr);

    }
}
