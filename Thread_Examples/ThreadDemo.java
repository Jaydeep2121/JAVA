
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GargiShah
 */
class Multi extends Thread
{
    public void run()
    {
        System.out.println("Thread Running");
        System.out.println(this.currentThread());
        System.out.println(this.getName());
    }  
}
    
public class ThreadDemo 
{
    
    public static void main(String[] args)
    {
        Multi t1 = new Multi();
        Multi t2 = new Multi();
        t1.setName("First Thread");
        t2.setName("Second Thread");
        t1.start();
        t2.start();
        
    }
}
