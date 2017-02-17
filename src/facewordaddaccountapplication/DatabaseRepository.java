package facewordaddaccountapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseRepository 
{
    public static void InsertCredential(Connection con, int userId, String username, String password, String url)
    {
        Statement stmt;
        try 
        {
            stmt = con.createStatement();
            
            stmt.executeUpdate("INSERT INTO Credentials (Username, Password, Url, User_Id) VALUES ('" + username + "', '" + password + "', '" + url + "', '" + userId + "')");
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DatabaseRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void UpdateCredential(Connection con, int userId, String username, String password, String url)
    {
        Statement stmt;
        
        try
        {
            stmt = con.createStatement();
            
            stmt.executeUpdate("UPDATE Credentials SET Username='" + username + "', Password='" + password + "' WHERE Url='" + url + "' AND User_Id=" + userId);
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(DatabaseRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<String> GetListOfUserAccounts(Connection con, int userId)
    {
        Statement stmt;
        ArrayList<String> accounts = new ArrayList<>();
        
        try
        {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Url FROM Credentials WHERE User_Id=" + userId);
            
            while(rs.next())
            {
                accounts.add(rs.getString("Url"));
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(DatabaseRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return accounts;
    }
}
