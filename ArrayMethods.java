/*
 * Minsung Kim
 * 
 * Problem Set 2
 * 
 * CS112
 *
 */
import java.util.*;
public class ArrayMethods {

    public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    //swaps adjacent pairs of elements
    public static void swapAdjacent(int[] values){
        //If the parameter is null, the method should throw an IllegalArgumentException.
        if(values.length==0){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < values.length; i = i + 2){
            int var1 = values[i];
            int var2 = values[i+1];
            values[i] = var2;
            values[i+1] = var1;
        }
    }
    
    //returns a new array that is a copy of the original array, but in which all occurrences of the value oldVal are replaced with the value newVal.
    public static int[] copyReplace(int[] values, int oldVal, int newVal){
        if(values.length==0){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < values.length; i++){
            if(values[i] == oldVal){
                values[i] = newVal;
            }else{
                continue;
            }
        }
        return values;
    }
    
    //returns the length of the longest sorted sequence of integers in the array
    public static int maxSorted(int[] values){
        if(values.length==0){
            throw new IllegalArgumentException();
        }
        if(values.length == 0)
			return 0;
		
		int longest = 1;
		int count = 1;
		
		for(int i = 1; i < values.length; i++)
		{
			if(values[i] >= values[i - 1]){
				count++;
            }
			else{
				count = 1;
            }
			if(count > longest)
				longest = count;
		}
		
		return longest;
    }
    
    //returns the index of that string in the class array DAYS
    public static int getIndexOfDay(String day){ 
        int counter=0;

        for(int  i = 0; i < DAYS.length; i++){
           if(DAYS[i].toLowerCase().equals(day.toLowerCase())){
               return counter;
           }
           counter ++;
        }
        return counter;
    }
    
    //copy the elements from the two arrays passed to the array that will be returned, but interchanged from a forward and reverse direction
    public static int[] reverseInterchange( int[] arr1, int [] arr2 ){
        if((arr1.length==0) || (arr2.length==0)){
            throw new IllegalArgumentException();
        }
        int[] array = new int[0];

        if(arr1.length >= arr2.length){

            array = new int[arr2.length*2];

            for(int i = 1; i <= arr2.length; i++){
                int var1 = arr1[i-1];
                int var2 = arr2[arr2.length-i];
                array[2*i - 2] = var1;
                array[2*i - 1] = var2;
            }
        }else{
            array = new int[arr1.length*1];

            for(int i = 1; i <= arr1.length; i++){
                int var1 = arr2[i-1];
                int var2 = arr1[arr1.length-i];
                array[2*i - 2] = var1;
                array[2*i - 1] = var2;
            }
        }
        return array;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean more_input = true;

        System.out.print("1. swapAdjacent\n2. copyReplace\n3. maxSorted\n4. getIndexOfDay\n5. reverseInterchange\n6. exit\n");

        do{

        System.out.print("Choose Method: " );

        int  m = scan.nextInt();

            //swapAdjacent
            if(m==1){
            System.out.print("Enter the number of elements you want to store for a1: ");
            int n=scan.nextInt();
            int[] a1 = new int[n];
            System.out.print("Enter the array for a1: ");
            for(int i = 0; i < a1.length; i++ ){
                a1[i] = scan.nextInt();
            } 
            ArrayMethods.swapAdjacent(a1);
            System.out.println( Arrays.toString(a1));
            }

            //copyReplace
            else if(m==2){
            System.out.print("Enter the number of elements you want to store for a1: ");
            int n=scan.nextInt(); 
            int[] a1 = new int[n];
            System.out.print("Enter the array for a2: ");
            for(int i = 0; i < a1.length; i++ ){
                a1[i] = scan.nextInt();
            }
            System.out.print("Enter the number you want to change: ");
            int val1 = scan.nextInt();
            System.out.print("Enter the replacement number:");
            int val2 = scan.nextInt();
            int[] a3 = ArrayMethods.copyReplace(a1, val1, val2);
            System.out.println( Arrays.toString(a3) ); 
            }

            //maxSorted
            else if(m==3){
            System.out.print("Enter the number of elements you want to store for a1: ");
            int n=scan.nextInt();
            int[] a1 = new int[n];
            System.out.print("Enter the array: ");
            for(int i = 0; i < a1.length; i++ ){
                a1[i] = scan.nextInt();
            } 
            System.out.println( ArrayMethods.maxSorted(a1) );
            }

            //getIndexOfDay
            else if(m==4){
            System.out.print("Enter a date: ");
            String date = scan.next();
            System.out.println( "Your input is: " + date);
            System.out.println(ArrayMethods.getIndexOfDay(date));
            }
            
            //reverseInterchange
            else if(m==5){
            System.out.print("Enter the number of elements you want to store for a1: ");
            int n=scan.nextInt();
            int[] a1 = new int[n];
            System.out.print("Enter the array for a1: ");
            for(int i = 0; i < a1.length; i++ ){
                a1[i] = scan.nextInt();
            }
            System.out.print("Enter the number of elements you want to store for a2: ");
            int j = scan.nextInt(); 
            int[] a2 = new int[j];
            System.out.print("Enter the array for a2: ");
            for(int i = 0; i < a2.length; i++ ){
                a2[i] = scan.nextInt();
            }
            System.out.println( Arrays.toString( ArrayMethods.reverseInterchange(a1, a2) ) );
            }
            
            //exit program
            else if(m==6){
                more_input = false;
            }

            //Does not allow user to choose any numbers except 1-6
            else{
                System.out.println("Cannot compute, wrong number had been entered");
                }
                System.out.println();

            }
        while(more_input);

        scan.close();

        System.out.println("goodbye");
    }
    
}

