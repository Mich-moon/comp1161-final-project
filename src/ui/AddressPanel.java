package ui;

import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;

/**
 *	 AddressPanel represents a GUI form for updating address
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class AddressPanel extends JPanel
{
    protected JLabel lID, lAddress1, lAddress2, lAddress3, lAddress4 ; 
    protected JTextField  tID, tAddress1, tAddress2, tAddress3, tAddress4 ; 
    protected String[] input ;
    protected JButton push ;
    
    /**
     *	Creates the GUI- 
     * @param in - a string array used to store data collected by the panel.
	*/
    public AddressPanel(String[] in)
    {
        input = in ;
        setPreferredSize(new Dimension (500,180)) ;
        setLayout( new GridLayout(6,2,0,4) ) ;
        push = new JButton("SUBMIT") ;
        push.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        push.addActionListener( new ButtonListener() ) ;

        lID = new JLabel("ID number") ;
        lAddress1 = new JLabel("street") ;
        lAddress2 = new JLabel("town/city") ;
        lAddress3 = new JLabel("parish/county/zone") ;
        lAddress4 = new JLabel("country") ;

        tID = new JTextField() ; 
        tAddress1 = new JTextField() ;
        tAddress2 = new JTextField() ;
        tAddress3 = new JTextField() ;
        tAddress4 = new JTextField() ;

        add(lID) ;
        add(tID) ;
        add(lAddress1) ;
        add(tAddress1) ;
        add(lAddress2) ;
        add(tAddress2) ;
        add(lAddress3) ;
        add(tAddress3) ;
        add(lAddress4) ;
        add(tAddress4) ;
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
            input[1] = tAddress1.getText() ;
            input[2] = tAddress2.getText() ; 
            input[3] = tAddress3 .getText() ;  
            input[4] = tAddress4.getText() ; 

            tID.setText("") ; 
            tAddress1.setText("") ; 
            tAddress2.setText("") ; 
            tAddress3.setText("") ; 
            tAddress4.setText("") ; 
        }
    }
}