/*
 [2]Create an application of simple calculator using Java AWT
*/

/**
 *
 * @author Jaydeep Chauhan
 */
import java.awt.*;
import java.awt.event.*;
public class Simple_Calculator extends Frame implements ActionListener{
    String s1,s2,s3;
    TextField t;
    Button on,tw,th,fr,fv,sx,svn,egt,nn,zr,add,min,mult,divide,eql,c,bk,dot;
    Simple_Calculator(){
        s1=s2=s3="";
        t=new TextField();
        t.setBounds(141,61,528,50);
        
        svn=new Button("7");
        svn.setBounds(141,129,90,50);
        egt=new Button("8");
        egt.setBounds(250,129,90,50);
        nn=new Button("9");
        nn.setBounds(359,129,90,50);
        divide=new Button("/");
        divide.setBounds(468,129,90,50);
        bk=new Button("<");
        bk.setBounds(577,129,90,50);
    
        fr=new Button("4");
        fr.setBounds(141,195,90,50);
        fv=new Button("5");
        fv.setBounds(250,195,90,50);
        sx=new Button("6");
        sx.setBounds(359,195,90,50);
        mult=new Button("*");
        mult.setBounds(468,195,90,50);
        c=new Button("C");
        c.setBounds(577,195,90,50);
        
        on=new Button("1");
        on.setBounds(141,261,90,50);
        tw=new Button("2");
        tw.setBounds(250,261,90,50);
        th=new Button("3");
        th.setBounds(359,261,90,50);
        min=new Button("-");
        min.setBounds(468,261,90,50);
        zr=new Button("0");
        zr.setBounds(141,325,200,50);
        dot=new Button(".");
        dot.setBounds(359,325,90,50);
        
        add=new Button("+");
        add.setBounds(468,327,90,50);
        eql=new Button("=");
        eql.setBounds(578,261,90,117);
        
        svn.addActionListener(this);
        egt.addActionListener(this);
        nn.addActionListener(this);
        divide.addActionListener(this);
        bk.addActionListener(this);
        fr.addActionListener(this);
        fv.addActionListener(this);
        sx.addActionListener(this);
        mult.addActionListener(this);
        c.addActionListener(this);
        on.addActionListener(this);
        tw.addActionListener(this);
        th.addActionListener(this);
        min.addActionListener(this);
        zr.addActionListener(this);
        add.addActionListener(this);
        eql.addActionListener(this);
        dot.addActionListener(this);
        
        add(t);add(svn);add(egt);add(nn);add(divide);
        add(bk);add(fr);add(fv);add(sx);add(mult);
        add(c);add(on);add(tw);add(th);add(min);
        add(zr);add(add);add(eql);add(dot);
        
        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }
        });
        setLayout(null);
        setVisible(true);
        setSize(700,700);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        int k=1;
        String s=e.getActionCommand();
        if((s.charAt(0)>='0' && s.charAt(0)<='9') || s.charAt(0)=='.' || s.charAt(0)=='<'){
                if(("".equals(s1) || "".equals(s2)) && s.charAt(0)!='<'){
                    s1+=s;
                    t.setText(s1);
                }else if(s.charAt(0)!='<'){
                    s3+=s;
                    t.setText(s3);
                }
                
                if((!s1.isEmpty() && s.charAt(0)=='<')){
                    s1 = s1.substring(0, s1.length() - k);k++;
                    t.setText(s1);
                }else if((!s3.isEmpty() && s.charAt(0)=='<')){
                    s3 = s3.substring(0, s3.length() - k);k++;
                    t.setText(s3);
                }else if(s1.isEmpty() && s.charAt(0)=='<' && s3.isEmpty()){
                    s1=s2=s3="";
                }
        }else if(s.charAt(0)=='+'||s.charAt(0)=='-'||s.charAt(0)=='*'||s.charAt(0)=='/'||s.charAt(0)=='C'){
            if(s.charAt(0)=='+'){
                s2="pls";
            }else if(s.charAt(0)=='-'){
                s2="min";
            }else if(s.charAt(0)=='*'){
                s2="mul";
            }else if(s.charAt(0)=='/'){
                s2="div";
            }else if(s.charAt(0)=='C'){
                s1=s2=s3="";
                t.setText("");
            }
        }else if(s2=="pls"||s2=="min"||s2=="mul"||s2=="div"){
            double ans=0.0;
            if(s2=="pls"){
                ans=Double.parseDouble(s1)+Double.parseDouble(s3);
            }else if(s2=="min"){
                ans=Double.parseDouble(s1)-Double.parseDouble(s3);
            }else if(s2=="mul"){
                ans=Double.parseDouble(s1)*Double.parseDouble(s3);
            }else if(s2=="div"){
                ans=Double.parseDouble(s1)/Double.parseDouble(s3);
            }
            t.setText(String.valueOf(ans));
        }
    } 
    public static void main(String[] args) {
        new Simple_Calculator();
    }
}
