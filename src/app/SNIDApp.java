package app;

import data.* ;
import snid.*;
import java.util.ArrayList ;
import java.util.Collections;

/**
 *	SNIDApp represents an object that knows how to
 *      manage data.
 *
 *	@author	   Michaela Wright 620127969
 *	@version   1.0
**/

public class SNIDApp 
{
  private SNIDDb data ;
  private ArrayList<Citizen> records = new ArrayList<Citizen>() ;
  private ArrayList<MarriageCertificate> marriageList = new ArrayList<MarriageCertificate>() ;
  private ArrayList<DeathCertificate> deathList = new ArrayList<DeathCertificate>() ;

  /**
   *	Creates a SNIDApp object with the specified fileName
   *      and delimter.
	 *	@param fileName - the name of the file to be opened.
	 *	@param delimiter - the delimter to be used in reading.
	**/
  public SNIDApp(String fileName, char delimiter)
  {
    // create a SNIDDb object
    data = new SNIDDb(fileName, delimiter) ;

    while (data.hasNext() == true)
    { 
      try
      {
        // reads a line of data from the SNIDDb object
        String[] info = data.getNext() ; 

        String id = info[0] ; // id
        String fN = info[1] ; // first name
        String mN = info[2] ; // middle name
        String lN = info[3] ; // last name

        // convert String to character
        char gender = info[4].charAt(0) ;  // gender

        // convert String to integer
        int YOB =  Integer.parseInt(info[5]) ;  // year of birth

        char lStatus = info[6].charAt(0) ;  // life status

        String a1 = info[7] ; // street
        String a2 = info[8] ; // town
        String a3 = info[9] ; // zone
        String a4 = info[10] ;  // country
        String mID = info[11] ;   // mother's id
        String fID =info[12] ;  // father'a id

        Citizen citizen = new Citizen(id, fN, mN, lN, gender, YOB, lStatus, a1, a2, a3, a4, mID, fID) ;
        // adding default parent info
        citizen.setParent('M', new Citizen(mID, " ", " ", " ", 'F', 0, 'A', " "," "," "," "," "," " ) ) ;
        citizen.setParent('F', new Citizen(fID, " ", " ", " ", 'F', 0, 'A', " "," "," "," "," "," " ) ) ;

        records.add(citizen) ;

      } // end of try block
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
      catch(NullPointerException e3)
      {
        System.out.println(e3.getMessage()) ;
        e3.printStackTrace() ;
      }
            
    } // end of while loop

    Collections.sort(records) ;
  } // end of method

  /**
	 *	Adds a new citizen to the system using the specified gender, year of birth,
	 *		first name, middle name, last name. .
	 *	@param gender - the citizen's gender.
	 *	@param yob - the citizen's year of birth.
	 *	@param fName - the first name of the citizen.
	 *	@param mName - the middle name of the citizen.
	 *	@param lName - the last name of the citizen.
  **/
  
  public void registerBirth(char gender, int yob, String fName, String mName, String lName)
  {
    Citizen citizen = new Citizen(gender, yob, fName, mName, lName) ;

    // sets the life status to alive
    citizen.setLifeStatus(0) ;

    // adds a default address
    Address address = new Address(" | | | ") ;
    citizen.setAddress(address) ;
    // adding default parent info
    citizen.setParent('M', new Citizen(" ", " ", " ", " ", 'F', 0, 'A', " "," "," "," "," "," " ) ) ;
    citizen.setParent('F', new Citizen(" ", " ", " ", " ", 'F', 0, 'A', " "," "," "," "," "," " ) ) ;

    records.add(citizen) ;    
  }

  /**
	 *	Searches for a citizen using the specifies if number.
	 *	@param id - the citizen's id.
	 *	@return A Citizen object that has the id number.
  **/
  private Citizen find(String id)
  {
    int pos =  Collections.binarySearch(records, new Citizen(id, "", "", "", 'F', 0, 'D', "", "", "", "", "", "") ) ;

    if (pos >= 0)
      return records.get(pos) ;
    else
      return null ;
/*
    for (int i = 0; i < records.size(); i++)
    {
      if ( records.get(i).getId().equals(id) )
        return records.get(i) ;
    }
    return null ;   */
  }

  /**
	 *	Adds parental information for a citizen.
	 *	@param id - the citizen's id.
	 *	@param father - the id number for the citizen's father.
	 *	@param mother - the id number for the citizen's mother.
  **/
  public void addParentData(String id, String father, String mother)
  {
    Citizen child = find(id) ; 

    if (child == null)
      System.out.println("\n The person was not found \n") ;
    else
    {
      Citizen mom = find(mother) ;
      if (mother != null)
        child.setParent('M', mom) ;

      Citizen dad = find(father) ;
      if (father != null)
        child.setParent('F', dad) ;

    }
  }

