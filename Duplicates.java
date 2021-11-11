import java.util.*;
public class Duplicates {

    static int removeDups(int arr[]){
        int n = arr.length;
        if (n == 0 || n == 1){
            return n;
        }
      
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n - 1; i++){ 
            if (arr[i] != arr[i+1])
                temp[j++] = arr[i];
        }

        temp[j++] = arr[n-1];  

        for (int i = 0; i < n; i++){
            if(i < j){
                arr[i] = temp[i];
            }
            else{
                arr[i] = 0;
            }
        }
        return j;
    }
     
    public static void main (String[] args)
    {
        int arr[] = {2, 5, 5, 5, 10, 12, 12};
        
        int ret = removeDups(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ret);
    }
}
