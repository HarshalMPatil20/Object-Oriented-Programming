class Parent {
    public Parent() {
        System.out.println("Parent Constructor");
    }

}

class Child extends Parent // Child inherited Parent
{
    public Child() {
        System.out.println("Child Constructor");
    }
}

class GrandChild extends Child // GrandChild inherited Child
{
    public GrandChild() {
        System.out.println("Grand Child Constructor");
    }
}

public class A_Constructors_In_Inheritance {

    public static void main(String[] args) {

//        Parent p = new Parent();
//        Parent p2 = new GrandChild();
//        Parent p3 = new Child();
//        Child c = new Child();
          GrandChild GC = new GrandChild();
    }

}