-/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GargiShah
 */
class SleepThread extends Thread
{
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println(this.getName());
            System.out.println(i);
            try
            {
                Thread.sleep(500);
                
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}
public class SleepDemo {
    public static void main(String[] args)
    {
        SleepThread t1 = new SleepThread();
        SleepThread t2 = new SleepThread();
        t1.start();
        t2.start();
    }
}
