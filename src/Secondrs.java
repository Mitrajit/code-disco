
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mitrajit
 */
public class Secondrs {
    static Connection con= DatabaseConnection.Connect("root", "work159");
    static  Statement stm=null;
    static  ResultSet rs=null;
    public static int Grab(int c)
    {
        java.util.Date date=new java.util.Date();
    java.sql.Date dt=new java.sql.Date(date.getTime());
        int st=0;
        try{
            stm = con.createStatement();        
        String sql="SELECT * FROM `register` WHERE Date='"+dt+"'";
        rs=stm.executeQuery(sql);
        if(rs.next())
        {
            st=rs.getInt(c);
        }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);}
        
        return(st);
        
    }
    
}
