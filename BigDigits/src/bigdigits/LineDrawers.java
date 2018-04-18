/* CLASS OF LEVEL-3 WORKER METHODS:  LineDrawers
 * PART OF PROJECT:  BigDigits
 * AUTHOR:  Matt Peter * DESCRIPTION:  The methods in THIS class do the actual "drawing" (i.e., 
 *      printing to the IDE's Output window) of various types of lines.  This
 *      includes these methods:
 *      FOR HORIZONTAL LINES:
 *          doHorLine    (assume it's always 8 *'s wide)
 *      FOR VERTICAL LINES (of 3 different types:  Left, Right and Left&Right):
 *          doLVerLine   (caller specifies a 3 or 4 for height)
 *          doRVerLine   (caller specifies a 3 or 4 or 8 or 9 for height)
 *          doLRVerLines (caller specifies a 3 or 4 or 7 for height)
 *      FOR A BLANK LINE:
 *          doBlankLine
 ******************************************************************************/

package bigdigits;

public class LineDrawers {
    // Prints 1 horizontal line with 8 * symbols
    public static void doHorLine() {
        System.out.println("********");
    }
        
    // Prints nRows horizontal lines with 1 * symbol followed by 7 spaces
    public static void doLVerLine(int nRows) {
        for (int i = 1; i <= nRows; i++) {
            System.out.println("*       ");
        }
    }
        
    // Prints nRows horizontal lines with 7 spaces followed by 1 * symbol
    public static void doRVerLine(int nRows) {
        for (int i = 1; i <= nRows; i++) {
            System.out.println("       *");
        }
    }
        
    // Prints nRows horizontal lines with 1 * symbol, 6 spaces, and 1 * symbol
    public static void doLRVerLine(int nRows) {
        for (int i = 1; i <= nRows; i++) {
            System.out.println("*      *");
        }
    }
        
    // Prints 1 blank line
    public static void doBlankLine() {
        System.out.println();
    }
}