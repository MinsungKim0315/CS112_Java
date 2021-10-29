/* 
    Daniel Oh & Minsung Kim
    CS112 Problem Set 3 Part 2: Histogram
*/

import java.util.Scanner;
import java.util.*;

public class Histogram { 
    
    private static final int SENTINAL = -999;          // sentinal value to signal endo of input
    private static final int MAX_NUMBERS = 20;         // maximum number of numbers to input
    private static final double UPPER_BOUND = 100.0;   // largest numbers accepted as data
    private static final double LOWER_BOUND = 0.0;     // smallest numbers accepted as adata
    private static final int NUM_BINS = 10;            // number of bins in range [0..100]

    //private static final int BIN_SIZE = ??           // size of each bin
   
    /*
     * Method to show an example of using StringBuilder.
     *
     * You will also notice that this method is called from the 
     * main function. 
     *
     */
    public static String getHeaderAsString( String me ) {

	// Create an instance of the StringBuilder class
	// which allows us to create an object of 
	// a series of strings that can then be converted 
	// into one large string via the toString method.
	//
    	StringBuilder sb=new StringBuilder();

        sb.append( System.getProperty("line.separator") );
        sb.append( "Welcome to the Histogram Program " + me + "!" );
	me = getFirstName(me);
        sb.append( System.getProperty("line.separator") );
        sb.append( System.getProperty("line.separator") );
        sb.append( "This program will print out a histogram of the numbers" );
        sb.append( System.getProperty("line.separator") );
        sb.append( "input by you " + getFirstName(me) + "." );
        sb.append( System.getProperty("line.separator") );
        sb.append( System.getProperty("line.separator") );
        sb.append( "Please enter up to " + MAX_NUMBERS + " doubles or " + SENTINAL + " to stop input!" );
        sb.append( System.getProperty("line.separator") );

        return sb.toString();
    }

    /* 
     * Method to return the first name of the user in case
     * the full name was entered. 
     */
    public static String getFirstName(String name ) {
        // Note that add the " " to string to be sure
        // there is something to split
	return (name+" ").split(" ")[0]; 
    }

    /* 
     * local main test driver
     *
     */
    public static void main(String[] args) {  

	// Connect to the keyboard as the input stream
        Scanner userInput = new Scanner( System.in );

        System.out.print( "And who am I working with today? " );
        String user = userInput.nextLine();

	String heading = getHeaderAsString( user );

        // Print out welcome message
        System.out.println( heading ); 
        
        // Call the method which prompts the user
        // to input the numbers that will be used
        // to build the histogram.
        double[] numbers = inputNumbers( userInput );

        System.out.println(Arrays.toString(numbers));
	// Call the method to reate the array histogram
	int[] histogram = calculateHistogram( numbers );

	// Print the historgram
	System.out.println( toString( histogram ) );

    } // end of main 

    /*
     *
     * COMPLETE YOUR METHODS
     *
     */

  
    public static int [] calculateHistogram( double [] numbers ) {
        int[] result = new int[NUM_BINS];

        for (double val : numbers) {
            if (val == - 1)
                break;
            else 
                result[findBin(val)]++;

        } // end of for loop


        return result;

    } // end of calculateHistogram

    public static int findBin( double num ) {
        if (num <=10)
            return 0;
        else if (num <=20)    
            return 1;
        else if (num <=30)    
            return 2;
        else if (num <=40)    
            return 3;
        else if (num <=50)    
            return 4;
        else if (num <=60)    
            return 5;
        else if (num <=70)    
            return 6;
        else if (num <=80)    
            return 7;
        else if (num <=90)    
            return 8;
        else if (num <=100)    
            return 9;
        return 0;
    } // end of find bin

    public static String toString( int [] histogram ) {
        
        String[] tempStrings = {"[0..10]:   ", "(10..20]:  ", "(20..30]:  ", "(30..40]:  ", "(40..50]:  ", "(50..60]:  ", "(60..70]:  ", "(70..80]:  ", "(80..90]:  ", "(20..100]: " };

        for (int i = 0; i < NUM_BINS; i++) {
            for (int j = histogram[i]; j > 0; j--) {
                tempStrings[i] += "*";               
            }
        }

        String result = "";

        for (String string : tempStrings) {
            result += string + "\n";

        }
        // The histogram can be visualzed as a series of
        // buckets, where each bucket represents one range
        // of the histogram:
        //    [0..10]: **** 
        //    (10..20]: ** 
        //    (20..30]: *** 
        //    (30..40]: * ... ]
    
        // The string returned should only contain the string representation
        // of the histogram and no other verbeage. It should function
        // like the toString method of the Array class but specific to
        // creating a histogram.
    
        // You may want to create an instance of the
        // StringBuilder class to assist you in this method.
        // Follow the code in the method getHeaderAsString
        // as a guide. You can also use string concatenation.

        return result;
    } // end of to string

    public static boolean validInput( double num ) {
        
        if(num >= LOWER_BOUND && num <= UPPER_BOUND)
            return true;
        else 
            return false;

    } //end of boolean


    public static double[] inputNumbers( Scanner scan ) {
        int counter = 0;
        double[] result = new double[MAX_NUMBERS];
        double input;

        while (counter < 20) {
            input = scan.nextDouble();

            if(input == SENTINAL){
                break;

            } else if(validInput(input)) {
                result[counter] = input;
                counter++;    
            } else {
                System.out.println("Invalid Input, please enter a vaid input");

            }

        } // end of while loop

        // fills the rest up with -1
        if (counter < 20)
            result[counter] = -1;

        return result;
    } // end of inputNumbers


} // end of class