/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

/**
 *
 * @author CAE-User
 */
public class Circle {
    
    private int x;
    private int y;
    private double radius;
    public Circle(){
        x=y=0;
        radius = 0.0;
    }
   
    public Circle (double r){
        radius = r;
        x= 0;
        y=0;
    }
   
    public Circle (int xc, int yc, double r){
        x = xc;
        y = yc;
        radius = r;
    }

    public double getArea(){
        double area;
        area = Math.PI * radius*radius;
        return area;
    }

    public String toString(){
        return ("center at ("+x+", "+y+") with radius "+radius);
    }
    
    public int compareTo(Circle c) {
        // comparing the current ("this") object to the passed object c
        int retVal;
        if (this.radius < c.radius)
            retVal = -1;
        else if (this.radius == c.radius)
            retVal = 0;
        else
            retVal = 1;
        return retVal;
    }
}
