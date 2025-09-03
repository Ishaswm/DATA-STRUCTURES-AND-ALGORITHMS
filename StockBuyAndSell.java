import java.util.*;
public class StockBuyAndSell {
    // brute force
    public static int profit(int arr[]){
        int n=arr.length;
        int maxProfit=0;
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                int difference=arr[i]-arr[j];
                maxProfit=Math.max(maxProfit, difference);
            }
        }
        return maxProfit;
    }
    // O(N), O(1)
    public static int profitOptimal(int arr[]){
        int min = Integer.MAX_VALUE;
        int maxProfit=0;
        int n=arr.length;
        for(int i=0; i<n; i++){
            if(arr[i]<min){
                min=arr[i];
            
            }
            int difference=arr[i]-min;
            if(difference>maxProfit){
                maxProfit=difference;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        System.out.println(profit(arr));
        System.out.println(profitOptimal(arr));


    }
}
