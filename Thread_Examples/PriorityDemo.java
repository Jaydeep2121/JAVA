/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GargiShah
 */
class MultiPriority extends Thread
{
    public void run()
    {
        System.out.println("Current Thread Name : " + this.getName() + "\n Priority = " + this.getPriority());
        for(int i=1;i<=5;i++)
        {
            System.out.println(i);
        }
    }
}
public class PriorityDemo {
    public static void main(String[] args)
    {
        MultiPriority m1 = new MultiPriority();
        MultiPriority m2 = new MultiPriority();
        MultiPriority m3 = new MultiPriority();
               
        m1.setPriority(Thread.MIN_PRIORITY);
        m2.setPriority(Thread.MAX_PRIORITY);
        m3.setPriority(7);
        
        m1.start();
        m2.start();
        m3.start();
    } 
}
