/*
 Create an abstract class 'Bank' with an abstract method 'getBalance'. $100, $150 and $200 are deposited in banks 
 A, B and C respectively. 'BankA', 'BankB' and 'BankC' are subclasses of class 'Bank', each having a method named 
'getBalance'.Call this method by creating an object of each of the three classes
 */
/**
 *
 * @author Jaydeep Chauhan
 */
abstract class bank{
    abstract void getBalance();
}
class BankA extends bank{
    void getBalance(){
        System.out.println("Balance of bankA is $100");
    }
}
class BankB extends bank{
    void getBalance(){
        System.out.println("Balance of bankB is $150");
    }
}
class BankC extends bank{
    void getBalance(){
        System.out.println("Balance of bankC is $200");
    }
}
public class abstract_keyw1 {
    public static void main(String[] args) {
        BankA obj_a=new BankA();BankB obj_b=new BankB();BankC obj_c=new BankC();
        obj_a.getBalance();obj_b.getBalance();obj_c.getBalance();
    }
}
