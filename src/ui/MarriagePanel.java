package ui;

import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;

/**
 *	 MarriagePanel represents a GUI form for registering marriage
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class MarriagePanel extends JPanel
{
    protected JLabel lID, lGroom, lBride, lmDate ;
    protected JTextField  tID, tGroom, tBride, tmDate; 
    protected String[] input ;
    protected JButton push ;
    
    /**
     *	Creates the GUI- 
     * @param in - a string array used to store data collected by the panel.
	*/
    public MarriagePanel(String[] in)
    {
        input = in ;
        setPreferredSize(new Dimension (500,180)) ;
        setLayout( new GridLayout(6,2,0,4) ) ;
        push = new JButton("SUBMIT") ;
        push.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        push.addActionListener( new ButtonListener() ) ;
        
        lGroom = new JLabel("ID number of the groom") ;
        lBride = new JLabel("ID number of the bride") ;
        lmDate = new JLabel("Date of marriage") ;
        
        tGroom = new JTextField() ; 
        tBride = new JTextField() ; 
        tmDate = new JTextField() ; 
        
        add(lGroom) ;
        add(tGroom) ;
        add(lBride) ;
        add(tBride) ;
        add(lmDate) ;
        add(tmDate) ;
        add(new JLabel()) ;
        add(new JLabel()) ;
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
            input[0] = tBride.getText() ;
            input[1] = tGroom.getText() ;
            input[2] = tmDate.getText() ; 

            tGroom.setText("") ;
            tBride.setText("") ; 
            tmDate.setText("") ;
        }
    }
}