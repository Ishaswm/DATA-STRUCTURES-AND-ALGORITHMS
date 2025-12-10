import java.util.Arrays;

public class Merge2sortedArrays {
    public static void mergeUsingThreePointers(int nums1[], int m, int nums2[], int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        //merge from back
        while (i>=0 && j>=0) {
            if (nums1[i] > nums2[j]){
                nums1[k] = nums2[j];
                i--;
            } else {
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
        // remaining elements in nums2, add in the nums1 
        while (j>=0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        // time: O(m+n)
        // space: O(1)
    }

    public static void merge(int arr1[], int arr2[]){
        int i = 0;
        int j = 0;
        int n=arr1.length;
        int m=arr2.length;

        while (i<n && j<m) {
            if (arr1[i] > arr2[j]){
                int temp=arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                j++;
                i++;
            } else {
                i++;
            }
        }
        Arrays.sort(arr2);
    }

    // Gap Method 
    public static void merge2(int arr1[], int arr2[], int n, int m){
        int len = n+m;
        int gap=(len/2)+(len % 2); // ceil value 
        while (gap > 0) {
            int left = 0;
            int right = left + gap; // so that the gap is maintained 
            while (right < left) {
                // case 1: left in arr1 and right in arr2 
                if (left < n && right >= n){
                    swapIfGreater(arr1, arr2, left, right-n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >=n){
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;
            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }


    }
    public static void swapIfGreater(int arr1[], int arr2[], int ind1, int ind2){
        if (arr1[ind1]>arr2[ind2]){
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2]=temp;
        }
    }
    public static void main(String[] args) {
        int arr1[] = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        merge2(arr1, arr2, n, m);
        System.out.println("merged array:");


    }
    
}
