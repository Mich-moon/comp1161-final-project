package snid;

/**
 *	Marriage is a class representing a marriage 
 *      between two citizens.			
 *
 *	@author		Michaela Wright
 *	@version 1.0
*/

public class MarriageCertificate implements CivicDoc
{
    protected static int refNoGen = 0 ;
    private String refNo,  groom, bride, date ;
      
    /**
     *	Creates a MarriageCertificate object with the specified groom id,
     *      bride id and date of marriage.
     *	@param gr - the id number of the groom.
     *	@param br - the id number of the bride.
     *  @param dt - the date of the wedding.
    */
    public MarriageCertificate(String gr, String br, String dt)
    {
        groom = gr ;
        bride = br ;
        date = dt ;

        refNo = Integer.toString(refNoGen++ ) ;
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
	 *	Gets the reference number for the marriage certificate.
	 *	@return A String representing the refernce number.
	*/
    public String getRefNo()
    {
        return refNo ;
    }

    /**
	 *	Gets the id number of the groom .
	 *	@return A String representing the id number.
	*/
    public String getGroom()
    {
        return groom ;
    }

    /**
	 *	Gets the id number of the bride .
	 *	@return A String representing the id number.
	*/
    public String getBride()
    {
        return bride ;
    }

    /**
	 *	Gets the date of the wedding .
	 *	@return A String representing the date.
	*/
    public String getDate()
    {
        return date ;
    }
    
}   // end of Marriage class