/*
 * To change this license header, choose License Headers in Project
Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GargiShah
 */
class Customer{
        int amount = 10000;

        synchronized void withdraw(int amount){
            System.out.println("Withdraw process start");
            if(this.amount < amount){
                System.out.println("Not enough balance : wait to deposit money");
                try{
                     wait();
                }catch(Exception e){
                     System.out.println(e);
                }
            }
            this.amount = this.amount - amount;
            System.out.println("Withdraw Complete : Current Balance = " +amount);
        }

        synchronized void deposit(int amount){
            System.out.println("Start deposit process");
            this.amount = this.amount + amount;
            System.out.println("Deposit complete : Current Balance = " +amount);
            notify();
        }
}
class CustWithdraw extends Thread{
       Customer C;
       CustWithdraw(Customer C){
            this.C=C;
       }
       public void run(){
            C.withdraw(15000);
       }
}
class CustDeposit extends Thread{
       Customer C;
       CustDeposit(Customer C){
            this.C=C;
        }
        public void run(){
            C.deposit(10000);
        }
}
public class InterThreadCommunicationDemo {
        public static void main(String[] args){
                Customer C1 = new Customer();
                CustWithdraw cw = new CustWithdraw(C1);
                CustDeposit cd = new CustDeposit(C1);

                cw.start();
                cd.start();
        }
}
