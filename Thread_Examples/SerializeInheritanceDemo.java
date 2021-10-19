/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GargiShah
 */
import java.io.*;
class Stud implements Serializable
{
    int id;
    String name;
    Stud(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class Person extends Stud
{
    String course;
    int fee;
    Person(int id, String name, String course, int fee)
    {
        super(id,name);
        this.course = course;
        this.fee = fee;
    }
}
public class SerializeInheritanceDemo {
    public static void main(String[] args)
    {
        try
        {
            Person p = new Person(101,"XYZ","MCA",6000);
            Person p2[] = new Person[3];
            p2[0] = new Person(102,"ABC","MBA",5000);
            p2[1] = new Person(103,"PQR","MCA",6000);
            FileOutputStream fout = new FileOutputStream("D:\\JavaFiles\\SerializeInheritance.txt");
            ObjectOutputStream ot = new ObjectOutputStream(fout);
            ot.writeObject(p2[0]);
            ot.writeObject(p2[1]);
            ot.flush();
            ot.close();
            
            FileInputStream fin = new FileInputStream("D:\\JavaFiles\\SerializeInheritance.txt");
            ObjectInputStream oin = new ObjectInputStream(fin);
            Person p1 = (Person)oin.readObject();
            System.out.println("ID = " + p1.id + "\n Name = " + p1.name + "\n Course = " + p1.course + "\n fees = " + p1.fee);
            oin.close();
            fin.close();
     
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
