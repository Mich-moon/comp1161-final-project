package ui;

import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;

/**
 *	 ParentPanel represents a GUI form for registering birth
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class ParentPanel extends JPanel
{
    protected JLabel lID, lFather, lMother ;
    protected JTextField  tID, tFather, tMother ;
    protected String[] input ;
    protected JButton push ;
    
    /**
     *	Creates the GUI- 
     * @param in - a string array used to store data collected by the panel.
	*/
    public ParentPanel(String[] in)
    {
        input = in ;
        setPreferredSize(new Dimension (500,180)) ;
        setLayout( new GridLayout(6,2,0,4) ) ;
        push = new JButton("SUBMIT") ;
        push.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        push.addActionListener( new ButtonListener() ) ;
        
        lID = new JLabel("ID number") ;
        lFather = new JLabel("Father's id number") ;
        lMother = new JLabel("Mother's id number") ;
        
        tID = new JTextField() ; 
        tFather = new JTextField() ; 
        tMother = new JTextField() ; 
        
        add(lID) ;
        add(tID) ;
        add(lFather) ;
        add(tFather) ;
        add(lMother) ;
        add(tMother) ;
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
            input[1] = tFather.getText() ;
            input[2] = tMother.getText() ;  
            
            tID.setText("") ; 
            tFather.setText("") ; 
            tMother.setText("") ;
        }
    }
}
