
class Parent
{
    int x;

    Parent()
    {
        System.out.println("Non-Parameterized Constructor of parent");
        System.out.println("x = " + x);
    }
    Parent(int x)
    {
        this.x = x;
        System.out.println("Parameterized Constructor of parent ");
        System.out.println("x = " + x);
    }
}

class Child extends Parent
{
    int y;
    Child()
    {
        System.out.println("Non-Parameterized Constructor of child");
        System.out.println("y = " + y);
    }
    Child(int y)
    {
        this.y = y;
        System.out.println("Parameterized Constructor of child");
        System.out.println("y = " + y);
    }
    Child(int x,int y)
    {
        super(x);
        System.out.println("Parameterized Constructor of child");
        System.out.println("y = " + y);
    }
}

public class B_Parameterized_constructors {

    public static void main(String[] args) {
        System.out.println("\n 1. Both are Non-parameterized");
        Child c1=new Child();

        System.out.println("\n 2. Child is parameterized but parent is Non-parameterized");
        Child c2=new Child(20);

        System.out.println("\n 3. Both are Parameterized");
        Child c3=new Child(10,20);
    }

}