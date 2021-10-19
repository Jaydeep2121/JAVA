/**
 *
 * @author Jaydeep Chauhan
 */

interface p{
    String p="pppp";
    String methodp();
}
interface q extends p{
    String q="qqqq";
    String methodq();
}
class m implements q{
    public String methodp(){
        return p+q;
    }
    public String methodq(){
        return q+p;
    }
}
public class interface_class {
    public static void main(String[] args) {
        m ob=new m();
        System.out.println(ob.methodp());
        System.out.println(ob.methodq());
    }
}
