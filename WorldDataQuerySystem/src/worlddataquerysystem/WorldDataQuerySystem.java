// PROJECT:  WorldDataQuerySystem
// AUTHOR:  Matt Peter
// LAB SECTION:  Wed. 6:30-8:20p
// DESCRIPTION:  This program allows the user to quickly access different categories
//               of data from a spreadsheet document (.csv).  After specific categories
//               of data have been read from the spreadsheet and stored in arrays,
//               the user can get stats for most of the categories including
//               the maximum, minimum, and average value.  The user can also get
//               all of the data about a specific country at once, or find out
//               all the countries that a certain continent contains.  Along with this,
//               a text document called "Log.txt" is stored in the project folder
//               which contains all of the data used in this project, sorted
//               alphabetically by country name.
//
// INPUT FILE DESCRIPTION (a .csv file)
//      NOTE:  string fields are enclosed in quotes, which need to be removed
//      EXTRA NON-DATA:  INSERT INTO `Country` VALUES (
//          to be discarded
//      [ONLY SOME OF THESE FIELDS ARE USED IN THIS PROJECT - SEE SPECS]
//              code,name,continent,region,landArea,indepYear,population,
//              lifeExpectancy,gnp  
//      OTHER FIELDS NOT USED IN THIS PROJECT
//*****************************************************************************
package worlddataquerysystem;

import java.io.*;                   // contains File class - use for any
                                    //      file-I/O classes/methods
import java.util.Scanner;           // same Scanner class methods (nextLine,...)
                                    //      used for reading from a FILE
                                    //      as when reading from the KEYBOARD

public class WorldDataQuerySystem {

    public static void main(String[] args) throws IOException {        
        
        // Declare and Instantiate an Object for the UserInteraction and Query classes
        UserInteraction UI = new UserInteraction();
        Query query = new Query();
        
        // Declare and Instantiate a constant value used to size all of the arrays
        final int MAX_N = 300;
        
        // Declare and Instantiate all of the arrays and an integer value
        String[] nameArray = new String[MAX_N];                 // Stores the names of the countries
        String[] continentArray = new String[MAX_N];            // Stores the continents of the countries
        int[] landAreaArray = new int[MAX_N];                   // Stores the land area of the countries
        long[] populationArray = new long[MAX_N];               // Stores the population of the countries
        double[] lifeExpectancyArray = new double[MAX_N];       // Stores the life expectancies of the countries
        int[] gnpArray = new int[MAX_N];                        // Stores the GNPs (Gross National Product) of the countries
        int N = 0;                                              // Stores the number of countries that are being analyzed
        
        // Call the introMessage() method in the UserInteraction class
        UI.introMessage();
        
        // Call the fillArrayData() method to collect all the needed data from the WorldData.csv file
        N = fillArrayData(nameArray, continentArray, landAreaArray,
                          populationArray, lifeExpectancyArray, gnpArray);
        
        // Sort all of the arrays based on nameArray (alphabetically)
        for (int i = 1; i < N; i++) {
            // Declare and Instantiate temporary variables used to sort arrays
            String tempValString = "";
            double tempValDouble = 0.0;
            int tempValInt = 0;
            long tempValLong = 0;
            double compareValue = 0.0;
            
            // This for loop keeps on checking to see if a country belongs earlier in the list (based on its name)
            for (int j = i - 1; j >= 0; j--) {
                // Get and store a value in compareValue using the compareTo method
                compareValue = nameArray[j].compareTo(nameArray[j+1]);
                
                if (compareValue > 0) {
                    // If compareValue is positive, the current name needs to be placed one spot earlier
                    //     (along with all the values that go with it)
                    
                    tempValString = nameArray[j+1];
                    nameArray[j+1] = nameArray[j];
                    nameArray[j] = tempValString;
                    
                    tempValString = continentArray[j+1];
                    continentArray[j+1] = continentArray[j];
                    continentArray[j] = tempValString;
                    
                    tempValInt = landAreaArray[j+1];
                    landAreaArray[j+1] = landAreaArray[j];
                    landAreaArray[j] = tempValInt;
                    
                    tempValLong = populationArray[j+1];
                    populationArray[j+1] = populationArray[j];
                    populationArray[j] = tempValLong;
                    
                    tempValDouble = lifeExpectancyArray[j+1];
                    lifeExpectancyArray[j+1] = lifeExpectancyArray[j];
                    lifeExpectancyArray[j] = tempValDouble;
                    
                    tempValInt = gnpArray[j+1];
                    gnpArray[j+1] = gnpArray[j];
                    gnpArray[j] = tempValInt;

                    
                } else {
                    // If compareValue is negative, the current name is in the correct position
                    break;
                    
                }
            }
        }
        
        // Declare an int variable that will be used for holding the user's selection
        int selection;
        
        // Enter into a do-while loop that will repeat until the user enters -1 to quit
        do {
            // Get the user's selection for data using the mainMenu method in the UserInteraction class
            selection = UI.mainMenu();
            
            // Enter into a switch statement that will use the user's response to figure out what
            //     method in the Query class needs to be executed
            switch (selection) {
                case 1:
                    query.showDataFor1Country(nameArray, continentArray, landAreaArray,
                                              populationArray, lifeExpectancyArray, gnpArray, N);
                    break;
                case 2:
                    query.showAllCountriesInContinent(nameArray, continentArray, N);
                    break;
                case 3:
                    query.showLifeExpStats(nameArray, continentArray, lifeExpectancyArray, N);
                    break;
                case 4:
                    query.showLandAreaStats(nameArray, continentArray, landAreaArray, N);
                    break;
                case 5:
                    query.showPopStats(nameArray, continentArray, populationArray, N);
                    break;
                case 6:
                    query.showGnpStats(nameArray, continentArray, gnpArray, N);
                    break;
                case 7:
                    query.showPopDensityStats(nameArray, continentArray, populationArray,
                                              landAreaArray, N);
                    break;
                case 8:
                    query.showGnpPerCapitaStats(nameArray, continentArray, gnpArray, populationArray, N);
                    break;
                case -1:
                    UI.endingMessage();
            }
        } while (selection != -1);
        
        // Print out the finished report on a separate file ("Log.txt")
        query.doReport(nameArray, continentArray, landAreaArray, populationArray,
                       lifeExpectancyArray, gnpArray, N);
        
    }
    
