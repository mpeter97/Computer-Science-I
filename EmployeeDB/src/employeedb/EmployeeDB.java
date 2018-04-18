// PROJECT:  EmployeeDB
// AUTHOR:  Matt Peter
// DATE:  4/20/2016
// LAB SECTION:  Wed. 6:30-8:20p
// DESCRIPTION:  This program allows the user to quickly access different categories
//               of data from a spreadsheet document (.csv).  After an array of objects
//               that will be used to store this data is created, the EmpQuery class
//               is used to go through all of the data on the spreadsheet and assign
//               it to the correct variable for each object created.  The user is then
//               able to have different sets of data calculated and shown based
//               on which option they choose in the main menu.
//
//*****************************************************************************
package employeedb;

import java.io.*;

/**
 *
 * @author CAE User
 */
public class EmployeeDB {

    public static void main (String[] args) throws IOException {
        
        // Create a constant int variable that holds the size of the Employee array
        final int MAX_SIZE = 50;
        
        // Create an array of Employee objects and set each one to new Employee
        Employee[] employee = new Employee[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++)
            employee[i] = new Employee();
        
        // Create a EmpQuery object and run the createDatabase method (assigning 
        //   the returned value to a newly instantiated int, N)
        EmpQuery query = new EmpQuery();
        int N = query.createDatabase(employee);
        
        // Get user input by using the showMenu method through the EmpQuery object
        int input = query.showMenu();
        
        // Enter a while loop that will run until the user enters the value -1
        while (input != -1) {
            // Use a switch statement to decide what data to show based on the user's input
            switch (input) {
                case 1:
                    query.showDataForEmp(employee, N);
                    break;
                case 2:
                    query.showAllEmpDept(employee, N);
                    break;
                case 3:
                    query.showAllEmpAccordingEarning(employee, N);
                    break;
                case 4:
                    query.showTotalEmpEarningsForDepartment(employee, N);
                    break;
                case 5:
                    query.showTotalEmpEarnings(employee, N);
                    break;
                case 6:
                    query.showEarningsSpread(employee, N);
                    break;
                case 7:
                    query.showEarningsSpreadForDepartment(employee, N);
                    break;
            }
            
            // Keep getting user input until the user enters -1
            input = query.showMenu();
        }
    }
    
}
