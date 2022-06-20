package ui;

import app.* ;
import java.util.Scanner ;

/**
 *	TextUI represents an object that coordinates
 *      user interface functions.
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class TextUI 
{
    protected Scanner scan ;
    protected String choice ;
    protected String[] input ;
    protected SNIDGUI gui ;

    /**
     *	Fascilitates excecution of methoda based on selections
     *      from a menu and user input.
     *	@param app - a SNIDApp object that knows how to manage data.
	*/
    public void go(SNIDApp app)
    {
        scan = new Scanner(System.in) ;

        do
        {
            System.out.println("\n_ _ System for National Identification Databse (SNID) _ _\n") ;
            System.out.println("\ta. Register a Birth") ;
            System.out.println("\tb. Update Parent Data") ;
            System.out.println("\tc. Update a Citizen's Address") ;
            System.out.println("\td. Register a Death") ;
            System.out.println("\te. Register a Marriage") ;
            System.out.println("\tf. Generate a Mailing Label") ;
            System.out.println("\tg. Search") ;
            System.out.println("\th. Exit Application") ;
            System.out.println("\tPlease enter an option\n") ;
    
            choice = scan.next() ; 

            if ( choice.equalsIgnoreCase("a") )     //REGISTER BIRTH
            {   
                System.out.println(" Enter the following information in one line separated by commas") ;
                System.out.println("\t\t gender, year of birth, first name, middle name, last name") ;
                input = scan.next().split(",") ; 

                try{
                    app.registerBirth(input[0].charAt(0), Integer.parseInt( input[1] ), input[2], input[3], input[4] ) ;
                }
                catch(IndexOutOfBoundsException e1)
                {
                    System.out.println(e1.getMessage()) ;
                    e1.printStackTrace() ;
                }
                catch(NumberFormatException e2)
                {
                    System.out.println(e2.getMessage()) ;
                    e2.printStackTrace() ;
                }
               
            }
            else if ( choice.equalsIgnoreCase("b") )        //  UPDATE PARENT DATA
            {   
                System.out.println(" Enter the following information in one line separated by commas") ;
                System.out.println("\t\t id number, father's id number, mother's id number ") ;
                input = scan.next().split(",") ; 

                app.addParentData(input[0], input[1], input[3] ) ;

            }
            else if ( choice.equalsIgnoreCase("c") )        //  UPDATE CITIZEN'S ADDRESS
            {
                System.out.println(" Enter the following information in one line separated by commas") ;
                System.out.println("\t\t id number, street, town/city, parish/county/zone, country ") ;
                input = scan.next().split(",") ; 

                app.updateAddress(input[0], input[1], input[2], input[3], input[4]) ;

            }
            else if ( choice.equalsIgnoreCase("d") )        //  REGISTER DEATH
            {
                System.out.println(" Enter the following information in one line separated by commas") ;
                System.out.println("\t\t id number, cause of death, place of death, date of death ") ;
                input = scan.next().split(",") ; 

                app.registerDeath(input[0], input[1], input[2], input[3]) ;

            }
            else if ( choice.equalsIgnoreCase("e") )        //  REGISTER MARRIAGE
            {
                System.out.println(" Enter the following information in one line separated by commas") ;
                System.out.println("\t\t id number of the groom, id number of the bride, date of marriage ") ;
                input = scan.next().split(",") ; 

                app.registerMarriage(input[0], input[1], input[2]) ;

            }
            else if ( choice.equalsIgnoreCase("f") )        //  GENERATE MAILING LABEL
            {
                System.out.println(" Enter the following information in one line separated by commas") ;
                System.out.println("\t\t id number ") ;

                System.out.println(  app.mailingLabel(scan.next() )  ) ;    

            }
            else if ( choice.equalsIgnoreCase("g") )        //  SEARCHES
            {
                gui = new SNIDGUI(app) ;

            }
            else if ( choice.equalsIgnoreCase("h") )        //  EXIT APPLICATION
            {
                System.out.println("\n _ __ ___Exiting___ __ _\n") ;
                app.shhutDown() ;
            }
            else
                System.out.println( "Invalid response. Please try again.") ;
                
        }
        while (!choice.equalsIgnoreCase("h") ) ;
        
    }
}