    /*
     * Input: String[], String[], int[], long[], double[], int[]
     * Output: int
     * Description: This method is given 6 arrays of data is input and returns
     *              an integer that keeps track of how many pieces of data
     *              all of the arrays contain.  After checking to make sure that
     *              there is still more data to be read, the method goes through
     *              and picks out each String, Integer, Long, or Double value that
     *              is located either between a pair of commas, or between a starting
     *              or ending symbol and a comma.  Once the start and end to a piece
     *              of data has been found in the line, depending on which piece of
     *              data it is (first, second, third, etc.), it is either placed
     *              in its appropriate array, or discarded.  After an entire line
     *              of data has been read, an integer variable is incremented by 1,
     *              to keep track of how many lines of data there are.  Once there
     *              are no more lines of text found, the end of the file is assumed
     *              to have been reached, and the variable that keeps track of how
     *              many lines were read is returned to the main method.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 1:23p
     */
    private static int fillArrayData(String[] name, String[] continent, int[] landArea,
                                     long[] population, double[] lifeExpectancy, int[] gnp) throws IOException {
        
        // Delcare and Instantiate the file being used ("WorldData.csv") and a Scanner for it
        File worldData = new File ("WorldData.csv");
        Scanner s = new Scanner (worldData);
        
        // Declare and Instantiate the needed variables
        String currentRow;          // Used to store the row from the data that is currently being analyzed
        int n = 0;                  // Keeps track of how many rows of data there are
        int start;                  // Used to record the beginning of a piece of data
        int end;                    // Used to record the end of a piece of data
        int field;                  // Used to keep track of which field of information is currently being read off the data sheet
        boolean fieldStarted;       // Used to tell whether or not a field is currently being read
        
        // Have the Scanner keep reading data while there is some to be read
        while (s.hasNext()) {
            // Get the next row of data from the spreadsheet and set variables to appropriate values
            currentRow = s.nextLine();
            start = -1;
            end = -1;
            field = 0;
            fieldStarted = false;
            
            // Enter into a for loop that will read each character from the current row of data
            for (int i = 0; i < currentRow.length(); i++) {
                // If the current character signifies the start of a new field, and a field isn't currently in
                //     the process of being recorded, signify and record the start of a new field
                if ((currentRow.charAt(i) == ',' || currentRow.charAt (i) == '(') && fieldStarted == false) {
                    start = i + 1;
                    fieldStarted = true;
                // Otherwise, if the character signifies the end of a field, record the end of a field
                } else if ((currentRow.charAt(i) == ',' || currentRow.charAt (i) == ';') && fieldStarted == true && i != start - 1) {
                    end = i;
                    fieldStarted = false;
                }
                // Check to see if a field is complete
                if (start != -1 && end != -1) {
                    // Enter into a switch statement that only assigns values of certain fields,
                    //     and modifies the values if need be
                    switch (field) {
                        case 1:
                            if (currentRow.charAt(start) == '\'')
                                start++;
                            if (currentRow.charAt(end - 1) == '\'')
                                end--;
                            name[n] = currentRow.substring(start, end);
                            break;
                        case 2:
                            if (currentRow.charAt(start) == '\'')
                                start++;
                            if (currentRow.charAt(end - 1) == '\'')
                                end--;
                            continent[n] = currentRow.substring(start, end);
                            break;
                        case 4:
                            landArea[n] = Integer.parseInt(currentRow.substring(start, end));
                            break;
                        case 6:
                            population[n] = Long.parseLong(currentRow.substring(start, end));
                            break;
                        case 7:
                            lifeExpectancy[n] = Double.parseDouble(currentRow.substring(start, end));
                            break;
                        case 8:
                            gnp[n] = Integer.parseInt(currentRow.substring(start, end));
                            break;
                    }
                    // Reset the values of start and end, and change the values of i and field
                    //     to prepare for a new field
                    start = -1;
                    end = -1;
                    i--;
                    field++;
                }
            }
            // Add one to n after the row is complete
            n++;
        }
        
        // Close the file
        s.close();
        
        return n;
    }
    
}
