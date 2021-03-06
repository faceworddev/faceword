package facewordaddaccountapplication;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnectionManager
{
    private String url = "50.87.145.151";
    private String username = "faceword_root";
    private String password = "diCoOkHxmKpGgby!B0";
    private String databaseName = "faceword_faceword";
    
    public Connection GetNewConnection()
    { 
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://"+url+":3306/"+databaseName,username,password);
            return con;
        } 
        catch (SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(DatabaseConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }   
    
    public void CloseConnection(Connection con)
    {
        try 
        {
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DatabaseConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