  /**
	 *	Adds address information for a citizen.
	 *	@param id - the citizen's id number.
	 *	@param st - the citizen's street address.
	 *	@param tn - the citizen's town or city.
	 *	@param pa - the citizen's parish or county.
	 *	@param c - the citizen's country.
  **/
  public void updateAddress(String id, String st, String tn, String pa, String c)
  {
    Citizen search = find(id) ;

    if ( search != null )
    {
      // form a String where the fields are separated by "|"
      String line = st+"|"+tn+"|"+pa+"|"+c ;

      Address address = new Address(line) ;
      search.setAddress(address) ;
    }
    else
      System.out.println("\n Citizen not found\n") ;
  }

  /**
	 *	Records a marriage between two citizens.
	 *	@param groomId - the id number of the groom.
	 *	@param brideId - the id number of the bride.
	 *	@param date - the date of the marriage.
  */
  public void registerMarriage(String groomId, String brideId, String date)
  {
    Citizen groom = find(groomId) ;
    Citizen bride = find(brideId) ;

    if ( groom != null && bride != null )
    {
      try{
        // sets the person's wed status to married.
        groom.setWedStatus('1') ;
        bride.setWedStatus('1') ;
        
        // obtains groom's names and changes bride's last name
        bride.changeLastName(groom.getNames().getLastName() ) ; // change bride's last name to groom's last name
  
        // records the marriage.
        MarriageCertificate marriage = new MarriageCertificate(groomId, brideId, date) ;
        marriage.setRefNo() ;
        marriageList.add(marriage) ;
      }
      catch(IndexOutOfBoundsException e1)
      {
        System.out.println(e1.getMessage()) ;
        e1.printStackTrace() ;
      }
      catch(NullPointerException e3)
      {
        System.out.println(e3.getMessage()) ;
        e3.printStackTrace() ;
      }
    }
  }

  /**
	 *	Records the death of a citizen.
	 *	@param id - the id number of the deceased citizen.
	 *	@param cause - the cause of death.
   *	@param place - the place of the death.
   *  @param date - the date of the death.
  */
  public void registerDeath(String id, String cause, String place, String date)
  {
    Citizen search = find(id) ;

    if ( search != null )
    {
      // sets the person's life status to dead
      search.setLifeStatus(1) ;

      // records the death
      DeathCertificate death = new DeathCertificate(id, cause, place, date) ;
      death.setRefNo() ;
      deathList.add(death) ;

    }
    else
      System.out.println("\n Citizen not found \n") ;   
  }

  /**
   *	Gets the citizen's mother and returns a formated String with
   *    her information.
   *	@param id - the id number of the mother.
   *  @return A String formatted like "id,firstName,middleName,lastName".
  */
  public String getMother(String id)
  {
    Citizen search = find(id) ;

    if ( search != null )
    {
      try{
        Citizen mother = find( search.getParent('M').getId() ) ;
        Name names = mother.getNames() ;
  
        String result = mother.getId()+","
                        +names.getFirstName()+","
                        +names.getMiddleName()+","
                        +names.getLastName()+"," ;
        return result ;
      }
      catch(IndexOutOfBoundsException e1)
      {
        System.out.println(e1.getMessage()) ;
        e1.printStackTrace() ;
      }
      catch(NullPointerException e2)
      {
        System.out.println(e2.getMessage()) ;
        e2.printStackTrace() ;
      }
    }
    return "" ;    
  }

  /**
   *	Gets the citizen's father and returns a formated String with
   *    his information.
   *	@param id - the id number of the father.
   *  @return A String formatted like "id,firstName,middleName,lastName".
  */
  public String getFather(String id)
  {
    Citizen search = find(id) ;

    if ( search != null )
    {
      try{
        Citizen father = find ( search.getParent('F').getId() ) ;
        Name names = father.getNames() ;
  
        String result = father.getId()+","
                        +names.getFirstName()+","
                        +names.getMiddleName()+","
                        +names.getLastName()+"," ;
        return result ;
      }
      catch(IndexOutOfBoundsException e1)
      {
        System.out.println(e1.getMessage()) ;
        e1.printStackTrace() ;
      }
      catch(NullPointerException e2)
      {
        System.out.println(e2.getMessage()) ;
        e2.printStackTrace() ;
      }
    }
    return "" ;
  }

