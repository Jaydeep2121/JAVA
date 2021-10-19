/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GargiShah
 */
class Table1
{
    void printTable(int n)
    {
        System.out.println("Entered printTable Method " + this.toString());
        synchronized(this)
        {        
            for(int i=1;i<=5;i++)
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
        System.out.println("Out of synchronized block");
    }
}

class MyThread11 extends Thread
{
    Table1 t;
    MyThread11(Table1 t)
    {
        this.t=t;
    }
    public void run()
    {
        t.printTable(5);
    }
    
}

class MyThread22 extends Thread
{
    Table1 t;
    MyThread22(Table1 t)
    {
        this.t=t;
    }
    
    public void run()
    {
        
        t.printTable(50);
    }
    
}

    
    

public class SynchronizedBlockDemo {
    public static void main(String[] args)
    {
        Table1 obj = new Table1();
        MyThread11 t1 = new MyThread11(obj);
        MyThread22 t2 = new MyThread22(obj);
        t1.start();
        t2.start();
        
    }
}
