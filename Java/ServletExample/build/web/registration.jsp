<%-- 
    Document   : registration
    Created on : Dec 2, 2021, 11:27:41 AM
    Author     : Jaydeep Chauhan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Registration</title>
        <style>
            input[type="submit"],input[type="reset"]{
                border: none;
                text-align: center;color: white;
                background-color: #008CBA;
                padding: 15px 10px;
                font-size: 17px;
                cursor: pointer;
                border-radius: 10px;
            }
            input[type="text"],input[type="password"],input[type="email"],select{
                border-radius: 5px;
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <center>
        <form action="JSPProcessig.jsp" method="post" name="register">
            <h1>Student Registration</h1>
            <table border="2" cellspacing="8" cellpadding="5" style="border-radius: 10px;">
                <tr>
                    <td><b>Name</b></td>
                    <td> <input type="text" name="name" /> </td>
                </tr>   
                <tr>
                    <td><b>Gender</b></td>
                    <td>
                        <input type="radio" name="gen" value="male"/>Male
                        <input type="radio" name="gen" value="female"/>Female
                    </td>
                </tr>
                <tr>
                    <td><b>Hobby</b></td>
                    <td>
                        Cricket<input type="checkbox" name="chk" value="cricket"/>
                        Running<input type="checkbox" name="chk" value="running"/>
                        Driving<input type="checkbox" name="chk" value="driving"/>
                    </td>
                </tr>
                <tr>
                    <td><b>Email</b></td>
                    <td>
                        <input type="email" name="email"/>
                    </td>
                </tr>
                <tr>
                    <td><b>Password</b></td>
                    <td>
                        <input type="password" name="pass"/>
                    </td>
                </tr>
                <tr>
                    <td><b>City</b></td>
                    <td>
                        <select name="city">
                            <option>Surat</option>
                            <option>Mumbai</option>
                            <option>Pune</option>
                            <option>Banglore</option>
                        </select>
                    </td>
                </tr>
                <td>
                    <input type="submit" value="Submit" name="submit" />
                    <input type="reset" value="Clear" name="reset" />
                </td>
            </table>
        </form>
    </center>
    </body>
</html>
