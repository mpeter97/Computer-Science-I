/* CLASS OF LEVEL-2 SUB-MANAGER METHODS:  DigitControllers
 * PART OF PROJECT:  BigDigits
 * AUTHOR:  Matt Peter
 * DESCRIPTION:  The 10 methods in THIS class control the printing for each of 
 *      the 10 digits (1 method per digit) - e.g., do0, . . . do9.  These 10 
 *      methods do NOT actually do the output printing – instead, they call
 *      various worker methods in the LineDrawers class to do the actual 
 *      writing, sending in the necessary parameter values (where needed).
 *      The final thing EACH method does is call the doBlankLine method.
 *****************************************************************************/

package bigdigits;

public class DigitControllers {
    // Print out a Zero using LineDrawers functions
    public static void printZero() {
        LineDrawers.doHorLine();
        LineDrawers.doLRVerLine(7);
        LineDrawers.doHorLine();
        LineDrawers.doBlankLine();
    }
        
    // Print out a One using LineDrawers functions
    public static void printOne() {
        LineDrawers.doRVerLine(9);
        LineDrawers.doBlankLine();
    }
        
    // Print out a Two using LineDrawers functions
    public static void printTwo() {
        LineDrawers.doHorLine();
        LineDrawers.doRVerLine(3);
        LineDrawers.doHorLine();
        LineDrawers.doLVerLine(3);
        LineDrawers.doHorLine();
        LineDrawers.doBlankLine();
    }
        
    // Print out a Three using LineDrawers functions
    public static void printThree() {
        LineDrawers.doHorLine();
        LineDrawers.doRVerLine(3);
        LineDrawers.doHorLine();
        LineDrawers.doRVerLine(3);
        LineDrawers.doHorLine();
        LineDrawers.doBlankLine();
    }
        
    // Print out a Four using LineDrawers functions
    public static void printFour() {
        LineDrawers.doLRVerLine(4);
        LineDrawers.doHorLine();
        LineDrawers.doRVerLine(4);
        LineDrawers.doBlankLine();
    }
        
    // Print out a Five using LineDrawers functions
    public static void printFive() {
        LineDrawers.doHorLine();
        LineDrawers.doLVerLine(3);
        LineDrawers.doHorLine();
        LineDrawers.doRVerLine(3);
        LineDrawers.doHorLine();
        LineDrawers.doBlankLine();
    }
        
    // Print out a Six using LineDrawers functions
    public static void printSix() {
        LineDrawers.doLVerLine(4);
        LineDrawers.doHorLine();
        LineDrawers.doLRVerLine(3);
        LineDrawers.doHorLine();
        LineDrawers.doBlankLine();
    }
        
    // Print out a Seven using LineDrawers functions
    public static void printSeven() {
        LineDrawers.doHorLine();
        LineDrawers.doRVerLine(8);
        LineDrawers.doBlankLine();
    }
        
    // Print out a Eight using LineDrawers functions
    public static void printEight() {
        LineDrawers.doHorLine();
        LineDrawers.doLRVerLine(3);
        LineDrawers.doHorLine();
        LineDrawers.doLRVerLine(3);
        LineDrawers.doHorLine();
        LineDrawers.doBlankLine();
    }
        
    // Print out a Nine using LineDrawers functions
    public static void printNine() {
        LineDrawers.doHorLine();
        LineDrawers.doLRVerLine(3);
        LineDrawers.doHorLine();
        LineDrawers.doRVerLine(4);
        LineDrawers.doBlankLine();
    }
}