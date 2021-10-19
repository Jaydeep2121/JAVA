/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaydeep Chauhan
 */
class employee{
    private int id,age;
    private String name;
    
    public void setid(int id){
        this.id=id;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setage(int age){
        this.age=age;
    }
    public int getid(){
        return id;
    }
    public String getname(){
        return name;
    }
    public int getage(){
        return age;
    }
}
public class private_class_example {
    public static void main(String[] args) {
        employee e=new employee();
        e.setid(1);
        e.setname("Ghanshyam Pandav");
        e.setage(20);
        System.out.println("id :"+e.getid()+"\n"+"Name :"+e.getname()+"\n"+"Age :"+e.getage());
    }
}
