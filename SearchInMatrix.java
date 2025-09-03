import java.util.*;

public class SearchInMatrix {
    public static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target){
        int n = matrix.size(); // rows
        int m=matrix.get(0).size(); // columns 
        // looping through rows
        for (int i=0; i<n; i++){
            // checking range 
            if (matrix.get(i).get(0) <= target && target <= matrix.get(i).get(m - 1)){
                return binarySearch(matrix.get(i), target); // call binarySearch for that row and target 
            }
        }
        return false;
    }
    public static boolean binarySearch(ArrayList<Integer> row, int target){
        int n = row.size(); // no. of elements
        int low = 0, high = n-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if (row.get(mid) == target) return true;
            else if (target > row.get(mid)) low = mid+1;
            else high = mid-1;
        }
        return false;

    }
    // TC - O(N) + O(logM) - M because M is the size of a row (the array that we're applying BS on)
    // SC - O(1)
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));
        boolean result = searchMatrix(matrix, 13);
        System.out.println(result ? "true" : "false");
    }
}
