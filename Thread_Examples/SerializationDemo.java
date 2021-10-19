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
class Student implements Serializable
{
   int id;
   String name;
   Student(int id,String name)
   {
       this.id = id;
       this.name =name;
   }
}
public class SerializationDemo {
    public static void main(String[] args)
    {
        try
        {
            Student s1 = new Student(3,"XYZ");
            FileOutputStream fout = new FileOutputStream("C:\\Users\\TS_Security\\Serialize1.txt");
            ObjectOutputStream os = new ObjectOutputStream(fout);
            os.writeObject(s1);
            os.flush();
            os.close();
            System.out.println("check file....");
            
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("C:\\Users\\TS_Security\\Serialize1.txt"));
            Student s = (Student)oi.readObject();
            System.out.println("ID = " + s.id + "\n" + "Name = " + s.name);
            oi.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
