package ui;

import app.* ;

import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

import java.awt.Color ;


/**
 *	 SNIDGUI represents a GUI form that can be used to query the 
 *      System for National Identification (SNID) database. 
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class SNIDGUI
{
    protected JPanel primary, buttonPanel, searchPanel, detailPanel, recordPanel ;
    protected JFrame frame ;

    protected JButton search, clear, quit ;
    protected JLabel label1, label2, label3 ;
    protected JRadioButton id, name, bio ;
    protected JTextField data ; 
    protected JTextArea details ;
    protected JList<String> records ;
    protected JScrollPane dScroll ;

    protected String searchData ;
    protected ButtonGroup radioGroup ;
    protected DefaultListModel<String> idList ;

    protected SNIDApp app ;

    /**
     *	Creates a SNIDGUI object with the specified app object
	 *	@param app - the app object.
	**/
    public SNIDGUI(SNIDApp app)
    {
        this.app = app ;

        frame = new JFrame("\t\tSYSTEM FOR NATIONAL IDENTIFICATION (SNID)") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setBackground(Color.LIGHT_GRAY) ;
        frame.setPreferredSize(new Dimension(650, 350) );

        primary = new JPanel() ;
        primary.setLayout(new BorderLayout() ) ; // change layout manager
        primary.setPreferredSize(new Dimension(600, 300) );
        primary.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30) );
        
        /*
        *   setting up the panel with three bottons in a 
        *       vertical box layout.
        */
        buttonPanel = new JPanel()  ;
        // set grid layout of 6 rows, 1 column, 0 horizontal gap, 4 vgap
        buttonPanel.setLayout( new GridLayout(6,1,0,4) ) ;

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10) )  ;
        buttonPanel.setBackground(Color.DARK_GRAY);

        search = new JButton("  Search  ") ;
        search.setBorder(BorderFactory.createRaisedSoftBevelBorder() ) ;
        search.addActionListener( new ButtonListener() ) ;
        clear =  new JButton("Clear") ;
        clear.setBorder(BorderFactory.createRaisedSoftBevelBorder() ) ;
        clear.addActionListener( new ButtonListener() ) ;
        quit =   new JButton("Quit") ;
        quit.setBorder(BorderFactory.createRaisedSoftBevelBorder() ) ;
        quit.addActionListener( new ButtonListener() ) ;

        buttonPanel.add(search) ;
        buttonPanel.add(clear) ;
        buttonPanel.add(quit) ;

        /*
         *	sets up the panel with three radio bottons in  
         *      the flow (default) layout. - 
        */
        searchPanel = new JPanel()  ;
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10) );
        searchPanel.setBackground(Color.GRAY);
        // set left alignment
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT)) ;

        // instantiating radio buttons
        id = new JRadioButton() ;
        id.setBackground(Color.GRAY);
        name = new JRadioButton() ;
        name.setBackground(Color.GRAY);
        bio = new JRadioButton() ;
        bio.setBackground(Color.GRAY);

        // adding the radio buttons to a button group 
            //  so that only one can be selected at a time.
        radioGroup = new ButtonGroup() ;
        radioGroup.add(id) ;
        radioGroup.add(name) ;
        radioGroup.add(bio) ;

        // instantiating labels for radio buttons
        label1 = new JLabel("Search by ID") ;
        label2 = new JLabel("Search by Name") ;
        label3 = new JLabel("Biometric Search") ;

        // intstantiating text field for the search data
        data = new JTextField(50) ;

        // adding labels, radio buttons and rigid areas to searchPanel
        searchPanel.add(label1) ;
        searchPanel.add(id) ;
        searchPanel.add(Box.createRigidArea(new Dimension(20,0) ) ) ;
        searchPanel.add(label2) ;
        searchPanel.add(name) ;
        searchPanel.add(Box.createRigidArea(new Dimension(20,0) ) ) ;
        searchPanel.add(label3) ;
        searchPanel.add(bio) ;
        searchPanel.add(data) ;
        searchPanel.add(Box.createRigidArea(new Dimension(40,0) ) ) ;

        searchPanel.setPreferredSize(new Dimension(500,80) );

        /*
         *	sets up the text area for displaying 
         *      details of selected records. 
        */
        detailPanel = new JPanel()  ;
        detailPanel.setPreferredSize(new Dimension (100,150)) ;
        //set panel border to empty border and lower bevel
        detailPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createEmptyBorder(10,10,10,10)) ) ;
    
        details = new JTextArea(17, 30) ;
        details.setBounds(0,0,300,200) ;
        detailPanel.add(details) ;

        /*
         *	sets up the list for displaying ids    
        */
        recordPanel = new JPanel() ;
        recordPanel.setPreferredSize(new Dimension (150,200)) ;
        //set panel border to raised bevel and empty border
        recordPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10) )  ;
        
        idList = new DefaultListModel<>() ;  
        records = new JList<>(idList) ;
        
        records.setPreferredSize(new Dimension(150, 200));
        records.addListSelectionListener(new ListListener() ) ;
        dScroll = new JScrollPane( records )  ;
        dScroll.setPreferredSize(new Dimension(150, 200));
        dScroll.add(new JScrollBar() ) ;
        dScroll.setBorder(BorderFactory.createEmptyBorder(0,0,0,20) )  ;
        recordPanel.add(dScroll) ;

        /*
         *	adding panels to areas of the border layout.   
        */
        primary.add(searchPanel, BorderLayout.NORTH) ;
        primary.add(detailPanel, BorderLayout.CENTER) ;
        primary.add(recordPanel, BorderLayout.WEST) ;
        primary.add(buttonPanel, BorderLayout.EAST) ;

        frame.getContentPane().add(primary) ;
        frame.pack() ;
        frame.setVisible(true) ;
    }

    /*
     * Represents a listener for the side buttons
    */
    private class ButtonListener implements ActionListener
    {
        
        public void actionPerformed (ActionEvent event)
        {
            if (event.getSource() == search)
            {
                // clears ids and details before search
                details.setText("") ;
                // clear id pane
                idList.clear() ;
                idList.clear() ;


                // get details
                searchData = data.getText() ;
                if ( !searchData.equals("") )
                {

                    if (id.isSelected() )   //  SEARCH BY ID
                    {
                        String id = data.getText() ;    // get text from input field
                        
                        // search using data entered - results in an array
                        String results = app.search(id) ;   

                        //details.setText(results) ;  //  display details of person found

                        if (results.equals(""))       
                            idList.addElement("  void") ;   // no one found  
                        else
                            idList.addElement(id) ; //  display id of person found
                        
                    }
                    if (name.isSelected() )     //  SEARCH BY NAME
                    {
                        String lName = data.getText() ;     // get text from input field

                        // search using data entered - results in an array
                        String[] results = app.search("", lName) ;  

                        if (results == null)
                            idList.addElement("  void") ;   // no one found
                        else
                        {
                            for (int i = 0; i < results.length; i++)    
                            {
                                // splits each element in array in order to extract the id - index zero
                                String[] parts = results[i].split(",") ;   
                                idList.addElement(parts[0] ) ;  //  display ids of persons found 
                            }
                        } 
                          
                    }
                    if (bio.isSelected() )  // UNSUPPORTED SEARCH
                    {
                        idList.addElement("  void") ;
                    }
                    // deselect all radio buttons
                    radioGroup.clearSelection() ;
                }     
            }    
            else if (event.getSource() == clear)
            {
                // clear search text
                data.setText("") ;
                details.setText("") ;
                // deselect all radio buttons
                radioGroup.clearSelection() ;
                // clear id pane
                idList.clear() ;
            }
            else
            {
                // close the frame
                frame.dispose() ;
            }       
        }
    }

    
    /*
     *  Represents a listener for the JList
    */
    private class ListListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent event)
        {
            String option = records.getSelectedValue() ;    // get id selected

            if ( option != null )   //  is an id selected
            {
                if ( option.equals("  void") )
                    details.setText("No details available" ) ;
                else  
                    details.setText(app.search(option)) ;  //  display details for id selected  
            }    
        }
    }
    
}   // end of SNIDGUI class