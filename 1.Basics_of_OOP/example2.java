

class Student
{
    public int roll;
    public String name;
    public String course;
    public int m1,m2,m3;
    
    public int total()
    {
        return m1+m2+m3;
    }
    public float average()
    {
        return (float)total()/3;
    }
    public char grade()
    {
        if(average()>=60)
            return 'A';
        else
            return 'B';
    }

    //overriding toString() method
    //toString() method is used to get a string representation of an object
    //when we print an object, toString() method is called implicitly
    //we can override toString() method to get a string representation of our choice
    //toString() method is present in Object class
    
    @Override
    public String toString()
    {
        return "Roll No:"+roll+"\n"+"Name:"+name+"\n"+"Course:"+course+"\n";
    }
}

public class example2
{

    public static void main(String[] args) 
    {
        Student s=new Student();
        
        s.roll=1;
        s.name="John";
        s.course="CS";
        s.m1=70;
        s.m2=80;
        s.m3=65;
        
        System.out.println("Total :"+s.total());
        System.out.println("Average :"+s.average());
        
        System.out.println("Details:\n "+ s );
        
    }
    
}