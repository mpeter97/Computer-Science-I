/* PROJECT:  BigDigits - Asgn 3
 * AUTHOR:  Matt Peter
 * COURSE:  CS1110, Semester: Spring  Lab instructor: Vinay
 * DESCRIPTION of OVERALL APPLICATION:  This app produces a "banner" of digits
 *      based on a 3-digit number which the user inputs.  It's a vertical banner
 *      which displays in the IDE's console window.  The required font for the 
 *      10 possible digits is shown in the asgn specs.  Each digit prints as 9
 *      characters high and 8 characters wide using * as the "drawing pen".
 *
 * DESCRIPTION of this MAIN code:  The "main" method in THIS BigDigits class is
 *      the overall controller for the whole app.  It:
 *          - gets the user input (a 3-digit number)
 *          - grabs each of the 3 individual digits in turn
 *          - and for each digit, calls the appropriate digit controller method.
 * NOTE:  Since each of the 3 digits is handled in the same way (i.e., decide
 *      which of the 10 DigitControllers to call), THIS class also contains
 *      a separate LOCAL (private) method which handles a single digit (i.e.,
 *      it "does the deciding", based on what value is passed in to it (as a
 *      parameter) and calls the appropriate DigitControllers method).
 *
 * [NOTE:  All 3 of these .java files are part of the SAME bigdigits package,
 *      specified at the top of each of the 3 separate code files].
 * [NOTE:  This project currently runs with no errors.  Use incremental 
 *      development to always keep the project in a "working state".
 ******************************************************************************/

package bigdigits;

import javax.swing.JOptionPane;

public class BigDigits {

    public static void main(String[] args) {
        
        // Declare Variables
        String input;
        int threeDigitNumber, firstDigit, secondDigit, thirdDigit;
       
        // Get user input via InputDialog Box and store input as int
        input = JOptionPane.showInputDialog("Please enter a 3-digit number:");
        threeDigitNumber = Integer.parseInt(input);
        
        // Place digits of threeDigitNumber into 3 seperate variables
        firstDigit = threeDigitNumber / 100;
        secondDigit = (threeDigitNumber % 100) / 10;
        thirdDigit = (threeDigitNumber % 100) % 10;
        
        // Use the handle1Digit function to decide what function in DigitControllers to execute
        handle1Digit(firstDigit);
        handle1Digit(secondDigit);
        handle1Digit(thirdDigit);
        
        System.exit(0);
    }
    
    private static void handle1Digit(int nthDigit) {
        // Use a switch statement based on the variable nthNumber to pick the right function to execute
        switch (nthDigit) {
            case 0:
                DigitControllers.printZero();
                break;
            case 1:
                DigitControllers.printOne();
                break;
            case 2:
                DigitControllers.printTwo();
                break;
            case 3:
                DigitControllers.printThree();
                break;
            case 4:
                DigitControllers.printFour();
                break;
            case 5:
                DigitControllers.printFive();
                break;
            case 6:
                DigitControllers.printSix();
                break;
            case 7:
                DigitControllers.printSeven();
                break;
            case 8:
                DigitControllers.printEight();
                break;
            case 9:
                DigitControllers.printNine();
                break;
        }
    }
}