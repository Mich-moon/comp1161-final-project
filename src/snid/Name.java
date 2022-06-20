package snid ;

/**
 *	Name is a class representing a person's name.			
 *
 *	@author		Michaela Wright
 *	@version 1.0
*/

public class Name{

	private String fName, mName, lName;


	/**
	 *	Creates a Name object with the specidied first name,
	 *		middle name and last name.
	 *	@param fn - the first name of the citizen.
	 *	@param mn - the middle name of the citizen.
	 *	@param ln - the last name of the citizen.
	*/	
	public Name(String fn, String mn, String ln){
		fName = fn;
		mName = mn;
		lName = ln;
	}

	/**
	 *	Gets the citizen's first name.
	 *	@return A String representing the first name.
	*/
	public String getFirstName(){
		return fName;
	}

	/**
	 *	Gets the citizen's last name.
	 *	@return A String representing the last name.
	*/
	public String getLastName(){
		return lName;
	}

	/**
	 *	Gets the citizen's middle name.
	 *	@return A String representing the middle name.
	*/
	public String getMiddleName(){
		return mName;
	}

	/**
	 *	Sets the citizen's last name.
	 *	@param lastName - A String object representing the
	 *		citizen's last name.
	*/
	public void setLastName(String lastName){
		lName = lastName;
	}

	/**
	 *	Returns a formatted string containing name specific 
	 *		information for the citizen.
	 *	@return A string comprised of the the firt name,
	 *		middle name and last name for the citizen.
	*/  
	public String toString(){
		return fName+" "+mName+" "+lName;
	}

	/**
	 *	Determines whether a given Name object
	 *		is identical to that of the Citizen.
	 *	@param name - A Name object.
	 *	@return A boolean representative of similarity
	 *		or non similarity.
	*/
	public boolean equals(Name name){
		return ( fName.equals(name.getFirstName()) &&
				mName.equals(name.getMiddleName()) &&
				lName.equals(name.getLastName()) );
	}

}	//	end of Name class