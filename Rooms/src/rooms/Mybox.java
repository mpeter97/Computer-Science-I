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
public class Mybox extends Rectangle {
    private double depth;

    public Mybox(double d){
        super();
        depth = d;  
    }
   
    public Mybox(){
        super();
        depth = 0;
    }
    
    public Mybox(double d, double l, double w){
        super(l, w); // use super
        depth = d;  
    }

    public double volume(){
        double vol;
        vol = getArea()*depth;
        return vol;
    }
    
    public String toString() {
        String s;
        s = super.toString() + " with depth " + depth;
        return s;
    }
}
