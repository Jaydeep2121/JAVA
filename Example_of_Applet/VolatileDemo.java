/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaydeep Chauhan
 */
class Demo
{
    volatile int count = 1;
    void display(Thread T)
    {
        try
        {
            for(int i=1;i<=5;i++)
            {
                System.out.println(Thread.currentThread() +
               "Count = " + count);
                count++;
                Thread.sleep(100);
            }
            //Thread.sleep(100);
            count++;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
class Th1 extends Thread
{
    Demo t;
    Th1(Demo t)
    {
        this.t=t;
    }
    public void run()
    {
        t.display(this);
    }

}
class Th2 extends Thread
{
    Demo t;
    Th2(Demo t)
    {
        this.t=t;
    }
    public void run()
    {
        t.display(this);
    }
}
public class VolatileDemo
{
    public static void main(String[] args)
    {
        Demo obj = new Demo();

        Th1 t1 = new Th1(obj);
        Th2 t2 = new Th2(obj);

        t1.start();
        t2.start();
    }
}
