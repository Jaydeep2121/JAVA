/*
 Create an abstract class 'Animals' with two abstract methods 'cats' and 'dogs'. Now create a class 'Cats' with a method 
 'cats' which prints "Cats meow" and a class 'Dogs' with a method 'dogs' which prints "Dogs bark", both inheriting the class 
 'Animals'. Now create an object for each of the subclasses and call their respective methods.
 */

/**
 *
 * @author Jaydeep Chauhan
 */
abstract class Animal{
    abstract void cats();
    abstract void dogs();
}
class cats extends Animal{
    void cats(){
        System.out.println("Cats meow");
    }

    @Override
    void dogs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
class dogs extends Animal{
    void dogs(){
        System.out.println("Dogs bark");
    }

    @Override
    void cats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
public class abstract_keyw3 {
    public static void main(String[] args) {
        cats c=new cats();dogs d=new dogs();
        c.cats();d.dogs();
    }
}
