/*
Create an abstract class 'Parent' with a method 'message'. It has two subclasses each having a method with the same name 
'message' that prints "This is first subclass" and "This is second subclass" respectively. Call the methods 'message' by 
creating an object for each subclass.
 */

/**
 *
 * @author Jaydeep Chauhan
 */
abstract class parent{
    abstract void message();
}
class a extends parent{
    void message(){
        System.out.println("This is first subclass");
    }
}
class b extends parent{
    void message(){
        System.out.println("This is second subclass");
    }
}
public class abstract_keyw {
    public static void main(String[] args) {
        a ob=new a();
        ob.message();
        b ob1=new b();
        ob1.message();
    }
}
