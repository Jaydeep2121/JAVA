/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.InetAddress;
/**
 *
 * @author Jaydeep Chauhan
 */
public class InetAddressDemo {
    public static void main(String[] args)
    {
        try
        {
            InetAddress ip=InetAddress.getByName("www.google.com");
            System.out.println("Host Name: "+ip.getHostName());
            System.out.println("IP Address: "+ip.getHostAddress());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
