import app.* ;
import ui.* ;
import java.util.Scanner ;

/**
 *	Driver for the system for National Ids (SNID).			
 *
 *	@author		Michaela Wright 620127969
 *	@version 1.0
*/

public class Main
{
	public static void main(String[] args)
	{
		SNIDApp app = new SNIDApp("SNID0.txt", ',') ;

		Scanner scan = new Scanner(System.in) ;
		System.out.println("1 - TextUI") ;
		System.out.println("2 - GUI") ;
		int option = scan.nextInt() ;

		if (option == 1)
		{
			TextUI ui = new TextUI() ;
			ui.go(app) ;
		}
		else
		{
			GUI ui = new GUI() ;
			ui.go(app) ;
		}
		scan.close() ;

	}

}//	end of main class

