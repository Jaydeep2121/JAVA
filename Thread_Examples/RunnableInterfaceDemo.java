/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GargiShah
 */
class MultiThread implements Runnable
{
    public void run()
    {
        System.out.println("Thread Started");
        //System.out.println(this.currentThread());
    }
}
public class RunnableInterfaceDemo {
    public static void main(String[] args)
    {
        MultiThread m1 = new MultiThread();
        //m1.run();
        //m1.start();
        Thread t1 = new Thread(m1);
        t1.start();
    }
}
