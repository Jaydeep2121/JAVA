/*
 We have to calculate the percentage of marks obtained in three subjects (each out of 100) by student A and in 
 four subjects (each out of 100) by student B. Create an abstract class 'Marks' with an abstract method 'getPercentage'. 
 It is inherited by two other classes 'A' and 'B' each having a method with the same name which returns the percentage of 
 the students. The constructor of student A takes the marks in three subjects as its parameters and the marks in four 
 subjects as its parameters for student B. Create an object for eac of the two classes and print the percentage of marks 
 for both the students
 */
import java.util.Scanner;
/**
 *
 * @author Jaydeep Chauhan
 */
abstract class marks{
    abstract float getPercentage();
}
class A extends marks{
    int a,b,c;
    A(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    float getPercentage(){
        float res=((a+b+c)/3);
        return res;
    }
}
class B extends marks{
    int a,b,c,d;
    B(int a,int b,int c,int d){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }
    float getPercentage(){
        float res=((a+b+c+d)/4);
        return res;
    }
}
public class abstract_keyw2 {
    public static void main(String[] args) {
        int arr[]=new int[4];
        Scanner sc = new Scanner(System.in);
            System.out.println("Enter the marks for student A:");
            for(int i=0;i<3;i++){
                arr[i]=sc.nextInt();
            }
            A a=new A(arr[0],arr[1],arr[2]);
            System.out.println("Enter the marks for student B:");
            for(int i=0;i<4;i++){
                arr[i]=sc.nextInt();
            }
            B b=new B(arr[0],arr[1],arr[2],arr[3]);
            for(int i=0;i<4;i++){
                System.out.println(arr[i]);
            }
            System.out.println("Percentage of StudentA:"+a.getPercentage()+"\n"+"Percentage of StudentB:"+b.getPercentage());
    }
}
