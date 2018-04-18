// CLASS:  EmpQuery used by PROJECT:  EmployeeDB
// AUTHOR:  Matt Peter
// DESCRIPTION:  This class is used to print out results that are requested
//               by the user in the main method, as well as create the database
//               to be used in the program, and display a menu that the user
//               can choose options from.
//
//*****************************************************************************
package employeedb;

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

/**
 *
 * @author CAE User
 */
public class EmpQuery {
    
    // Declare and Instantiate a DecimalFormat object that will be used to
    //   give the earnings values a better look
    static DecimalFormat money = new DecimalFormat("$#,##0.00");
    
    /*
     * Input: Employee[], int
     * Output: None
     * Description: This method prints out information about the employee who's
     *              name the user entered.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 2:41p
     */
    public void showDataForEmp(Employee[] emp, int n) {
        
        // Declare and Instantiate a Scanner object
        Scanner s = new Scanner (System.in);
        
        // Have the user enter the employee's name
        System.out.print("Please enter the employee's name: ");
        String name = s.nextLine();
        
        // Print out the data about the employee the user entered
        System.out.println("\n*************************");
        
        for (int i = 0; i < n; i++) {
            if (name.equals(emp[i].getEmpName())) {
                System.out.println("ID: " + emp[i].getEmpID());
                System.out.println("Name: " + emp[i].getEmpName());
                System.out.println("Department: " + emp[i].getDepartment());
                System.out.println("Start Date: " + emp[i].getStartDate());
                System.out.println("Earnings: " + money.format(emp[i].getEarnings()));
            }
        }
        
        System.out.println("*************************\n");
    }
    
    /*
     * Input: Employee[], int
     * Output: None
     * Description: This method prints out information about all the employees
     *              that work in the department the user entered.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 2:38p
     */
    public void showAllEmpDept(Employee[] emp, int n) {
        
        // Declare and Instantiate a Scanner object
        Scanner s = new Scanner (System.in);
        
        // Have the user enter the department they want the employee information for
        System.out.print("Please enter the department: ");
        String department = s.nextLine();
        
        // Print out the data about all the employees that work in the department
        //   the user entered
        System.out.print("\n*************************");
        
        for (int i = 0; i < n; i++) {
            if (department.equals(emp[i].getDepartment())) {
                System.out.println();
                System.out.println("ID: " + emp[i].getEmpID());
                System.out.println("Name: " + emp[i].getEmpName());
                System.out.println("Department: " + emp[i].getDepartment());
                System.out.println("Start Date: " + emp[i].getStartDate());
                System.out.println("Earnings: " + money.format(emp[i].getEarnings()));
            }
        }
        
        System.out.println("*************************\n");
    }
    
    /*
     * Input: Employee[], int
     * Output: None
     * Description: This method prints out information about all the employees
     *              that have an earnings value that is greater than or equal
     *              to the entered amount.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 2:36p
     */
    public void showAllEmpAccordingEarning(Employee[] emp, int n) {
        
        // Declare and Instantiate a Scanner object
        Scanner s = new Scanner (System.in);
        
        // Have the user enter a minimum earnings ammount
        System.out.print("Please enter a minimum earnings amount: ");
        int earnings = s.nextInt();
        
        // Print out the data about all the employees that had an earnings
        //   value that was greater than or equal to the one the user entered
        System.out.print("\n*************************");
        
        for (int i = 0; i < n; i++) {
            if (emp[i].getEarnings() >= earnings) {
                System.out.println();
                System.out.println("ID: " + emp[i].getEmpID());
                System.out.println("Name: " + emp[i].getEmpName());
                System.out.println("Department: " + emp[i].getDepartment());
                System.out.println("Start Date: " + emp[i].getStartDate());
                System.out.println("Earnings: " + money.format(emp[i].getEarnings()));
            }
        }
        
        System.out.println("*************************\n");
    }
    
