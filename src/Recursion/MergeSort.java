package Recursion;
import java.util.Arrays;


/*
 Merge Sort

 Approach:
 - Divide the array into two halves recursively until each subarray contains only one element.
 - Since a single element is already sorted, start merging the sorted subarrays.
 - During merging, compare elements from both sorted halves and store them in sorted order.
 - Copy the merged result back into the original array (for the in-place version).
 - Repeat this process until the complete array becomes sorted.

 * Why This Works:

 - Recursively dividing the array guarantees that every subarray eventually becomes of size one.
 - Merging two already sorted subarrays produces another sorted array.
 - Repeating the merge process while returning from recursion results in the entire array being sorted.

 Time Complexity: O(n log n) - The array is divided into log n levels, and each level processes all n elements during merging.

 Space Complexity:
 - O(n) for the temporary array used during merging.
 - Additional O(log n) recursion stack.
*/

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,4,1,5,2};
        mergeSortInPlace(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr){
        if(arr.length == 1)return arr;

        int mid =  arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    static int[] merge(int[] left, int[] right){
        int[] ans = new int[left.length+right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                ans[k] = left[i];
                i++;
            }else{
                ans[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length){
            ans[k] = left[i];
            i++;
            k++;
        }

        while(j <  right.length){
            ans[k] = right[j];
            j++;
            k++;
        }

        return ans;
    }

    static void mergeSortInPlace(int[] arr, int start, int end){
        if(start == end) return;

        int mid = start + (end - start) / 2;

        mergeSortInPlace(arr,start,mid);
        mergeSortInPlace(arr,mid+1,end);

        mergeInPlace(arr,start,mid,end);

    }

    static void mergeInPlace(int[] arr, int start, int mid, int end){
        int[] ans = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                ans[k] = arr[i];
                i++;
            }else{
                ans[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            ans[k] = arr[i];
            i++;
            k++;
        }

        while(j <= end){
            ans[k] = arr[j];
            j++;
            k++;
        }

        for(i = 0;i < ans.length; i++){
            arr[i + start] = ans[i];
        }
    }
}
