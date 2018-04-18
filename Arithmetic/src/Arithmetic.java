/* PROJECT:  Arithmetic
 * AUTHOR:  Donna Kaminski
 * DESCRIPTION:  This demonstrates:
 *  - the 5 arithmetic operators.
 *      - The - and * work as you'd expect.
 *      - The + works as expected as "add" if the 2 operands are numeric.
 *          But if the operands are strings, then + is "concatenate".
 *      - The / gives an INTEGER answer if both the operands are int's,
 *          and the result is TRUNCATED, NOT ROUNDED.
 *          If you want a FLOATING POINT NUMBER answer, then one or both of the
 *              operands needs to be a DOUBLE data type.  If neither one IS,
 *              then this can be "forced" by "casting one operand to a double".
 *      - The % is the MOD operator - that is, the INTEGER REMAINDER after
 *              doing INTEGER DIVIDE.   (NOTE:  It's a good way to test if an
 *              integer is an ODD number or an EVEN number).
 *  - the order of precedence and how ( ) is used to change this is:
 *          highest priority:  UNIARY -
 *          next priority:  *  /  %  (of equal priority, from left to right)
 *          lowest priority:  +  -  (of equal priority, from left to right)
 * 
 * QUESTION:  What is the order or precedence for the = operator
 *      (i.e., the assignment operator) relative to the arithmetic operators?
 * ANSWER: LOWEST PRIORITY (good thing)
 *      So the arithmetic on the right side gets completed BEFORE the final
 *          answer is stored in the left-side answer variable.
 ****************************************************************************/

public class Arithmetic {

    public static void main(String[] args) {

       //                          THESE 1st 2 CALCULATIONS USE:
            //                          1) STORE CALCULATION RESULTS IN answer
            //                          2) THEN USE THE STORED answer
            int answer;

            answer = 2 + 4 * 10;                    
            System.out.println("2 + 4 * 10 is " + answer);

            answer = (2 + 4) * 10;
            System.out.println("(2 + 4) * 10 is " + answer);

            //                          THE REST OF THE CALCULATIONS USE:
            //                          1) CALCULATE RESULTS & USE IMMEDIATELY
            //                              WITHOUT STORING IT
            System.out.println("1000 / 100 * 4 is " + (1000 / 100 * 4));

            System.out.println("1000 / (100 * 4) is " + (1000 / (100 * 4)));

            System.out.println();
            System.out.println("7 / 2 is " + (7 / 2) + " (integer divide)");

            System.out.println("6 / 2 is " + (6 / 2) + " (integer divide)");
            
            System.out.println();
            
            double var1;
            var1 = 7.0 / 2.0;
            System.out.println("7.0 / 2.0 is " + var1 +
                    " (floating-point divide)");
            
            double var2;
            var2 = 7 / 2.0;
            System.out.println("7 / 2.0 is " + var2);
            
            double var3;
            var3 = 7.0 / 2;
            System.out.println("7.0 / 2 is " + var3);

            System.out.println("\n7 % 2 is " + (7 % 2) + " (so it is ODD)");

            System.out.println("6 % 2 is " + (6 % 2) + " (so it is EVEN)");

            //                          THE + OPERATOR IS AN "OVERLOADED OPERATOR".
            //                          - IT'S "ADD" FOR 2 NUMERIC OPERANDS
            //                          - IT'S "CONCATENATE" IF THERE'S A STRING
            //                                  OPERAND

            System.out.println("\n24 + 45 (+ is \"concatenate\"): " + 24 + 45);
            System.out.println("(24 + 45) (+ is \"add\"): " + (24 + 45));

            int someNumber = 123456789;
            System.out.println("\nHere is someNumber: " + someNumber);
            System.out.println(someNumber + " - that was someNumber");
            System.out.println(someNumber + someNumber +
                    " - those were 2 numbers ADDED together");
    }
}
