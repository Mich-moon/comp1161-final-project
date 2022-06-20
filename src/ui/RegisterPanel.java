package ui;

import java.awt.* ;
import javax.swing.* ;

import java.awt.event.* ;

/**
 *	 RegisterPanel represents a GUI form for registering birth
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class RegisterPanel extends JPanel
{
    protected JLabel lGender, lYOB, lFName, lMName, lLName ;
    protected JTextField  tGender, tYOB, tFName, tMName, tLName ;
    protected String[] input ;
    protected JButton push ;

    /**
     *	Creates the GUI- 
     * @param in - a string array used to store data collected by the panel.
	*/
    public RegisterPanel(String[] in)
    {
        input = in ;
        setPreferredSize(new Dimension (500,180)) ;
        setLayout( new GridLayout(6,2,0,4) ) ;
        push = new JButton("Submit") ;
        push.setBounds(0, 0, 50, 30);;
        push.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        push.addActionListener( new ButtonListener() ) ;

        lGender = new JLabel("Gender (F/M)") ;
        lYOB = new JLabel("Year of birth") ; 
        lFName = new JLabel("First name") ; 
        lMName = new JLabel("Middle name") ; 
        lLName = new JLabel("Last name") ;

        tGender = new JTextField() ; 
        tYOB = new JTextField() ; 
        tFName = new JTextField() ;
        tMName = new JTextField() ; 
        tLName = new JTextField() ;

        add(lGender) ;
        add(tGender) ;
        add(lYOB) ;
        add(tYOB) ;
        add(lFName) ;
        add(tFName) ;
        add(lMName) ;
        add(tMName) ;
        add(lLName) ;
        add(tLName) ;
        add(push) ;
    }

    /*
     * Represents a listener for the button
    */
    private class ButtonListener implements ActionListener
    {
        
        public void actionPerformed (ActionEvent event)
        {
            input[0] = tGender.getText() ;
            input[1] = tYOB.getText() ;
            input[2] = tFName.getText() ; 
            input[3] = tMName.getText() ;  
            input[4] = tLName.getText() ; 
            
            tGender.setText("") ;
            tYOB.setText("") ; 
            tFName.setText("") ;
            tMName.setText("") ; 
            tLName.setText("") ;
        }
    }
}
