import java.util.*;
public class MergeIntersect {
    private static void merge(int[] arr, int[] temp, 
      int leftStart, int leftEnd, int rightStart, int rightEnd)
    {
        int i = leftStart;    // index into left subarray
        int j = rightStart;   // index into right subarray
        int k = leftStart;    // index into temp
        
        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; k++;
            } else {
                temp[k] = arr[j];
                j++; k++;
            }
        }
        
        while (i <= leftEnd) {
            temp[k] = arr[i];
            i++; k++;
        }
        while (j <= rightEnd) {
            temp[k] = arr[j];
            j++; k++;
        }
        
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
    }
    private static void mSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int middle = (start + end)/2;
        mSort(arr, temp, start, middle);
        mSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle + 1, end);
    }
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mSort(arr, temp, 0, arr.length - 1);
    }
    public static int[] intersect(int arr1[], int arr2[]){
        mergeSort(arr1);
        mergeSort(arr2);
        int t = 0;
        if(arr1.length > arr2.length){
            t = arr2.length;
        }else{
            t = arr1.length;
        }
        int[] temp = new int[t];
        int i = 0;
        int m = arr1.length;
        int j = 0;
        int n = arr2.length;
        int k = 0;
        while(i < m && j < n){
            if(arr1[i] == arr2[j]){
                temp[k++] = arr1[i];
                i++;
                j++;
            }else if(arr1[i] < arr2[j]){
                i++;
            }else{
                j++;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        int a1[] = {10, 5, 7, 5, 9, 4};
        int a2[] = {7, 5, 15, 7, 7, 9, 10};
        int[] result = MergeIntersect.intersect(a1, a2);
        System.out.println(Arrays.toString(result));
    }
}
