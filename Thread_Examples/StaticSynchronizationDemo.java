/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GargiShah
 */
class TableT{  
  
 synchronized static void printTable(int n)
 {  
    for(int i=1;i<=10;i++)
    {  
        System.out.println(n*i);  
        try
        {  
             Thread.sleep(400);  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }  
 }  
}  
class MyThreadT1 extends Thread
{  
    public void run()
    {  
        TableT.printTable(1);  
    }  
}  

class MyThreadT2 extends Thread
{  
    public void run()
    {  
        TableT.printTable(10);  
    }  
}  

class MyThreadT3 extends Thread
{  
    public void run()
    {  
        TableT.printTable(100);      
    }  
} 

class MyThreadT4 extends Thread
{  
    public void run()
    {  
        TableT.printTable(1000);  
    }  
}  
public class StaticSynchronizationDemo 
{
    public static void main(String[] args)
    {  
        MyThreadT1 t1=new MyThreadT1();  
        MyThreadT2 t2=new MyThreadT2();  
        MyThreadT3 t3=new MyThreadT3();  
        MyThreadT4 t4=new MyThreadT4();  
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();  
    }    
}
