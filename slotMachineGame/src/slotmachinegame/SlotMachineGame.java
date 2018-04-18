/*
 * Lab Assignment 4: Slot Machine Game
 * CS 1110, Spring 2016
 * AUTHOR: Matt Peter
 */
package slotmachinegame;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;
import java.util.Random;

/**
 *
 * @author Matt Peter
 */
public class SlotMachineGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Declare and Instantiate a Scanner and DecimalFormat
        Scanner keyboard = new Scanner(System.in);
        DecimalFormat moneyFormatter = new DecimalFormat("$#0.00");
       
        // Declare and Initialize the variables that will be used in the main method
        double totalMoneyBet = 0.0;             // Total amount of money that has been bet
        double totalMoneyWon = 0.0;             // Total amount of money that has been won
        double currentAmountBet = 0.0;          // Amount of money bet for the current round
        int roundsPlayed = 0;                   // Number of rounds played
        boolean validAmount = false;            // Check as to whether or not the amount entered is valid
        String input = "";                      // String used for user input
        
        // Print opening
        System.out.println("*******************************");
        System.out.println("WELCOME TO THE CS 1110 LOTTERY!");
        System.out.println("*******************************\n");
        
        // Enter into a do-while loop that continues as long as the user wants to play
        do {
            System.out.print("Enter the amount you would like to bet: $");
            
            // Enter into a do-while loop that checks to make sure that what the user entered is valid input
            do {
                if (keyboard.hasNextDouble()) {
                    // If the user entered a number, store that in amountBet and clear any extra input
                    currentAmountBet = keyboard.nextDouble();
                    keyboard.nextLine();
                        if (currentAmountBet < 0.005) {
                            // If the amount entered cannot be rounded to $0.01 or greater, ask the user to enter a different amount
                            System.out.print("Amount must be greater than $0.00.  Please enter another amount: $");
                            validAmount = false;
                        } else {
                            // Otherwise, the amount entered is acceptable
                            validAmount = true;
                        }
                } else {
                    // If the user did not enter a number, ask the user to enter a different amount
                    System.out.print("NOT ACCEPTED. Please enter another amount: $");
                    keyboard.nextLine();
                    validAmount = false;
                }
            } while (validAmount == false);
            
        
            // Round the amount to the nearest cent
            currentAmountBet = (double)Math.round(currentAmountBet * 100) / 100;
            
            // Add the current bet to the total bets
            totalMoneyBet += currentAmountBet;
            
            System.out.println();
            
            // Execute the runSlotMachine(double, DecimalFormat) method to run the slot machine and
            // add the amount won that round to the total amount won
            totalMoneyWon += runSlotMachine(currentAmountBet, moneyFormatter);
            
            // Increase the number of rounds played by 1
            roundsPlayed++;
            
            // Check whether the user wants to play another round
            System.out.print("\nWould you like to play again (Y for Yes, N for No)? ");
            input = keyboard.nextLine();
        
        } while (input.charAt(0) == 'Y' || input.charAt(0) == 'y');
        
        // When the user decides to quit, print out their total bets and how many rounds they played
        System.out.println("You bet a total of " + moneyFormatter.format(totalMoneyBet) +
                           " in " + roundsPlayed + " rounds of playing the slot machine.");
        
        // Tell the user how much they won
        System.out.print("You won a total of " + moneyFormatter.format(totalMoneyWon) + ". ");
        
        // See whether or not the user won anything, and print out a specific response accordingly
        if (totalMoneyWon == 0.0) {
            System.out.println("You weren't so lucky today. Come back and try again.");
        } else {
            System.out.println("Today was your lucky day! Come back and play again!");
        }
    }
    
    /*
     * INPUT: double, DecimalFormat
     * OUTPUT: double
     * DESCRIPTION: This method takes an input of the amount the user decides to bet after
     *              it is confirmed to be valid.  It also takes in the DecimalFormat that the
     *              winnings are to be displayed in.  It runs the "slot machine", displaying
     *              three random words found by generating three random numbers ranging from
     *              0 to 5.  After the displaying the results, it checks to see if any of the
     *              words match up.  If 2 of them match up, the user has won twice the amount
     *              they bet.  If all 3 of them match up, the user has won three times the
     *              amount they bet.  Otherwise, if none of them match up, the user has won
     *              nothing.  They amount they have won is stored in the variable moneyWon,
     *              and is returned to the main method.
     * AUTHOR: Matthew Peter
     * TIME LAST EDITED: 3/2/2016 11:26 AM
     */
    public static double runSlotMachine (double bet, DecimalFormat winningFormatter) {
        
        // Declare and Instantiate a Random number generator
        Random rand = new Random();
        
        // Declare and Instantiate/Initialize the two arrays that will be used for the slot machine
        String[] slotPics = {"Apple", "Oranges", "Banana", "Coconut", "Plums", "Cherries"};
        String[] slotResults = new String[3];
        
        // Declare and Initialize the variables
        int slotDisplayWidth = 0;               // Keeps track of the width of the slot display
        int multiplier = 0;                     // Multiplier for the current bet (0, 2, or 3)
        double moneyWon = 0.0;                  // Amount of money won on the current bet
        
        // Prints out the top row on the display
        for (int i = 0; i <= 2; i++) {
            slotResults[i] = slotPics[rand.nextInt(6)];
            for (int j = 1; j <= (slotResults[i].length() + 3); j++) {
                System.out.print("-");
                slotDisplayWidth++;
            }
        }
        
        // Finishes the top row on the display
        System.out.println("-");
        slotDisplayWidth++;
        
        // Prints the results on the display
        System.out.println("| " + slotResults[0] + " | " + slotResults[1] +
                            " | " + slotResults[2] + " |");
        
        // Prints the bottom row on the display
        for (int k = 1; k <= slotDisplayWidth; k++)
            System.out.print("-");
        
        System.out.println("\n");
        
        // Checks to see if any of the results match and assigns a value to the multiplier accordingly
        if (slotResults[0].equals(slotResults[1])) {
            if (slotResults[1].equals(slotResults[2])) {
                multiplier = 3;
            } else {
                multiplier = 2;
            }
        } else if (slotResults[1].equals(slotResults[2])) {
            multiplier = 2;
        } else {
            multiplier = 0;
        }
        
        // Calculates amount of money won based on original bet and resulting multiplier
        moneyWon = bet * multiplier;
        
        // Prints out results
        switch (multiplier) {
            case 3:
                System.out.println("Amazing! All three of the words match!");
                System.out.println("Congratulations! You've just tripled your bet!");
                System.out.println("You won " + winningFormatter.format(moneyWon));
                break;
            case 2:
                System.out.println("Great! Two of the words match!");
                System.out.println("Congratulations! You've just doubled your bet!");
                System.out.println("You won " + winningFormatter.format(moneyWon));
                break;
            case 0:
                System.out.println("Sorry, none of the words match.");
                System.out.println("You lost the bet.");
                break;
        }
        
        // Returns the amount won to main method
        return moneyWon;
    }
}
