package snid ;

import java.util.ArrayList ;

/**
 *	Citizen is a class representing a person with 
 *		additional attributes.			
 *
 *	@author		Michaela Wright
 *	@version 1.0
*/

public class Citizen extends Person implements CivicDoc, Comparable<Person> {

	private static int idGen = 0 ; // used to genrate ID numbers	

	private Name name ;
	private Address address ;
	private ArrayList<CivicDoc> papers = new ArrayList<CivicDoc>() ;
	

	/**
	 *	Creates a citizen with the specidied gender, year of birth,
	 *		first name, middle name and last name.
	 *	@param gender - the citizen's gender.
	 *	@param YOB - the citizen's year of birth.
	 *	@param fN - the first name of the citizen.
	 *	@param mN - the middle name of the citizen.
	 *	@param lN - the last name of the citizen.
	*/
	public Citizen(char gender, int YOB, String fN, String mN, String lN){
		/*	The following uses the contructor of the parent class Person */
		super(gender, YOB) ;

		/* Below is an assignment of an instance of the Name class 
			to the name attribute */
		name = new Name(fN, mN, lN) ;
		setLifeStatus(0) ;	// set life status to alive.
		setWedStatus(0) ;	// set wedStatus to single

		/* Below is the incrementation of the idGen variable used
			to generate a new id number */	
		idGen++ ;
		id = Integer.toString(idGen) ;
	}

	/**
	 *	Creates a citizen with the specidied gender, year of birth,
	 *		first name, middle name and last name.
	 *	@param id the id number of the citizen.
	 * 	@param fN - the first name of the citizen.
	 *	@param mN - the middle name of the citizen.
	 *	@param lN - the last name of the citizen.
	 *	@param gender - the citizen's gender.
	 *	@param YOB - the citizen's year of birth.
	 *	@param lifeStatus - the life status of the person.
	 * 	@param address1 - the street of a citizen's address.
	 * 	@param address2 - the town of a citizen's address.
	 *  @param address3 - the zone of a citizen's address.
	 *  @param address4 - the country of a citizen's address.
	 *	@param motherID - the id of the citizen's mother.
	 *	@param fatherID - the id of the citizen's father.
	 
	*/
	public Citizen(String id, String fN, String mN, String lN, char gender, int YOB, char lifeStatus,
					String address1, String address2, String address3, String address4,
					String motherID, String fatherID)
	{
		/*	The following uses the contructor of the parent class Person */
		super(gender, YOB) ;
		if (YOB != 0)	// omit default parent data
			idGen++ ;

		/* Below is an assignment of an instance of the Name class 
			to the name attribute */
		name = new Name(fN, mN, lN) ;

		// Below is the assignment of the id number
		this.id = id ;

		if (lifeStatus == 'A')
			setLifeStatus(0) ;	// set life status to alive
		else
			setLifeStatus(0) ;	// set life status to alive
			
		setWedStatus(0) ;	// set wedStatus to single

		Address address = new Address(address1+"|"+ address2+"|"+ address3+"|"+ address4) ;
		setAddress(address) ;

	}

	/*
	 *	{@inheritDoc}
	*/
	@Override
	public String getId(){
		return this.id ;
	}

	/**
	 *	Gets the citizen's name.
	 *	@return A String comprising of the citizen's 
	 *		first name, middle name and last initial.
	*/
	public String getName(){
		return name.getLastName().toUpperCase()+", "
				+name.getMiddleName()+" "
				+name.getFirstName().charAt(0) ;
	}

	/**
	 *	Gets the citizen's name object.
	 *	@return A name object containing the citizen's 
	 *		first, middle and last name
	*/
	public Name getNames(){

		return name ;
	}

	/**
	 *	Gets the citizen's address.
	 *	@return An Address object representing the citizen's address.
	*/
	public Address getAddress(){
		return this.address ;
	}

	/**
	 *	Sets the citizen's address.
	 *	@param address - An address object representing the
	 *		citizen's address.
	*/
	public void setAddress(Address address){
		this.address = address ;

	}

	/**
	 *	Changes the citizen's last name.
	 *	@param newLast - A String representing the 
	 *		replacement last name.
	*/
	public void changeLastName(String newLast){
		name.setLastName(newLast) ;
	}

	/**
	 *	Determines whether the id of a given Person object
	 *		is identical to that of the person.
	 *	@param other - A Person object.
	 *	@return An integer representing the result of 
	 *		comparing the id details of the given Citizen object 
	 *		to that of the citizen, lexicographically.
	*/
	@Override
	public int compareTo(Person other){
		return Integer.valueOf(this.id) - Integer.valueOf(other.getId())  ;
		//return this.id.compareTo( other.getId() ) ;
	}

	/**
	 *	Returns a formatted string containing information
	 *		for the citizen.
	 *	@return A string comprised of the name, address,
	 *		year of birth, gender, life status, mother 
	 *		and father information for a citizen.
	*/  
	public String toString(){
		
		return ("Reference number: "+id+"\n"
			+"Name: "+name.toString()+"\n"
			+"Address: "+address.toString()+"\n"
			+"Year of birth: "+getYOB()+"\n"
			+"Gender: "+Character.toString( getGender() )+"\n"
			+"LifeStatus: "+Character.toString( getLifeStatus() )+"\n"
			+"Mother: "+getParent('M')+"\n"
			+"Father: "+getParent('F') ) ;	

	}	

	 /**
	 *	Gets the reference number of a citizen.
	 *	@return A String representing the refNum for a citizen.
	*/
	public String getRefNo(){
		return id ;
	}


}	//	end of Citizen class