package facewordaddaccountapplication;

import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class FaceWordAddAccountApplication 
{
    private static MainWindow mw;
    
    public static void main(String[] args) 
    {
        mw = new MainWindow();
        int result = 0;
        
        do
        {
            if(mw.isSubmitted)
            {
                result = JOptionPane.showOptionDialog(mw, "Taco", "Confrim", 0, 0, null, args, args);
                System.out.println("Tacos0");
            }
        }while(!mw.isSubmitted && (result == 0 || result == -1));
        
        mw.dispatchEvent(new WindowEvent(mw, WindowEvent.WINDOW_CLOSING));
    }
    
    public static void WaitForSubmit()
    {
        while(!mw.isSubmitted);
    }
    
}
