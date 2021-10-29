import java.util.*;
public class ArrayRecursion {
   
   public static boolean search(int item, int[] arr, int start){
      if(arr.length <= 0 || start < 0 || start > arr.length - 1){
         return false;
      }
      if(arr[start]==item){
         return true;
      }
      else{
         return search(item, arr, start+1);
      }
   }

   public static String reverseArrayToString(String[] arr, int index){
     if(index < arr.length/2 ){
      String temp = arr[index];
      arr[index] = arr[arr.length - 1 - index];
      arr[arr.length - 1 - index] = temp;
      reverseArrayToString(arr, index + 1);
     }
      return Arrays.toString(arr);
   }
     public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 5, 6};
        String a[] = { "abc", "def", "ghi", "klm", "nop", "qrs", "tuv" };
        System.out.println(search(6, array, 0));
        System.out.println(reverseArrayToString(a, 0));
     }
}