    /*
     * Input: Employee[], int
     * Output: None
     * Description: This method prints out the total employee earnings for a
     *              specific department.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 2:33p
     */
    public void showTotalEmpEarningsForDepartment(Employee[] emp, int n) {
        
        // Declare and Instantiate a Scanner object
        Scanner s = new Scanner (System.in);
        
        // Have the user enter the department they want the total earnings for
        System.out.print("Please enter the department: ");
        String department = s.nextLine();
        
        // Declare and Instantiate an int value that will be used to store the total
        int total =  0;
        
        // Find the total of all the employee's earnings in the respective department
        for (int i = 0; i < n; i++) {
            if (department.equals(emp[i].getDepartment())) {
                total += emp[i].getEarnings();
            }
        }
        
        // Print out results
        System.out.println("\n*************************");
        System.out.println("Department: " + department);
        System.out.println("Total Earnings: " + money.format(total));
        System.out.println("*************************\n");
    }
    
    /*
     * Input: Employee[], int
     * Output: None
     * Description: This method prints out the total employee earnings
     * Author: Matthew Peter
     * Date/Time: 4/20/16 2:30p
     */
    public void showTotalEmpEarnings(Employee[] emp, int n) {
        
        // Declare and Instantiate a Scanner object
        Scanner s = new Scanner (System.in);
        
        // Declare and Instantiate an int value that will be used to store the total
        int total =  0;
        
        // Find the total of all the employee's earnings
        for (int i = 0; i < n; i++) {
            total += emp[i].getEarnings();
        }
        
        // Print out results
        System.out.println("\n*************************");
        System.out.println("Total Employee Earnings: " + money.format(total));
        System.out.println("*************************\n");
    }
    
    /*
     * Input: Employee[], int
     * Output: None
     * Description: This method prints out the difference between the maximum and
     *              minimum earnings throughout all of the departments.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 2:29p
     */
    public void showEarningsSpread(Employee[] emp, int n) {
        
        // Declare and Instantiate a Scanner object
        Scanner s = new Scanner (System.in);
        
        // Declare and Instantiate values that will be used to store the max and min
        int max = 0;
        int min = 1000000;
        
        // Find the maximum and minimum values
        for (int i = 0; i < n; i++) {
            if (emp[i].getEarnings() < min)
                min = emp[i].getEarnings();
            if (emp[i].getEarnings() > max)
                max = emp[i].getEarnings();
        }
        
        // Print out results
        System.out.println("\n*************************");
        System.out.println("Earnings Spread: " + money.format(max - min));
        System.out.println("*************************\n");
    }
    
    /*
     * Input: Employee[], int
     * Output: None
     * Description: This method asks for a department name from the user and
     *              prints out the difference between the maximum and minimum
     *              earnings in that department.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 2:27p
     */
    public void showEarningsSpreadForDepartment(Employee[] emp, int n) {
        
        // Declare and Instantiate a Scanner object
        Scanner s = new Scanner (System.in);
        
        // Have the user enter the department they want the earnings spread for
        System.out.print("Please enter the department: ");
        String department = s.nextLine();
        
        // Declare and Instantiate values that will be used to store the max and min
        int max = 0;
        int min = 1000000;
        
        // Find the maximum and minimum values
        for (int i = 0; i < n; i++) {
            if (department.equals(emp[i].getDepartment()) && emp[i].getEarnings() < min)
                min = emp[i].getEarnings();
            if (department.equals(emp[i].getDepartment()) && emp[i].getEarnings() > max)
                max = emp[i].getEarnings();
        }
        
        // Print out results
        System.out.println("\n*************************");
        System.out.println("Department: " + department);
        System.out.println("Earnings Spread: " + money.format(max - min));
        System.out.println("*************************\n");
    }
    
