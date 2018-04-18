/*
 * AUTHOR: Matt Peter
 * CLASS: CS 1110 MW 4:00p - 5:15p
 * ASSIGNMENT: In Class Activity 3
 * DESCRIPTION: This program will get several grades from the user and
 *              make each of those grades a percentage of the user's overall
 *              score.  It will then display the overall score and ask the
 *              user if he/she wants to input any more scores.
 */
package inclassactivity3;

import java.util.Scanner;

/**
 *
 * @author AUTHOR: Matt Peter
 */
public class InClassActivity3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double la1, la2, inclassActivity1, exam1, exam2, overallScore;
        final double la1Percent = 20.0,
                     la2Percent = 20.0,
                     inclassActivity1Percent = 10.0,
                     exam1Percent = 20.0,
                     exam2Percent = 30.0;
        String response;
        
        Scanner keyboard = new Scanner(System.in);
        
        do {
            // Obtain all the scores from the user
            System.out.print("Please enter your la1 score: ");
            la1 = keyboard.nextDouble();
        
            System.out.print("Please enter your la2 score: ");
            la2 = keyboard.nextDouble();
        
            System.out.print("Please enter your inclassActivty1 score: ");
            inclassActivity1 = keyboard.nextDouble();
        
            System.out.print("Please enter your exam1 score: ");
            exam1 = keyboard.nextDouble();
        
            System.out.print("Please enter your exam2 score: ");
            exam2 = keyboard.nextDouble();
            
            // Compute the overall score
            overallScore = ((la1 * la1Percent) + (la2 * la2Percent) +
                            (inclassActivity1 * inclassActivity1Percent) +
                            (exam1 * exam1Percent) + (exam2 * exam2Percent)) / 100.0;
            
            // Print the score using the findLetterGrade(double) function
            System.out.println("Your overall letter grade is " +
                               findLetterGrade(overallScore));
            
            // See if the user would like to input more scores
            System.out.print("Would you like to compute another overall grade? ");
            response = keyboard.next();
            System.out.println();
        } while (response.charAt(0) == 'Y' || response.charAt(0) == 'y');
    }
    
    /*
     * DESCRIPTION: Figures out what the letter equivalent of the percentage
     *              score that is passed is.
     */
    public static String findLetterGrade(double score) {
        // Figure out what the letter equivalency of the percent score is
        String letterGrade;
        if (score < 60)
            letterGrade = "E";
        else if (score < 65)
            letterGrade = "D";
        else if (score < 70)
            letterGrade = "DC";
        else if (score < 75)
            letterGrade = "C";
        else if (score < 80)
            letterGrade = "CB";
        else if (score < 85)
            letterGrade = "B";
        else if (score < 90)
            letterGrade = "BA";
        else
            letterGrade = "A";
        return letterGrade;
    }
    
}
