

class Rectangle
{
    private double length;
    private double breadth;
    
    //"get" and "set" methods are used to access the private variables of the class.
    public double getLength()
    {
        return length;
    }
    
    public double getBreadth()
    {
        return breadth;
    }
    
    public void setLength(double l)
    {
        if(l>=0)
            length=l;
        else
            length=0;
    }
    
    public void setBreadth(double b)
    {
        if(b>=0)
            breadth=b;
        else 
            breadth=0;
    }
    
    //methods to calculate area, perimeter and to check if it is a square
    public double area()
    {
        //return length*breadth;

        //or

        //you can use getLength() and getBreadth() methods to access the private variables
        return getLength()*getBreadth();
    }
    
    public double perimeter()
    {
        return 2*(length+breadth);
    }
    
    public boolean isSquare()
    {
        if(length==breadth)
            return true;
        else 
            return false;
    }
}
        

public class example3 {

    public static void main(String[] args) {
        Rectangle r=new Rectangle();
        r.setLength(10.5);//check with negative values.
        r.setBreadth(5.5);
        
        System.out.println("Area "+r.area());
        System.out.println("Perimeter "+r.perimeter());
        System.out.println("Is Square "+r.isSquare());
        
        System.out.println("Length "+r.getLength());
        System.out.println("Breadth "+r.getBreadth());
    }
    
}