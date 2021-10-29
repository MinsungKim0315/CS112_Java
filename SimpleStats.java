/*
 * Minsung Kim
 * 
 * Problem Set 1
 * 
 * A simple interactive program that performs operations 
 * on a set of three integers.
 *
 * CS112
 *
 */
import java.util.*;
/*
 * Program Class Defintion
 */
public class SimpleStats {
    //Method to display user opyions
    public static void printMenu() {
        System.out.println("(0) Enter new numbers");
        System.out.println("(1) Find the largest");
        System.out.println("(2) Compute the sum");
        System.out.println("(3) Compute the range (largest - smallest)");
        System.out.println("(4) Compute the average");
        System.out.println("(5) Print the numbers in ascending order");
        System.out.println("(6) Quit");
        System.out.println();
    }
    
    //Method to find the largest number
    public static int returnLargestNumber(int a, int b, int c){     
        
        int M;                                          //Largest number
        
        if(a<b && b<c){M=c;}
        else if(a<=c && c<=b){M=b;}
        else if(b<=a && a<=c){M=c;}
        else if(b<=c && c<=a){M=a;}
        else if(c<=a && a<=b){M=b;}
        else{M=a;}

        return M;
    }
    
    //Method to compute the sum
    public static int returnSum(int a, int b, int c){     
        
        int S;                                          //Sum
        
        S = a + b + c;
        
        return S;
    }
    
    //Method to compute the range(largest-smallest)
    public static int returnRange(int a, int b, int c){     
        
        int M, m, R;                                    //Largest number, smallest number, and the range
        
        if(a<b && b<c){M=c;m=a;}
        else if(a<=c && c<=b){M=b;m=a;}
        else if(b<=a && a<=c){M=c;m=b;}
        else if(b<=c && c<=a){M=a;m=b;}
        else if(c<=a && a<=b){M=b;m=c;}
        else{M=a;m=c;}

        R = M - m;

        return R;
    }
    
    //Method to compute the adverage
    public static double returnAdverage(int a, int b, int c){      
        
        double A;                                           //Adverage
        
        A = (a + b + c)/3.0;
        
        return A;
    }
    
    //Method to print numbers in ascending order
    public static void printAscendingOrder(int a, int b, int c){        
        
        int M, m, j;                                        //Largest number, smallest number, and the rest
        
        if(a<b && b<c){M=c;m=a;j=b;}
        else if(a<=c && c<=b){M=b;m=a;j=c;}
        else if(b<=a && a<=c){M=c;m=b;j=a;}
        else if(b<=c && c<=a){M=a;m=b;j=c;}
        else if(c<=a && a<=b){M=b;m=c;j=a;}
        else{M=a;m=c;j=b;}
        
        System.out.println("In order, the numbers are: "+ m +" "+ j +" "+ M);
        
    }
    
    //main() 
    public static void main(String[] args) {
        //Scanner object
        Scanner scan = new Scanner(System.in);
        // variable declarations and initializations as needed
        boolean more_input = true;
	    //Control loop
        do {
	        // Call the method which displays the menu choices
            printMenu();
	        // Prompt to enter the choice of operation
            System.out.print("Enter your choice: ");
            // Input device
            int choice = scan.nextInt();
        if (choice == 0) {
            //control loop
            do{
            // Input the three numbers
            System.out.print("Enter three new numbers: ");
            // Input device
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            int n3 = scan.nextInt();
            System.out.println();
            // Verify the numbers entered
            System.out.println("The current numbers are: " + n1 + " " + n2 + " " + n3);
                //control loo
                do{
                // Call the method which displays the menu choices
                printMenu();
                // Prompt to enter the choice of operation
                System.out.print("Enter your choice: ");
                // Input device
                choice = scan.nextInt();
                if (choice == 0){
                    //allow user to enter new three numbers
                    break;
                }
                if(choice == 1){
                    // Call the method which returns the largest number
                    System.out.println("The largest number of the numbers is " + returnLargestNumber(n1, n2, n3));
                    System.out.println();
                    System.out.println("The current numbers are: "+ n1 +" " + n2 + " " + n3);
                    continue;
                }
                else if(choice == 2){
                    // Call the method which returns the sum of numbers
                    System.out.println("The sum of the numbers is " + returnSum(n1, n2, n3));
                    System.out.println();
                    System.out.println("The current numbers are: "+ n1 +" " + n2 + " " + n3);
                    continue;
                }
                else if(choice == 3){
                    // Call the method which returns the range
                    System.out.println("The range of the numbers is " + returnRange(n1, n2, n3));
                    System.out.println();
                    System.out.println("The current numbers are: "+ n1 +" " + n2 + " " + n3);
                    continue;
                }
                else if(choice == 4){
                    // Call the method which returns the adverage
                    System.out.println("The average of the numbers is: " + returnAdverage(n1, n2, n3));
                    System.out.println();
                    System.out.println("The current numbers are: "+ n1 +" " + n2 + " " + n3);
                    continue;
                }
                else if(choice == 5){
                    // Call the method which displays the ascending order
                    printAscendingOrder(n1, n2, n3);
                    System.out.println();
                    System.out.println("The current numbers are: "+ n1 +" " + n2 + " " + n3);
                    continue;
                }
                else if(choice == 6){
                    // quit program
                    more_input = false;
                }
                else{
                    //Does not allow user to choose numbers other then options 0-6
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
                }while(more_input);
            }while(more_input);
            }    
        else if (choice == 6) {
            //Exit program
            more_input = false;
            }
        else {
            //Does not allow user to choose options 1-5 unless option 0 is chosen to input the three numners
            System.out.println("Cannot compute, numbers have not been entered");
            }
            System.out.println();
        }while (more_input);
         
        System.out.println("Have a nice day!");

        scan.close();
    }
}