    /*
     * Input: None
     * Output: int
     * Description: This method displays a menu from which the user can choose
     *              what data they want the program to show, or enter the value -1
     *              to end the program.  The value that is entered is returned
     *              to the main method where the corresponding code is executed.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:25p
     */
    public int showMenu() {
        Scanner s = new Scanner (System.in);
        
        System.out.println("What data would you like?");
        System.out.println("\t1. Individual Employee Data");
        System.out.println("\t2. Department Employee Data");
        System.out.println("\t3. Earnings-based Employee Data");
        System.out.println("\t4. Total Employee Earnings for Department");
        System.out.println("\t5. Total Employee Earnings");
        System.out.println("\t6. Earnings Spread");
        System.out.println("\t7. Earnings Spread for Department");
        System.out.print("Enter value 1-7 (-1 to quit): ");
        
        int input = s.nextInt();
        return input;
    }
    
    /*
     * Input: Employee[]
     * Output: int
     * Description: This method takes the data from the "empDB_lab7.csv" file
     *              and assigns the values in each row to seperate Employee
     *              objects.  After it is done assigning all of the values
     *              for an object, it adds 1 to an int value that is then
     *              returned as the number of objects found in the file.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 2:15p
     */
    public int createDatabase(Employee[] emp) throws IOException {
        
        // Declare and Instantiate a File object and Scanner that will read
        //   data off of the "empDB_lab7.csv" file
        File f = new File ("empDB_lab7.csv");
        Scanner s = new Scanner (f);
        
        // Declare and Instantiate an int variable that will be used to keep track
        //   of the number of employees
        int n = 0;
        
        // Skip the first line since it is just a title line
        s.nextLine();
        
        // Enter a while loop that will continue to run as long as there is data to be read
        while (s.hasNext()) {
            // Declare and Instantiate a String, 2 ints, and a boolean variable
            String currentLine = s.nextLine();      // Stores the current line
            int start = 0;                          // Keeps track of where the value started
            int value = 1;                          // Keeps track of which value is being read
            boolean numStart = false;               // Tells if the earnings value is being read
            
            // Enter a for loop that will read the current line
            for (int i = 0; i < currentLine.length(); i++) {
                // If a symbol is found that indicates the start/end to a value,
                //   use the switch statement to find out what should be done
                if ((currentLine.charAt(i) == ',' && numStart == false) || currentLine.charAt(i) == '$'
                                                    || (currentLine.charAt(i) == '.' && numStart == true)) {
                    switch (value) {
                        case 1:
                            // The first value is stored in the empID variable
                            emp[n].setEmpID(currentLine.substring(start, i));
                            start = i + 1;
                            value++;
                            break;
                        case 2:
                            // The second value is stored in the empName variable
                            emp[n].setEmpName(currentLine.substring(start, i));
                            start = i + 1;
                            value++;
                            break;
                        case 3:
                            // The third value is stored in the department variable
                            emp[n].setDepartment(currentLine.substring(start, i));
                            start = i + 1;
                            value++;
                            break;
                        case 4:
                            // The fourth value is stored in the startDate variable
                            emp[n].setStartDate(currentLine.substring(start, i));
                            value++;
                            break;
                        case 5:
                            // The fifth value indicates the start to the earnings variable
                            start = i + 1;
                            value++;
                            numStart = true;
                            break;
                        case 6:
                            // The sixth value indicates the end to the earnings variable
                            String temp = currentLine.substring(start, i);
                            String afterTemp = "";
                            
                            // Any commas are taken out of the earnings String
                            for (int j = 0; j < temp.length(); j++) {
                                if (temp.charAt(j) == ',')
                                    j++;
                                afterTemp += temp.charAt(j);
                            }
                            
                            // The resulting String is then stored as an int value
                            emp[n].setEarnings(Integer.parseInt(afterTemp));
                    }
                }
            }
            // When a line is finished being read, increment the total number of employees
            n++;
        }
        
        // Close the Scanner when finished
        s.close();
        
        // Return the number of employees
        return n;
    }
}
