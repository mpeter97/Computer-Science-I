/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayfilesselectionsort;

/**
 *
 * @author CAE-User
 */
public class ArrayUtil {
    
    public void printArrays (String[] s, int[] a) {
        System.out.println("\nPrint arrays");
        for (int i = 0; i < s.length; i++)
            System.out.printf("%6s %3d\n", s[i], a[i]);
    }
    
    public int findMin (int start, int end, String[] a) {
        String min = a[start];
        int indexOfMin = start;
        for (int j = start + 1; j <= end; j++) {
            if (min.compareTo(a[j]) > 0) {
                indexOfMin = j;
                min = a[j];
            }
        }
        return indexOfMin;
    }
    
    public int findMin (int start, int end, int[] a) {
        int min = a[start];
        int indexOfMin = start;
        for (int j = start + 1; j <= end; j++) {
            if (min > a[j]) {
                indexOfMin = j;
                min = a[j];
            }
        }
        return indexOfMin;
    }
    
    public void selectionSort(String[] s) {
        
        int minIndex;
        for (int i = 0; i < s.length; i++) {
            minIndex = findMin(i, s.length - 1, s);
            swap(i, minIndex, s);
        }
        
    }
    
    public void selectionSort(int[] a) {
        
        int minIndex;
        for (int i = 0; i < a.length; i++) {
            minIndex = findMin(i, a.length - 1, a);
            swap(i, minIndex, a);
        }
        
    }
    
    public void selectionSort(String[] s, int[] a) {
        
        int minIndex;
        for (int i = 0; i < s.length; i++) {
            minIndex = findMin(i, s.length - 1, s);
            swap(i, minIndex, s);
            swap(i, minIndex, a);
        }
        
    }
    
    public void selectionSort(int[] a, String[] s) {
        
        int minIndex;
        for (int i = 0; i < a.length; i++) {
            minIndex = findMin(i, a.length - 1, a);
            swap(i, minIndex, a);
            swap(i, minIndex, s);
        }
        
    }
    
    public void swap (int j, int k, String[] s) {
        String temp = s[j];
        s[j] = s[k];
        s[k] = temp;
    }
    
    public void swap (int j, int k, int[] s) {
        int temp = s[j];
        s[j] = s[k];
        s[k] = temp;
    }
}
