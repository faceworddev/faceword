package facewordaddaccountapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ApplicationController implements ActionListener 
{
    private static MainWindow mw;
    
    public ApplicationController ()
    {
        mw = new MainWindow(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int result = 0;
        result = JOptionPane.showOptionDialog(mw, "Please verify the information was entered correctly. If everything is correct, click 'yes'?.", "Confrim", 0, 0, null, null, null);
        
        if(result == 0) //If yes is clicked
        {
            System.exit(0);
        }
    }
}

    