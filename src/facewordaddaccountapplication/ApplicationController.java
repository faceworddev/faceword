package facewordaddaccountapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ApplicationController implements ActionListener 
{
    private static MainWindow mw;
    private DatabaseConnectionManager dcm;
    private int userId;
    
    public ApplicationController ()
    {
        dcm = new DatabaseConnectionManager();
        mw = new MainWindow(this);
        try 
        {
            Scanner input = new Scanner(new File("C:\\FaceWord\\UserId.txt"));
            userId = input.nextInt();
        } 
        catch (FileNotFoundException ex) 
        {
            userId = 0;
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int result = 0;
        String username = mw.GetUsername();
        String password = mw.GetPassword();
        String url = mw.GetUrl();
        boolean wasUpdated = false;
        
        result = JOptionPane.showOptionDialog(mw, "Please verify the information was entered correctly. If everything is correct, click 'yes'?.", "Confrim", 0, 0, null, null, null);
        
        if(result == 0) //If yes is clicked
        {
            Connection con = dcm.GetNewConnection();
            
            // A user cannot have more than one account per url/app so if they try adding another Facebook account it will overwrite the one they currently have on file.
            
            ArrayList<String> accounts = DatabaseRepository.GetListOfUserAccounts(con, userId);
            
            for(int i = 0; i < accounts.size(); i++)
            {
                if(accounts.get(i).equals(url))
                {
                    wasUpdated = true;
                    DatabaseRepository.UpdateCredential(con, userId, username, password, url);
                }
            }
            
            if(!wasUpdated)
            {
                DatabaseRepository.InsertCredential(con, userId, username, password, url);
            }
            
            dcm.CloseConnection(con);
            System.exit(0);
        }
    }
}

    