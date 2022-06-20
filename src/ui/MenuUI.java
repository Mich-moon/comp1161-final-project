package ui;

import app.* ;

import java.awt.* ;
import javax.swing.* ;
import javax.swing.event.* ;
import java.awt.event.* ;

import java.awt.Color ;

public class MenuUI {

    protected SNIDGUI gui ;
    protected SNIDApp app ;
        
    private JFrame frame ;
    private JPanel primary, banner, options, note, form, result, defaultPanel ;
    private JPanel registerForm, parentForm, addressForm, deathForm, marriageForm, mailForm, box ;
    
    private JLabel menu, noteSelect, noteInstruct, bannerTitle ;
    private JScrollPane dScroll ;

    private JButton go ;
    private JTextArea display ;

    private JList<String> menuOptions ;
    private DefaultListModel<String> menuList ;

    private String[] input ;
    private final String[] noteS = {"__ WELCOME __", "__ BIRTH  REGISTRATION  FORM __", 
                                        "__ PARENT  DATA  UPDATE  FORM __", "__ ADDRESS  UPDATE  FORM __",
                                        "__ DEATH  REGISTRATION  FORM __", "__ MARRIAGE  REGISTRATION  FORM __", 
                                        "__ MAILING  LABEL  FORM __", "__ SEARCH __"} ;
    private final String[] noteI = { "Please select an option from the menu on the left.",
                                        "Please fill out the form below.",
                                        "Please choose a search type via the radio button and type into the text box."} ;
    private CardLayout card ;
    private String option ;

