/*
 * Minsung Kim
 * 
 * Problem Set 2
 * 
 * CS112
 *
 */
import java.util.*;
public class PalindromeTest {

    public static boolean isPalindrome( String s ) {
        boolean isPal = false;    // assume that it is not
        // code to determine if the string s is a palindrome

        int m = 0;  //Tool for deciding whether String s is a palindrome or not

        String temp = s;    //Copy s into temp in order to not modify the actual input from the user

        // If the default (as above) assumes the string is not a palindrome,
        // the logic here should determine if it is and reassign the return
        // variable isPal appropriately, or vice verse.
        
        //Change the string to all lowercase
        temp = temp.toLowerCase();

        //Remove any character from the string which is neither a letter nor a digit
        for(int i = 0; i < temp.length(); i++){
            int a = temp.charAt(i);
            if((97 <= a) && (a <= 122)){
                continue;
            }else if((48 <= a) && (a <= 57)){
                continue;
            }else{
                temp = temp.replace(temp.charAt(i), '\0');
                temp = temp.replace("\0", "");
            }
        }

        //Check if the string is a palindrome
        for(int i = 0; i < temp.length()/2; i++){
            if(temp.charAt(i) == temp.charAt(temp.length() -1 - i)){
                m++;
            }else{
                continue;
            }
        }
        if(m==temp.length()/2){
            isPal = true;
        }else{
            isPal = false;
        }
        
        //If the string is a palindrome return true, if it is not a palindrome, then return false
        return( isPal );
     }

     public static int[] inputStringPalindrome(){
        
        // array = [how many times the isPalindrome method was called, how many of the strings input were palindromes]
        int[] array = new int[2];
        
        System.out.println("\nWelcome to the Palindrome Test Program!");

        // Declare a scanner object for user input
        Scanner userInput = new Scanner(System.in);

        System.out.print("\nType in a line of text (a String) or \"quit\" to end: ");

        // Continue to receive user input until some
        // sentinal (i.e. final) value is entered.
        // In this case, the user must enter the
        // word "quit".
        while (userInput.hasNextLine()) {

            String line = userInput.nextLine();
            
            //Tool for counting how many palindromes exist
            boolean tool = isPalindrome(line);

            if (line.equals("quit")){
            // User has specified input it over,
            // break out of the loop.
                break;
            }else {
                //Output whether or not the string entered is or is not a palindrome.
                System.out.println("You input: " + line);
                System.out.print("\nType in a line of text (a String) or \"quit\" to end: ");

                //Count how many times the isPalindrome method was called
                array[0]++;

                //Count how many palindromes exist
                if(tool == true){
                    array[1]++;
                }else{
                    continue;
                }
            }
        } // while

        System.out.println("goodbye!");
        userInput.close();
        
        //contain data on how many times the isPalindrome method was called, and how many of the strings input were palindromes
        return array;
     }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(inputStringPalindrome()));
    }
    
}