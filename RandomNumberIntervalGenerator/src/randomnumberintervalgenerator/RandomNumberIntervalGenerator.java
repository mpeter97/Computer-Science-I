/*
 * CS 1110 Lab
 * 3/2/16 6:30p - 8:20p
 * AUTHOR: Matt Peter
 */
package randomnumberintervalgenerator;

import java.util.*;

/**
 *
 * @author Matt Peter
 */
public class RandomNumberIntervalGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Declare the Scanner to be used
        Scanner keyboard = new Scanner(System.in);
        
        // Declare the variables to be used
        int n;                      // Used to store verified input
        int numberOfEvens;          // Used to store the value returned by cntEvnNumsRandGenInInterval(int)
        
        // Prompt the user for a positive integer
        System.out.print("Enter an integer.  It must be greater than 0: ");
        n = keyboard.nextInt();
        
        // If the integer is not greater than 0, continue to prompt until one is obtained
        while (n <= 0) {
            System.out.print("It must be greater than 0: ");
            n = keyboard.nextInt();
        }
        
        // Call the cntEvnNumsRandGenInInterval(int) method, passing n, and expecting an int in return
        numberOfEvens = cntEvnNumsRandGenInInterval(n);
        
        // Print out some text containing the value returned by cntEvnNumsRandGenInInterval(int)
        System.out.println ("and there are " + numberOfEvens + " of them that are even.");
        
    }
    
    /*
     * Input: int
     * Output: int
     * Description: This method is given a positive integer n input (as checked
                    in the main method) and generates 10 integers within in the
                    interval of [-n, n].  It then counts how many of the integers
                    are even and returns that value back to the main method.
     * Author: Matthew Peter
     * Date/Time: 3/2/16 6:55p
    */
    public static int cntEvnNumsRandGenInInterval(int range) {
        
        // Declare a random number generator
        Random rand = new Random();
        
        // Declare variables
        int numGenerated;               // Stores a randomly generated number
        int numEvens = 0;               // Keeps track of the amount of even numbers
        
        System.out.println("In the interval [" + -range + ", " + range +
                            "], my experiments randomly generated the " +
                            "following 10 numbers");
        
        // Generates 10 random numbers in the range [-n, n], prints them, and keeps track of evens
        for (int i = 1; i <= 10; i++) {
            numGenerated = rand.nextInt((range * 2) + 1) - range;
            System.out.print(numGenerated + ", ");
            if (numGenerated % 2 == 0)
                numEvens++;
        }
        
        return numEvens;
    }
    
}