  /**
   *	Gets mailing information for a citizen.
   *	@param id - the id number of the citizen.
   *  @return A String formatted like a mailing label.
  */
  public String mailingLabel(String id)
  {
    Citizen citizen = find(id) ;

    if ( citizen != null )
    {
      try{
        Name names = citizen.getNames() ;
        String result = names.getLastName().toUpperCase()+", "
                        +names.getMiddleName()+" "
                        +names.getFirstName()+"\n"
                        +citizen.getAddress().toString() ;
  
        return result ;
      }
      catch(IndexOutOfBoundsException e1)
      {
        System.out.println(e1.getMessage()) ;
        e1.printStackTrace() ;
      }
      catch(NullPointerException e2)
      {
        System.out.println(e2.getMessage()) ;
        e2.printStackTrace() ;
      }
    }
    return "" ;
  }

  /**
   *	Searches for a citizen using the specified id number.
   *	@param key - the id number of the citizen.
   *  @return A formatted String containing id, gender, first name,
   *    middle name, last name (in that order).
  */
  public String search(String key)
  {
    Citizen citizen = null ;

    for (int i = 0; i < records.size(); i++)
    {
      if ( records.get(i).getId().equals(key) )
      {
        citizen = records.get(i) ;

        try{
          Name names = citizen.getNames() ;
          String result = citizen.getId()+","
                        +String.valueOf( citizen.getGender() )+","
                        +names.getFirstName()+","
                        +names.getMiddleName()+","
                        +names.getLastName() ;
          
          return result ;
        }
        catch(IndexOutOfBoundsException e1)
        {
          System.out.println(e1.getMessage()) ;
          e1.printStackTrace() ;
        }
        catch(NullPointerException e3)
        {
          System.out.println(e3.getMessage()) ;
          e3.printStackTrace() ;
        }
      }
    }
    return "" ;
  }

  /**
   *	Searches for one or more citizens having the specified last name.
   *	@param firstName - the first name of the citizen.
   *	@param lastName - the last name of the citizen.
   *  @return An array of formatted Strings containing id, gender, first name,
   *    middle name, last name (in that order).
  */
  public String[] search(String firstName, String lastName)
  {
    ArrayList<String> list = new ArrayList<String>() ;
    String[] result ;

    try
    {
      // add successful search results to an arraylist.
      for (int i = 0; i < records.size(); i++)
      {
        Citizen citizen = records.get(i) ;
        Name names = citizen.getNames() ;

        if ( names.getLastName().equals(lastName) )
        {
          String res = citizen.getId()+","
          +String.valueOf( citizen.getGender() )+","
          +names.getFirstName()+","
          +names.getMiddleName()+","
          +names.getLastName() ;

          list.add(res) ;
        }
      } // end of for loop

      if (list.size() > 0 )
      {
        // Create array with size of the array list.
        result = new String[list.size()] ;

        // Convert the arraylist to an array.
        result = list.toArray(result) ;
        return result ;
      }
    }// end of try block
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
    catch(NullPointerException e3)
    {
      System.out.println(e3.getMessage()) ;
      e3.printStackTrace() ;
    }  
    return null ;
  }

  /**
   *  Saves the data to file and closes the application.
   */
  public void shhutDown()
  {
    // Closes the file and reopens it for data to be written to it.
    data.rewrite() ;

    String[] result = new String[13];

    try{
      for (int i = 0; i < records.size(); i++)
      {
        Citizen citizen = records.get(i) ;
        String[] address = citizen.getAddress().toString().split("\n") ;
  
        // adding the data to the array
        result[0] = citizen.getId() +"|" ;
        result[1] = citizen.getNames().getFirstName() +"|" ;
        result[2] = citizen.getNames().getMiddleName() +"|" ;
        result[3] = citizen.getNames().getLastName() +"|" ;
        result[4] = String.valueOf( citizen.getGender() ) +"|" ;
        result[5] = Integer.toString( citizen.getYOB() ) +"|" ;
        result[6] = citizen.getLifeStatus() +"|";
        result[7] = address[0] +"|" ;
        result[8] = address[1] +"|" ;
        result[9] = address[2] +"|" ;
        result[10] = address[3] +"|" ;
        result[11] = citizen.getParent('M').getId() +"|" ;
        result[12] = citizen.getParent('F').getId() ;
  
        data.putNext(result) ;
      }
    }// end of try block
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
    catch(NullPointerException e3)
    {
      System.out.println(e3.getMessage()) ;
      e3.printStackTrace() ;
    }
    
    data.close() ;
  }

}