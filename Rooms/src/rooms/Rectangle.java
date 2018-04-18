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
public class Rectangle {
    private double length;
    private double width;
    public int instance = 0;

    /**
     * Constructor
     */

    public Rectangle()
    {
        length = 0.0;
        width = 0.0;
        instance++;
    }

    /**
     * Overloaded constructor
     */

    public Rectangle(double len, double w)
    {
        length = len;
        width = w;
        instance++;
    }

    public Rectangle (double side){
        length = width = side;
        instance++;
    }

    /**
     * The setLength method accepts an argument
     * which is stored in the length field. 
     */

    public void setLength(double len)
    {
        length = len;
    }

    /**
     * The setWidth method accepts an argument 
     * which is stored in the width field.
     */

    public void setWidth(double w)
    {
        width = w;
    }

    /**
     * The set method accepts two arguments    
     * which are stored in the length and width
     * fields. 
     */

    public void set(double len, double w)
    {
        length = len;
        width = w;
    }

    /**
     * The getLength method returns the value   
     * stored in the length field.  
     */

    public double getLength()
    {
        return length;
    }

    /**
     * The getWidth method returns the value    
     * stored in the width field.
     */

    public double getWidth()
    {
        return width;
    }

    /**
     * The getArea method returns the value of the 
     * length field times the width field.
     */

    public double getArea()
    {
        return length * width;
    }

    //find perimeter
    public double perimeter(){
        return (2*length+2*width);
    }

    public String toString(){
        String s;
        s = "rectangle dimensuions are "+length+" X "+width;
        return s;
    }
}
