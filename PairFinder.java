public class PairFinder {
    
    static void findPairSums(int k, int arr[]){
        int n = arr.length;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] + arr[j] == k)
                    System.out.println(arr[i] + " + " + arr[j] + " = " + k);
    }
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
    /** mergesort */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mSort(arr, temp, 0, arr.length - 1);
    }
    static void findPairSumsFaster(int k, int arr[]){
        
        mergeSort(arr);
        
        int i = 0;
        int j = arr.length - 1;

        while(i < j){
            if(arr[i] + arr[j] == k){
                System.out.println(arr[i] + " + " + arr[j] + " = " + k);
                i++;
            }else if(arr[i] + arr[j] < k){
                i++;
            }else{
                j--;
            }
        }
    }
    public static void main(String[] arg)
    {
        int arr[] = {10, 4, 7, 7, 8, 5, 15};
        int sum = 12;
        System.out.println("Using findPairSums");
        findPairSums(sum, arr);
        System.out.println("Using findPairSumsFaster");
        findPairSumsFaster(sum, arr);
    }
}
