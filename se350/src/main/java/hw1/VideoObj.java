package hw1;

/**
 * Immutable Data Class for video objects.
 * Comprises a triple: title, year, director.
 *
 * @objecttype Immutable Data Class
 * @objectinvariant
 *   Title is non-null, no leading or final spaces, not empty string.
 * @objectinvariant
 *   Year is greater than 1800, less than 5000.
 * @objectinvariant
 *   Director is non-null, no leading or final spaces, not empty string.
 */
final class VideoObj implements Comparable<VideoObj> {
  /** @invariant non-null, no leading or final spaces, not empty string */
  private final String _title;
  /** @invariant greater than 1800, less than 5000 */
  private final int    _year;
  /** @invariant non-null, no leading or final spaces, not empty string */
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if any object invariant is violated.
   */
  VideoObj(String title, int year, String director) {
    
	//Initialize -title- attribute, but check for variants
	if (title==null || title.isEmpty()) {
		throw new IllegalArgumentException("title cannot be null or empty");
	} else {
		this._title = title.trim();
	}
    
	//Initialize -year- attribute, check variants
    if (year > 1800 && year < 5000) {
    	this._year = year;
    } else {
    	throw new IllegalArgumentException("year needs to be 1800<year<5000");
    }
    
    //Initialize -director- attribute, but check for invariants
    if (director==null || director.isEmpty()) {
		throw new IllegalArgumentException("director cannot be null or empty");
	} else {
		this._director = director.trim();
	}
     
  }

  /**
   * Return the value of the attribute.
   */
  public String director() {
    // simple return of the -director- attribute of the associated instance of VideoObj 
    return this._director;
  }

  /**
   * Return the value of the attribute.
   */
  public String title() {
    // simple return of the -title- attribute of the associated instance of VideoObj
    return this._title;
  }

  /**
   * Return the value of the attribute.
   */
  public int year() {
    // simple return of the -year- attribute of the associated instance of VideoObj  
    return this._year;
  }

  /**
   * Compare the attributes of this object with those of thatObject.
   * @param thatObject the Object to be compared.
   * @return deep equality test between this and thatObject.
   */
  public boolean equals(Object thatObject) {
    // quick check to see if they are the same Object 
	if(this == thatObject) {
		return true;
	}
	// making sure that is what we are comparing to is a null value
	if(thatObject == null) {
		return false;
	}
	// two Objects are incomparable if they are not even of the same Object type, this checks that
	if (!(thatObject instanceof VideoObj)) { 
        return false; 
    } 
	
	/* 
	 *  creates a copy -c- of -thatObject- and then typeCasts it to a VideoObj so that proper comparisons on
	 *  their respective attributes can be made without error
	 */ 
	VideoObj c = (VideoObj) thatObject;
	
	// return statement that (if ANY are false) terminates with false. Yet if ALL are true returns with true
	return this._director.compareTo(c._director) == 0 && this._title.compareTo(c._title) == 0
            && Integer.compare(this._year,  c._year) == 0;
	
  }

  /**
   * Return a hash code value for this object using the algorithm from Bloch:
   * fields are added in the following order: title, year, director.
   */
  private int hcode;
  public int hashCode() {
    if (hcode == 0) {
      hcode = 17;
      hcode = 37*hcode + _title.hashCode();
      hcode = 37*hcode + Integer.valueOf(_year).hashCode();
      hcode = 37*hcode + _director.hashCode();
    }
    return hcode;
  }

  /**
   * Compares the attributes of this object with those of thatObject, in
   * the following order: title, year, director.
   * @param thatObject the Object to be compared.
   * @return a negative integer, zero, or a positive integer as this
   *  object is less than, equal to, or greater thatObject.
   * @throws ClassCastException if thatObject has an incompatible type.
   */
  public int compareTo(VideoObj thatObject) {
	// just a quick check to make sure they are both VideoObj *optional
	  if (!(thatObject instanceof VideoObj)) { 
	        throw new ClassCastException("The Object argument is not of type VideoObj"); 
	} 
	
	//compare the results of the titles and return if they aren't the same
	int result_title = _title.compareTo(thatObject._title);
	if(result_title != 0) {
		return result_title;
	}
	
	//compare the results of the years and return if they aren't the same
	int result_year = Integer.compare(_year, thatObject._year);
	if(result_year != 0) {
		return result_year;
	}
	
	//compare the results of director and if they aren't same, return
	int result_director = _director.compareTo(thatObject._director);
	if(result_director != 0) {
		return result_director;
	}
	
	//all test were conducted and nothing returned so they must be the same
	return 0;
  }

  /**
   * Return a string representation of the object in the following format:
   * <code>"title (year) : director"</code>.
   */
  public String toString() {
    // returns a readable String based on template above 
	  StringBuffer buffer = new StringBuffer();
	    buffer.append(_title);
	    buffer.append(" (");
	    buffer.append(_year);
	    buffer.append(") : ");
	    buffer.append(_director);
	    
	    return buffer.toString();
  }
}
