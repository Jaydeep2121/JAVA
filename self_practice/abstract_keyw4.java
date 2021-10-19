/*
We have to calculate the area of a rectangle, a square and a circle. Create an abstract class 'Shape' with three abstract 
methods namely 'RectangleArea' taking two parameters, 'SquareArea' and 'CircleArea' taking one parameter each. The parameters 
of 'RectangleArea' are its length and breadth, that of 'SquareArea' is its side and that of 'CircleArea' is its radius. Now 
create another class 'Area' containing all the three methods 'RectangleArea', 'SquareArea' and 'CircleArea' for printing the 
area of rectangle, square and circle respectively. Create an object of class 'Area' and call all the three methods
 */

/**
 *
 * @author Jaydeep Chauhan
 */
abstract class shape{
    abstract void RectangleArea(int le,int br);
    abstract void SquareArea(int sd);
    abstract void CircleArea(int rd);
}
class Area extends shape{
    void RectangleArea(int le, int br) {
        System.out.println("RectangleArea is :"+le*br);
    }

    void SquareArea(int sd) {
        System.out.println("SquareArea is :"+sd*sd);
    }

    void CircleArea(int rd) {
        System.out.println("CircleArea is :"+(3.14*rd*rd));
    }    
}
public class abstract_keyw4 {
    public static void main(String[] args) {
        Area a=new Area();
        a.RectangleArea(5, 10);
        a.SquareArea(6);
        a.CircleArea(7);
    }
}
