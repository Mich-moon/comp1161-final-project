package data ;

import java.io.File ; 
import java.io.IOException ; 
import java.util.Scanner ; 
import java.util.regex.PatternSyntaxException ;
import java.io.FileWriter ;
import java.io.BufferedWriter ;	
import java.io.PrintWriter ;

/**
 *	SNIDDb represents a class that knows how to read and write
 *		data from or to a text file.
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class SNIDDb
{
	private String delimiter ;
	private File file ;
	private Scanner scan = null ;
	private BufferedWriter bw = null ;
	private PrintWriter pw = null ;
	private FileWriter fw = null ;

	/**
	 *	Creates a SNIDDb object using the specified fileName
	 *		and delimter.
	 *	@param fileName - the name of the file to be opened.
	 *	@param delimiter - the delimter to be used in reading.
	*/
	public SNIDDb(String fileName, char delimiter)
	{
		try{
			file = new File(fileName) ;
			// convert the delimeter from character to String
			this.delimiter =  Character.toString(delimiter) ;
    		scan = new Scanner(file) ; 
  
    		// setting the delimeter 
    		scan.useDelimiter(this.delimiter) ;

		}
		catch(IOException e)
		{
			System.out.println(e.getMessage()) ;
			e.printStackTrace() ;
		}

	}

	/**
	 *	Determines the possibility of reading 
	 *		data from the file.
	 *	@return A boolean value.
	*/
	public boolean hasNext()
	{
		if (scan != null)
			return scan.hasNext() ;	
		else
			return false ;
	}

	/**
	 *	Reads a line from the file.
	 *	@return An array of strings containing tokens
	 *		formed by splitting a line read from file.
	*/
	public String[] getNext()
	{
		String[] tokens = null ;
		try
		{
			if (scan != null)
			{
				String line = scan.nextLine() ;
				tokens = line.split("\\|") ;
			}	
		}
		catch(PatternSyntaxException e1)
		{
  			System.out.println(e1.getMessage()) ;
			e1.printStackTrace() ;
		}
		if ( tokens != null )
		{
			if ( tokens.length == 13 )
				return tokens ; 
		}
		
		return null ;
	}

	/**
	 *	Closes the file.
	**/
	public void close()
	{
		try
		{
			pw.close() ;
			bw.close() ;
			fw.close() ;
		}
		catch (IOException e) 
    	{
      		System.out.println(e.getMessage()) ;
			e.printStackTrace() ;
		}		
	}

	/**
	 *	Closes the file and reopens it for data
	 *		to be written to it.
	**/
	public void rewrite()
	{
		// close the file if open for reading
		if (scan != null)
		{
			scan.close() ;
		}
		
		try
		{	
			fw = new FileWriter(file) ; 
			bw = new BufferedWriter(fw) ;
			pw = new PrintWriter(bw) ;
			pw.write("") ;

			pw.close() ;
			bw.close() ;
			fw.close() ;

			// reopen file for append
			fw = new FileWriter(file, true) ;  // true enables append
			bw = new BufferedWriter(fw) ;
			pw = new PrintWriter(bw) ;

		}
		catch(IOException e)
		{
			System.out.println(e.getMessage()) ;
			e.printStackTrace() ;
		}		
	}

	/**
	 *	Accepts an array of strings and write the elements of this
	 *		array to the file separated by the delimeter.
	 *	@param data - an array of Strings.
	**/
	public void putNext(String[] data)
	{
		String element = "" ;

		for (String el : data)
			element = element.concat(el) ; // add tokens to a single string
				
		// adding lines separated by the delimeter
		element.concat(delimiter) ; // adding the delimeter at the end.
		pw.println(element) ; // appending to new line 
		pw.flush() ;
    	
    	
	}
	
}	// end of SNIDDb class