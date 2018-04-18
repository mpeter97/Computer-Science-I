/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayfilesselectionsort;

import java.io.*;
import java.util.*;

/**
 *
 * @author CAE-User
 */
public class ArrayFilesSelectionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
        //printToFileNameAge("namesAges.txt");
        
        String[] ns = new String[20];
        int[] ag = new int[20];
        readFile("namesAges.txt", ns, ag);
        
        ArrayUtil au = new ArrayUtil();
        //au.printArrays(ns, ag);
        
        int minIndex;
        minIndex = au.findMin(0, ns.length - 1, ns);
        System.out.println("minIndex = " + minIndex + " minValue = " + ns[minIndex]);
        minIndex = au.findMin(0, ag.length - 1, ag);
        System.out.println("minIndex = " + minIndex + " minValue = " + ag[minIndex]);
        au.selectionSort(ns, ag);
        au.printArrays(ns, ag);
        au.selectionSort(ag, ns);
        au.printArrays(ns, ag);
    }
    
    public static void readFile (String s, String[] names, int[] ages) throws FileNotFoundException {
        
        File f = new File(s);
        Scanner s1 = new Scanner(f);
        int j = 0;
        while (s1.hasNext()) {
            names[j] = s1.next();
            ages[j] = s1.nextInt();
            j++;
        }
        
        s1.close();
    }
    
    public static void printToFileNameAge (String s) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(s);
        Random r = new Random();
        for (int i = 1; i <= 20; i++) {
            pw.println("name" + i + " " + (r.nextInt(10) + 50));
        }
        
        pw.close();
        
    }
    
}
