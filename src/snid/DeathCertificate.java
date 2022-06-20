package snid;

/**
 *	Death is a class representing the death 
 *      of a citizen.			
 *
 *	@author		Michaela Wright
 *	@version 1.0
*/

public class DeathCertificate implements CivicDoc
{
    protected static int refNoGen = 0 ;
    private String refNo, id, causeOfDeath, dateOfDeath, placeOfDeath ;

    /**
     *	Creates a DeathCetificate object with the specified id number,
     *      cause of death, date of death and place of death.
     *	@param idNum - the id number of the deceased citizen.
     *	@param cOD - the cause of death.
     *  @param dOD - the date of the death.
     *  @param pOD - the place of the death.
    */
    public DeathCertificate(String idNum, String cOD, String dOD, String pOD)
    {
        id = idNum ;
        causeOfDeath = cOD ;
        dateOfDeath = dOD ;
        placeOfDeath = pOD ;

        refNo = Integer.toString(refNoGen++ ) ;
    }

    /**
	 *	Gets the reference number for the death certificate .
	 *	@return A String representing the refernce number.
	*/
    public String getRefNo()
    {
        return refNo ;
    }

        /**
	 *	Sets the refernce number .
	*/
    public void setRefNo()
    {
        refNoGen++ ;
        this.refNo = Integer.toString(refNoGen) ;
    }
    
    /**
	 *	Gets the id number of the deceased .
	 *	@return A String representing the id number.
	*/
    public String getId()
    {
        return this.id ;
    }

    /**
	 *	Gets the cause of death for the death certificate .
	 *	@return A String representing the cause.
	*/
    public String getCause()
    {
        return causeOfDeath ;
    }

    /**
	 *	Gets the place of death for the death certificate .
	 *	@return A String representing the place.
	*/
    public String getPlace()
    {
        return placeOfDeath ;
    }

    /**
	 *	Gets the date of death for the death certificate .
	 *	@return A String representing the date.
	*/
    public String getDate()
    {
        return dateOfDeath ;
    }
       
}   // end of Death class