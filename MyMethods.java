/*
 * Minsung Kim
 * 
 * Problem Set 2
 * 
 * CS112
 *
 */
import java.util.*;
public class MyMethods {

    //prints decreasing substrings of the original string
    public static void printDecreasing(String a){
        for(int i = a.length(); i >= 0; i--){
            System.out.println(a.substring(0, i));  
            }
    }

    //combines the first and last characters of the original string
    public static String firstAndLast(String a){
        if(a.length()>1){
            System.out.print(a.charAt(0));
            System.out.println(a.charAt(a.length() - 1));
        }else{
            System.out.print(a.charAt(0));
        }
        return a;
    }

    //returns the index of the last occurrence
    public static int lastIndexOf(String a, char b){
        char[] array = new char[a.length()];
        int c = -1;

        for (int i = 0; i < a.length(); i++) {  //convert String to Array
            array[i] = a.charAt(i);
        }
        
        for(int i = array.length - 1; i >= 0 ; i--){
            if(array[i] == b){
                c=i;
                break;
            }else{
                continue;
            }           
        }
        return c;
    }

    //returns a new string consisting of copies of the string
    public static String repeat(String a, int b){
        String result = "";

        for(int i = 0; i < b; i++){
            result = result + a;
        }

        return result;
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("input a word: ");
        String word = scan.nextLine();
        
        printDecreasing(word);
        
        firstAndLast(word);

        System.out.print("input a letter: ");
        char letter = scan.next().charAt(0);

        System.out.println(lastIndexOf(word, letter));

        System.out.print("input a number: ");
        int num = scan.nextInt();
        
        System.out.println(repeat(word, num));

        scan.close();
    }
}