    /**
     *	Fascilitates excecution of methoda based on selections
     *      from a menu and user input.
     *	@param app - a SNIDApp object that knows how to manage data.
     *  @param input - a string array used to store data collected from the user.
	*/
    public void go(SNIDApp app, String[] input)
    {
        this.app = app ;
        this.input = input ;
        
        frame = new JFrame("\t\tSYSTEM FOR NATIONAL IDENTIFICATION (SNID)") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setPreferredSize(new Dimension(850, 600) );
        //frame.setLocationRelativeTo(null) ;

        primary = new JPanel() ;
        primary.setLayout(new BorderLayout() ) ; // change layout manager
        primary.setPreferredSize(new Dimension(800, 550) );
        primary.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30) );

        /*
        *   setting up the panel with the banner
        */
        banner = new JPanel() ;
        banner.setBorder(BorderFactory.createEmptyBorder(10,10,10,10) )  ;
        banner.setBackground(Color.DARK_GRAY);
        banner.setPreferredSize(new Dimension(750, 75) );
        banner.setLayout( new GridLayout(3,1,0,4) ) ;

        bannerTitle = new JLabel("SYSTEM FOR NATIONAL IDENTIFICATION (SNID)", JLabel.CENTER) ;
        bannerTitle.setFont(new Font("Serif", Font.BOLD, 20)) ;
        bannerTitle.setForeground(Color.WHITE);

        Component space1 = Box.createRigidArea(new Dimension(10, 10) ) ;
        banner.add(space1) ;
        banner.add(bannerTitle) ;


        /*
        *   setting up the panel with the menu options
        */
        options = new JPanel() ;
        options.setBorder(BorderFactory.createEmptyBorder(10,10,10,10) )  ;
        options.setBackground(Color.GRAY);
        options.setPreferredSize(new Dimension(250, 210) );

        menu = new JLabel("__MENU__") ;

        menuList = new DefaultListModel<>() ;
        menuList.addElement("   ") ;
        menuList.addElement("   a.  Register a Birth") ;
        menuList.addElement("   b.  Update Parent Data") ;
        menuList.addElement("   c.  Update a Citizen's Address") ;
        menuList.addElement("   d.  Register a Death") ;
        menuList.addElement("   e.  Register a Marriage") ;
        menuList.addElement("   f.  Generate a Mailing Label") ;
        menuList.addElement("   g.  Search") ;
        menuList.addElement("   h.  Exit Application") ;

        menuOptions = new JList<>(menuList) ;
        menuOptions.addListSelectionListener(new ListListener() ) ;
        menuOptions.setPreferredSize(new Dimension(200, 200));
        menuOptions.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)) ;

        options.add(menu) ;
        options.add(menuOptions) ;
                   //menuOptions.addListSelectionListener(new ListListener() ) ;

        /*
        *   setting up the panel with the notes
        */
        note = new JPanel() ;
        note.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createEmptyBorder(10,40,10,0)) ) ;
        note.setBackground(Color.LIGHT_GRAY);
        note.setPreferredSize(new Dimension(520, 70) );

        noteSelect = new JLabel() ;
        noteSelect.setPreferredSize(new Dimension(500, 18) );
        noteSelect.setHorizontalAlignment(JLabel.CENTER) ;
        noteInstruct = new JLabel() ;
        noteInstruct.setPreferredSize(new Dimension(500, 13) );

        noteSelect.setText(noteS[0]) ;
        noteInstruct.setText(noteI[0]) ;

        note.add(noteSelect) ;
        note.add(noteInstruct) ;

        /*
        *   setting up the panel with the forms
        */
        form = new JPanel() ;
        card = new CardLayout() ;
        form.setLayout(card);
        form.setPreferredSize(new Dimension (520,200)) ;
        form.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createEmptyBorder(10,40,10,0)) ) ;
    
        //   instantiating the forms
        defaultPanel = new JPanel() ;
        defaultPanel.setPreferredSize(new Dimension (500,180)) ;

        registerForm = new RegisterPanel(input) ;
        parentForm = new ParentPanel(input) ;
        addressForm = new AddressPanel(input) ;
        deathForm = new DeathPanel(input) ;
        marriageForm = new MarriagePanel(input) ;
        mailForm = new MailPanel(input) ;

        //  adding to panel with cardlayout
        form.add(defaultPanel, "default") ;
        form.add(registerForm, "register") ;
        form.add(parentForm, "parent") ;
        form.add(addressForm, "address") ;
        form.add(deathForm, "death") ;
        form.add(marriageForm, "marriage") ;
        form.add(mailForm, "mail") ;

        /*
        *   setting up the panel to contain form and notes
        */
        box = new JPanel() ;
        box.setPreferredSize(new Dimension (500,200)) ;
        box.add(note) ;
        box.add(form) ;

        /*
        *   setting up the panel with the results
        */
        result = new JPanel() ;
        result.setPreferredSize(new Dimension (780,150)) ;
        result.setLayout(new FlowLayout(FlowLayout.RIGHT));

        go = new JButton("  GO  ") ;
        go.setBackground(Color.CYAN);
        go.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        go.addActionListener( new ButtonListener() ) ;
        
        display = new JTextArea(100, 100) ; 
        display.setEditable(false) ;
        dScroll = new JScrollPane( display )  ;
        dScroll.setPreferredSize(new Dimension(780, 150));
        dScroll.add(new JScrollBar() ) ;
        dScroll.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createEmptyBorder(10,10,10,10)) ) ;

        result.add(go) ;
        result.add(dScroll) ;

        /*
        *   setting up the main panel
        */
        primary.add(banner, BorderLayout.NORTH) ;
        primary.add(result, BorderLayout.SOUTH) ;
        primary.add(box, BorderLayout.CENTER) ;
        primary.add(options, BorderLayout.WEST) ;

        frame.getContentPane().add(primary) ;
        frame.pack() ;
        frame.setVisible(true) ;

    }   // end of go method


    /*
     *  Represents a listener for the JList
    */
    private class ListListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent event)
        {
            option = menuOptions.getSelectedValue() ;    // get option selected

            if ( option != null )   //  is an option selected
            {
                if ( option.equals("   a.  Register a Birth") )     
                {
                    display.setText("") ; 
                    card.show(form, "register") ;
                    noteSelect.setText(noteS[1]) ;
                    noteInstruct.setText(noteI[1]) ;
                }
                else if ( option.equals("   b.  Update Parent Data") )      
                {
                    display.setText("") ; 
                    card.show(form, "parent") ;
                    noteSelect.setText(noteS[2]) ;
                    noteInstruct.setText(noteI[1]) ;
                }
                else if ( option.equals("   c.  Update a Citizen's Address") )
                {
                    display.setText("") ; 
                    card.show(form, "address") ;
                    noteSelect.setText(noteS[3]) ;
                    noteInstruct.setText(noteI[1]) ;
                }  
                else if ( option.equals("   d.  Register a Death") )
                {
                    display.setText("") ; 
                    card.show(form, "death") ;
                    noteSelect.setText(noteS[4]) ;
                    noteInstruct.setText(noteI[1]) ;
                }
                else if ( option.equals("   e.  Register a Marriage") )
                {
                    display.setText("") ; 
                    card.show(form, "marriage") ;
                    noteSelect.setText(noteS[5]) ;
                    noteInstruct.setText(noteI[1]) ;
                }
                else if ( option.equals("   f.  Generate a Mailing Label") )
                {
                    display.setText("") ; 
                    card.show(form, "mail") ;
                    noteSelect.setText(noteS[6]) ;
                    noteInstruct.setText(noteI[1]) ;
                }   
                else if ( option.equals("   g.  Search") )
                {
                    display.setText("") ; 
                    card.show(form, "default") ;
                    noteSelect.setText(noteS[7]) ;
                    noteInstruct.setText(noteI[2]) ;
                    gui = new SNIDGUI(app) ;
                }   
                else if ( option.equals("   h.  Exit Application") )
                {
                    frame.dispose() ;
                    app.shhutDown() ;
                }
                else
                {
                    display.setText("") ; 
                    card.show(form, "default") ;
                    noteSelect.setText(noteS[0]) ;
                    noteInstruct.setText(noteI[0]) ;
                }
            }  
             
        }
    }   // end of ListListener

    /*
     * Represents a listener for the side buttons
    */
    private class ButtonListener implements ActionListener
    {  
        public void actionPerformed (ActionEvent event)
        {

            if ( option != null )   //  is an option selected
            {
                if ( option.equals("   a.  Register a Birth") )     
                {
                    try
                    {
                        app.registerBirth(input[0].charAt(0), Integer.parseInt(input[1]), input[2], input[3], input[5] ) ;
                        display.setText("Birth registered") ;
                    }
                    catch(IndexOutOfBoundsException e1)
                    {
                        display.setText(e1.getMessage() ) ;
                    }

                }
                else if ( option.equals("   b.  Update Parent Data") )      
                {
                    try
                    {
                        app.addParentData(input[0], input[1], input[3] ) ;
                        display.setText("Parent data updated") ;
                    }
                    catch(IndexOutOfBoundsException e1)
                    {
                        display.setText(e1.getMessage()) ;
                    }

                }
                else if ( option.equals("   c.  Update a Citizen's Address") )
                {
                    try
                    {
                        app.updateAddress(input[0], input[1], input[2], input[3], input[4]) ;
                        display.setText("Address updated") ;
                    }
                    catch(IndexOutOfBoundsException e1)
                    {
                        display.setText(e1.getMessage()) ;
                    }

                }  
                else if ( option.equals("   d.  Register a Death") )
                {
                    try
                    {
                        app.registerDeath(input[0], input[1], input[2], input[3]) ;
                        display.setText("Death registered") ;
                    }
                    catch(IndexOutOfBoundsException e1)
                    {
                        display.setText(e1.getMessage()) ;
                    }

                }
                else if ( option.equals("   e.  Register a Marriage") )
                {
                    try
                    {
                        app.registerMarriage(input[0], input[1], input[2]) ;
                        display.setText("Marriage registered") ;
                    }
                    catch(IndexOutOfBoundsException e1)
                    {
                        display.setText(e1.getMessage()) ;
                    }

                }
                else if ( option.equals("   f.  Generate a Mailing Label") )
                {
                    try
                    {    
                        if ( app.search(input[0]).equals("") )
                        {
                            display.setText("Person not found") ;
                        }
                        else
                        {
                            String[] address = app.mailingLabel(input[0]).split("\\n") ; 

                            for (int i = 0; i < address.length; i++)
                            {
                                display.append(address[i] + "\n") ; 
                            } 
                        }     
                    }
                    catch(IndexOutOfBoundsException e1)
                    {
                        display.setText(e1.getMessage()) ;
                    }

                }  
                menuOptions.clearSelection() ;
                options.revalidate() ;   
            }
        }
    }   // end of ButtonListene
    
}