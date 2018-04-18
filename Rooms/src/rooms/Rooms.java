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
public class Rooms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle r;
        r = new Rectangle();

        roomDim(r);

        double x = 5.0;
        r.setLength(x);
        roomDim(r);
        System.out.println("perimeter is "+r.perimeter());

        Rectangle r2 = new Rectangle(3.4, 5.6);
        roomDim(r2);

        Rectangle r3 = new Rectangle(10);
        System.out.println("area = "+r3.getArea());

        Rectangle[] rs = new Rectangle[3];
        rs[0] = r;
        rs[1] = r2;
        rs[2] = r3;
        
        System.out.println("Number of instances = " + r.instance);

        for (int i = 0; i< 3; i++){
            roomDim(rs[i]);
        }

        Circle[] cs = new Circle[4];
        cs[0] = new Circle(5);
        cs[1] = new Circle();
        cs[2] = new Circle(1, 2, 10);
        cs[3] = cs[1];

        for (Circle c:cs){
            System.out.println(c);
        }
        
        System.out.println("comparing two circles:");
        if (cs[2].compareTo(cs[0]) == 1)
            System.out.println("the first circle is larger");

        for (Rectangle z:rs)
            System.out.println(z);

        Mybox m1 = new Mybox(10, 12, 8);
        Mybox m2 = new Mybox();
        
        System.out.println(m1);
        System.out.println(m2);
        
        Cube c1 = new Cube(4);
        System.out.println("my cube has " + c1);
        
        Rectangle r10;
        
        r10 = new Rectangle();
        r10 = new Mybox(1, 2, 3);
        r10 = new Cube(7);
        r10 = c1;
        
    }
    
    public static void roomDim(Rectangle y){
        System.out.println("room dimensions are "+y.getLength()+ " X "+y.getWidth());
    }
    
}
