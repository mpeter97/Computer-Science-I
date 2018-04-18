// CLASS:  Employee used by PROJECT:  EmployeeDB
// AUTHOR:  Matt Peter
// DESCRIPTION:  This class is used to store the 5 data values that represent
//               each employee.  It contains 3 different constructors, as well
//               as getter and setter methods for each of the variables.
//
//*****************************************************************************
package employeedb;

/**
 *
 * @author CAE User
 */
public class Employee {
    
    // Declare the five private variables that will be used with the data
    private String empID;           // Stores the Employee's ID number
    private String empName;         // Stores the Employee's name
    private String department;      // Stores the Employee's department
    private String startDate;       // Stores the Employee's start date
    private int earnings;           // Stores the Employee's earnings
    
    /*
     * Input: String, String, String, String, int
     * Output: None
     * Description: This method is a constructor given 4 String values and an int
     *              value.  These values are then assigned to the current Employee's
     *              private variables of empID, empName, department, startDate, and
     *              earnings, in that order.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:50p
     */
    public Employee (String empID, String empName, String department, String startDate, int earnings) {
        this.empID = empID;
        this.empName = empName;
        this.department = department;
        this.startDate = startDate;
        this.earnings = earnings;
    }
    
    /*
     * Input: String, String
     * Output: None
     * Description: This method is a constructor given 2 String values.  These
     *              values are then assigned to the current Employee's private
     *              variables of empID and empName, in that order, and the other
     *              variables are given values of "" or 0 (String and int).
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:53p
     */
    public Employee (String empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.department = "";
        this.startDate = "";
        this.earnings = 0;
    }
    
    /*
     * Input: None
     * Output: None
     * Description: This method is a constructor without any values passed.  All
     *              5 of the variables are given values of "" or 0 (String and int).
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:56p
     */
    public Employee () {
        this.empID = "";
        this.empName = "";
        this.department = "";
        this.startDate = "";
        this.earnings = 0;
    }
    
    /*
     * Input: String
     * Output: None
     * Description: This method sets the object's empID to the value that is passed.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:57p
     */
    public void setEmpID (String empID) {
        this.empID = empID;
    }
    
    /*
     * Input: String
     * Output: None
     * Description: This method sets the object's empName to the value that is passed.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:57p
     */
    public void setEmpName (String empName) {
        this.empName = empName;
    }
    
    /*
     * Input: String
     * Output: None
     * Description: This method sets the object's department to the value that is passed.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:57p
     */
    public void setDepartment (String department) {
        this.department = department;
    }
    
    /*
     * Input: String
     * Output: None
     * Description: This method sets the object's startDate to the value that is passed.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:57p
     */
    public void setStartDate (String startDate) {
        this.startDate = startDate;
    }
    
    /*
     * Input: int
     * Output: None
     * Description: This method sets the object's earnings to the value that is passed.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:57p
     */
    public void setEarnings (int earnings) {
        this.earnings = earnings;
    }
    
    /*
     * Input: None
     * Output: String
     * Description: This method returns the object's empID value.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:58p
     */
    public String getEmpID () {
        return this.empID;
    }
    
    /*
     * Input: None
     * Output: String
     * Description: This method returns the object's empName value.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:58p
     */
    public String getEmpName () {
        return this.empName;
    }
    
    /*
     * Input: None
     * Output: String
     * Description: This method returns the object's department value.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:58p
     */
    public String getDepartment () {
        return this.department;
    }
    
    /*
     * Input: None
     * Output: String
     * Description: This method returns the object's startDate value.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:58p
     */
    public String getStartDate () {
        return this.startDate;
    }
    
    /*
     * Input: None
     * Output: int
     * Description: This method returns the object's earnings value.
     * Author: Matthew Peter
     * Date/Time: 4/20/16 1:59p
     */
    public int getEarnings () {
        return this.earnings;
    }
}
