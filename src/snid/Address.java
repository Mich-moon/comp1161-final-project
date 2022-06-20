package snid ;

/**
 *	Address is a class representing a person's address.			
 *
 *	@author		Michaela Wright
 *	@version 1.0
*/

public class Address{

	private String street, town, zone, country;

	/**
	 *	Creates an Address object with the specidied address
	 *		details.
	 *	@param lines - A String object comprised of the person's
	 *		street, town, zone and country (in that order)
	 *		separated by the "|" symbol.
	*/	
	public Address(String lines){
		try
		{
			String[] parts = lines.split("\\|") ;
			street = parts[0] ;
			town = parts[1] ;
			zone = parts[2] ;
			country = parts[3] ;

		}
		catch(IndexOutOfBoundsException e1){
			System.out.println(e1.getMessage()) ;
		  	e1.printStackTrace() ;
	  	}
		
	}

	/**
	 *	Gets the citizen's zone.
	 *	@return A String representing the zone in the
	 *		citizen's address.
	*/
	public String getZone(){
		return zone ;
	}

	/**
	 *	Returns a formatted string containing address 
	 *		details for the citizen.
	 *	@return A string comprised of the the street,
	 *		town, zone and country for the citizen.
	*/ 
	public String toString(){
		return street+"\n"+town+"\n"+zone+"\n"+country ;
	}
	
}	//	end of Address class