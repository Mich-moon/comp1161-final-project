package ui;

import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;

/**
 *	 MailPanel represents a GUI form for generating mailing label
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class MailPanel extends JPanel
{
    protected JLabel lID ; 
    protected JTextField  tID; 
    protected String[] input ;
    protected JButton push ;

    /**
     *	Creates the GUI- 
     * @param in - a string array used to store data collected by the panel.
	*/
    public MailPanel(String[] in)
    {
        input = in ;
        setPreferredSize(new Dimension (500,180)) ;
        setLayout( new GridLayout(6,2,0,4) ) ;
        push = new JButton("SUBMIT") ;
        push.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        push.addActionListener( new ButtonListener() ) ;
        
        lID = new JLabel("ID number") ;
        tID = new JTextField() ; ;
        
        add(lID) ;
        add(tID) ;
        add(new JLabel()) ;
        add(new JLabel()) ;
        add(new JLabel()) ;
        add(new JLabel()) ;
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
            input[0] = tID.getText() ; 
            tID.setText("") ;
        }
    }
}