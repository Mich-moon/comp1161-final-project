package snid ;

import java.util.ArrayList ;

/**
 *	Person is an abstract class outlining atttributes and
 *	methods relating to the concept of a human being.			
 *
 *	@author		Michaela Wright
 *	@version 1.0
*/

abstract public class Person{

	private char lifeStatus, wedStatus ;
	private char gender ;
	private int YOB ;
	private Person mother, father ;
	private ArrayList<Biometric> biodata = new ArrayList<>() ;
	protected String id ;

	/**
	 *	Creates a person with the specidied gender and year of birth.
	 *	@param gender - the person's gender.
	 *	@param YOB - the person's year of birth.
	*/
	public Person(char gender, int YOB){
		this.gender = gender;
		this.YOB = YOB;
	}

	/**
	 *	Gets the person's gender.
	 *	@return A character representing the person's gender.
	*/
	public char getGender(){
		return gender;
	}

	/**
	 *	Gets the person's year of birth.
	 *	@return An integer representing the person's year
	 *		of birth.
	*/
	public int getYOB(){
		return YOB;
	}

	/**
	 *	Gets the person's life status.
	 *	@return A character representing the life status of 
	 *		a person, "A" = Alive, "D" Deceased.
	*/
	public char getLifeStatus(){
		return lifeStatus;
	}

	/**
	 *	Sets the person's life status.
	 *	@param stat - the life status of the person.
	*/
	public void setLifeStatus(int stat){
		if (stat == 0)
			lifeStatus = 'A';	// Alive
		else
			lifeStatus = 'D';	// Deceased 
	}

	/**
	 *	Gets the person's life status.
	 *	@return A character representing the life status of 
	 *		a person, "A" = Alive, "D" Deceased.
	*/
	public char getWedStatus(){
		return wedStatus;
	}

	/**
	 *	Sets the person's life status.
	 *	@param stat - the life status of the person.
	*/
	public void setWedStatus(int stat){
		if (stat == 0)
			wedStatus = 'S';	// Single
		else
			wedStatus = 'M';	// Married 
	}

	/**
	 *	Gets the person's identification number.
	 *	@return A string representing the person's
	 *		identification number.
	*/
	public abstract String getId() ;

	/**
	 *	Returns a formatted string containing useful
	 *		information relating to a person.
	 *	@return A string of information relating to
	 *		the person.
	*/
	public abstract String toString() ;

	/**
	 *	Gets the person's parent.
	 *	@param type - A character representing the type
	 *		of parent, "F" for father, "M" for mother.
	 *	@return the parent object.
	*/
	public Person getParent(char type) 
	{
		if (type == 'M')
			return mother;
		else if ( type == 'F' )
			return father;
		else 
			return null ;
	}

	/**
	 *	Sets the person's parent.
	 *	@param type - A character representing the type
	 *		of parent, "F" for father, "M" for mother.
	 *	@param parent - an object representing the parent.
	*/
	public void setParent(char type, Person parent) 
	{
		if ( type == 'M' )
		{
			mother = parent ;
		}

		else 
		{
			father = parent ;
		}
	}

	/**
	 *	Adds biometric information for the person.
	 *	@param data - A Biometric object representing a 
	 *		type biometric information for the person.
	*/
	public void addBiometric(Biometric data) 
	{
		// STUDS
	}

	/**
	 *	Gets biometric information for a person.
	 *	@param tag - A String representing the type of
	 *		biometric information to be returned.
	 *	@return A Biometric object representing a type
	 *		of biometric information for the person.
	*/
	public Biometric getBiometric(String tag) 
	{
		// studs
		return null ;
	}

}	//	end of Person class