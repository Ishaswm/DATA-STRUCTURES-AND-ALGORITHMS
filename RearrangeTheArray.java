import java.util.*;
public class RearrangeTheArray {
    // Variety 2 - Not necessarily equal 
    public static int[] rearrangeTheArray(int arr[], int N){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        // segregate the array into positives and negatives 
        for(int i=0;i<N;i++){
            if(arr[i]>0){
                pos.add(arr[i]);
            }
            else neg.add(arr[i]);
        }
        //if positives are lesser than negatives
        if(pos.size() < neg.size()){
            for (int i=0; i<pos.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1]=neg.get(i);
            }
            // Fill the remaining negatives at the end of the array.
            int idx=2*pos.size();
            for(int i=pos.size(); i<neg.size(); i++){
                arr[idx]=neg.get(i);
                idx++;
            }
        }
        // If negatives are lesser than the positives.
        else{
            //first fill array alternatively in the case where positives = negatives
            for(int i=0;i<neg.size();i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1]=neg.get(i);
            }
            // Fill the remaining positives at the end of the array.
            int idx=2*neg.size();
            for(int i=neg.size(); i<pos.size();i++){
                arr[idx]=pos.get(i);
                idx++;
            }

        }
        return arr;
        
    }
}
