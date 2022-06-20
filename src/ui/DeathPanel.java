package ui;

import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;

/**
 *	 DeathPanel represents a GUI form for registering death
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class DeathPanel extends JPanel
{
    protected JLabel lID, lCause, lPlace, ldDate ;
    protected JTextField  tID, tCause, tPlace, tdDate ;
    protected String[] input ;
    protected JButton push ;
    
    /**
     *	Creates the GUI- 
     * @param in - a string array used to store data collected by the panel.
	*/
    public DeathPanel(String[] in)
    {
        input = in ;
        setPreferredSize(new Dimension (500,180)) ;
        setLayout( new GridLayout(6,2,0,4) ) ;
        push = new JButton("SUBMIT") ;
        push.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        push.addActionListener( new ButtonListener() ) ;
        
        lID = new JLabel("ID number") ;
        lCause = new JLabel("Cause of death") ;
        lPlace = new JLabel("Place of death") ;
        ldDate = new JLabel("Date of death") ;
        
        tID = new JTextField() ;
        tCause = new JTextField() ; 
        tPlace = new JTextField() ; 
        tdDate = new JTextField() ;  
        
        add(lID) ;
        add(tID) ;
        add(lCause) ;
        add(tCause) ;
        add(lPlace) ;
        add(tPlace) ;
        add(ldDate) ;
        add(tdDate) ;
        add(new JLabel()) ;
        add(new JLabel()) ;
        add(push) ;
    }

    /*
     * Represents a listener for the button
    */
    private class ButtonListener implements ActionListener
    {
        
        public void actionPerformed (ActionEvent event)
        {
            input[0] = tID.getText() ;
            input[1] = tCause.getText() ;
            input[2] = tPlace.getText() ; 
            input[3] = tdDate.getText() ; 
            
            tID.setText("") ;
            tCause.setText("") ;
            tPlace.setText("") ;
            tdDate.setText("") ;
        }
    }
}
