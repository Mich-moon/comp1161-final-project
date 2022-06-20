package snid ;

/**
 *	Biometric is an interface for classes representing biometrics.			
 *
 *	@author		Michaela Wright
 *	@version 1.0
*/

public interface Biometric{

	/**
	 *	Gets the tag for the Biometric object for a person.
	 *	@return A String containing the identification label for the
	 *		biometric details stored for a person.
	*/
	String getTag();

	/**
	 *	Gets the biometric details of a person.
	 *	@return A String containing the	biometric details stored 
	 *		for a person.
	*/
	String getValue();

	/**
	 *	Determines whether a given biometric detail
	 *		is identical to that of the person.
	 *	@param other - A Biometric object.
	 *	@return An integer representing the result of 
	 *		comparing the details of the given Biometric object 
	 *		to that of the person, lexicographically.
	*/
	int match(Biometric other);

}	//	end of Biometric interface