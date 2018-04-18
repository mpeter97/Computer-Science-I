/*
 * AUTHOR: Matt Peter
 */
package computeweeklypay;

import javax.swing.JOptionPane;

/**
 *
 * @author Matt Peter
 */
public class ComputeWeeklyPay {

    /**
     * @param args the command line arguments
     * This program collects the user's first and last name, the number of hours
     * they have worked, and their pay rate.  It then computes the user's gross
     * pay and displays the information to the user.
     */
    public static void main(String[] args) {
      
        String firstName, lastName, input;
        int hours;
        double payRate, grossPay;

      // Get the user's first name.
      firstName = 
         JOptionPane.showInputDialog("What is your first name?");
      
      // Get the user's last name.
      lastName = 
         JOptionPane.showInputDialog("What is your last name?");
      
      // Get the number of hours the user worked
      input = 
         JOptionPane.showInputDialog("How many hours did you work?");
      hours = Integer.parseInt(input);
      
      // Get the user's pay rate
      input = 
         JOptionPane.showInputDialog("What is your pay rate?");
      payRate = Double.parseDouble(input);
      
      // Compute the gross pay
      grossPay = hours * payRate;

      // Display a greeting
      JOptionPane.showMessageDialog(null, "Hello " + firstName + " "
                                    + lastName + "\nYour gross pay is $"
                                    + grossPay);
      System.exit(0);
    }
    
}
