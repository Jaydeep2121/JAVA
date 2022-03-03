/*
    Java JDBC Application
 */
package practicless;
import com.sun.jdi.connect.spi.Connection;

public class Practicless {
    public static void main(String[] args) {
        
        //try{
            class.forName("com.mysql.jdbc.Driver");
             //Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mca5","root","");
            /*
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery("select *from student");
                while(rs.next()){
                    System.out.println("id : "+rs.getInt("id"));
                    System.out.println("UserName :"+rs.getString("name"));
                    System.out.println("hobby :"+rs.getString("hobby")+"\n");
                }
            */
            //To make resutlset Read Only:
            /*
                Statement st=cn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs=st.executeQuery("select *from student");
                rs.absolute(3);
                System.out.println(rs.getString("name")+"\n"+rs.getString("email"));
            */
            //To make resutlset Updatable:
            /*
                Statement st=cn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs=st.executeQuery("select *from student");
                rs.absolute(5);
                rs.updateInt("id", 12);
                rs.updateString("password", "pratik123");
                rs.updateRow();
            */
            //To create a new record using resultset object:
            /*
                Statement st=cn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs=st.executeQuery("select *from student");
                rs.moveToInsertRow();
                rs.updateInt("id", 9);
                rs.updateString("name", "Nayna");
                rs.updateString("gender","female");
                rs.updateString("hobby","cricket");
                rs.updateString("email", "nayna67@gm.co");
                rs.updateString("password", "nayam234");
                rs.updateString("city","chennai");
                rs.insertRow();
            */
            //resultset to set the important method
            /*
                Statement st=cn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs=st.executeQuery("select *from student");
                rs.last(); //move to last record 4
                rs.first(); //go to first row 1
                rs.absolute(2); //go to row no 2 - it is with respect to beginning of result set
                rs.relative(-1); //relative to current record - go to row no 1
                rs.relative(1); //go to next to current - it goes to row no 2
                rs.absolute(-1); //go to last row 
                rs.absolute(-2); //go to second last row
                rs.beforeFirst(); // go to BOF
                rs.afterLast(); // go to EOF
                rs.last();
                rs.deleteRow();//deleting last record -> cursor will be at EOF
            */
            //to insert using statement object
            /*
                Statement st=cn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
                int rowaffected=st.executeUpdate("insert into student("
                        + "id,name,gender,hobby,email,password,city)"
                        + "values(9,'fenil','male','reading','fenvirani89@gm.co','fenil23','surat')");
                System.out.println("no of rows affected.."+rowaffected);
            
                Statement st=cn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
                int rowaffected=st.executeUpdate("update student set name='ravina',gender='female',"
                        + "hobby='reading',email='ravi78',password='123',city='surat' where id=9");
                System.out.println("no of rows affected.."+rowaffected);
            */
            //Create and Call Procedure
            /*
                CallableStatement cs=cn.prepareCall("{call add_stud('nayan','male','cricket','nayn45@gm.com','nayan34','banglore')}");
                if(cs.executeUpdate()==1){
                    System.out.println("Data Added..");
                }else{
                    System.out.println("Error At Insert");
                }
            */
            //What is distributed transaction?
            /*
                MysqlDataSource datasource = new MysqlDataSource();
                datasource.setServerName("localhost");
                datasource.setDatabaseName("mca5");
                datasource.setUser("root");
                datasource.setPassword("");
            
                Connection cn=datasource.getConnection();
                Statement st=cn.createStatement();
                String qry="select *from student";
                ResultSet rs=st.executeQuery(qry);
                while(rs.next()){
                    System.out.println("Name is :" + rs.getString("name") + "  Gen. is :" + rs.getString("gender"));
                }
            */
            //Datasource with connection Pooling
            /*
                MysqlConnectionPoolDataSource connectionpooldatasource = new MysqlConnectionPoolDataSource();
                connectionpooldatasource.setServerName("localhost");
                connectionpooldatasource.setDatabaseName("mca5");
                connectionpooldatasource.setUser("root");
                connectionpooldatasource.setPassword("");
            
                PooledConnection pcon = connectionpooldatasource.getPooledConnection();
                Connection cn = pcon.getConnection();
                Statement st=cn.createStatement();
                String qry="select *from student";
                ResultSet rs=st.executeQuery(qry);
                while(rs.next()){
                    System.out.println("Name is :" + rs.getString("name") + "  Gen. is :" + rs.getString("gender"));
                }
            */
            //Creating RowSet from RowSet Factory
            /*
                RowSetFactory rsfact=RowSetProvider.newFactory();
            
                JdbcRowSet jdbcrowset=rsfact.createJdbcRowSet(); //connected rowset -jdbc
                jdbcrowset.setUrl("jdbc:mysql://localhost:3306/mca5?");
                jdbcrowset.setUsername("root");
                jdbcrowset.setPassword("");
                jdbcrowset.setCommand("select *from student");
                jdbcrowset.execute();
            
                while(jdbcrowset.next()){
                    System.out.println("Name is :" + jdbcrowset.getString("name") + "  Gen. is :" + jdbcrowset.getString("gender"));
                }
            */
            //webrowset (disconnected) from rowsetfactory
            /*
            RowSetFactory rsfact=RowSetProvider.newFactory();
            WebRowSet mywebrowset = rsfact.createWebRowSet();
            mywebrowset.setUrl("jdbc:mysql://localhost:3306/mca5?");
            mywebrowset.setUsername("root");
            mywebrowset.setPassword("");
            mywebrowset.setCommand("Select *from student");
            mywebrowset.execute();
            while(mywebrowset.next()){
                    System.out.println("Name is :" + mywebrowset.getString("name") + "  Gen. is :" + mywebrowset.getString("gender"));
            }
            */
            
       // } catch (SQLException ex) {
         //   System.out.println(ex);
       // }
    }
}