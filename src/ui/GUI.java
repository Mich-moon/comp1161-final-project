package ui;
import app.* ;

/**
 *	GUI represents an object that displays a menu and 
 *      coordinates user interface functions.
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class GUI
{
    //protected SNIDGUI gui ;
    protected SNIDApp app ;
    protected MenuUI menu ;

    private String[] input ;

    /**
     *	Fascilitates excecution of methoda based on selections
     *      from a menu and user input.
     *	@param app - a SNIDApp object that knows how to manage data.
	*/
    public void go(SNIDApp app)
    {
        this.app = app ;
        input = new String[6] ;
        
        this.menu = new MenuUI() ;
        menu.go(app, input) ;

    }

}   // end of MenuUI class