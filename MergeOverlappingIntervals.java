import java.util.*;
public class MergeOverlappingIntervals {
    public static int[][] merge(int intervals[][]){
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged=new LinkedList<>();
        for (int[] interval : intervals){
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]){ // either the LinkedList is empty or the first element of current interval is greater than ending point of the last interval
                merged.add(interval); // start with a new interval 
            }
            else {
                // otherwise there's an overlap 
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]); // expand the interval
                
            }
        }
        

        return merged.toArray(new int[merged.size()][]);

    }
    // Time: O(NlogN)-sorting 
    // space: O(N) - LinkedList
}
