package hw1;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;


/**
 * An Inventory implemented using a <code>HashMap&lt;Video,Record&gt;</code>.
 * Keys are Videos; Values are Records.
 *
 * @objecttype Mutable Collection of Records
 * @objectinvariant
 *   Every key and value in the map is non-<code>null</code>.
 * @objectinvariant
 *   Each value <code>r</code> is stored under key <code>r.video</code>.
 */
final class InventorySet {
  /** @invariant <code>_data != null</code> */
  private final Map<VideoObj,Record> _data;

  InventorySet() {
    _data = new HashMap<VideoObj,Record>();
  }

  /**
   * Return the number of Records.
   */
  public int size() {
    // seen as Records are Values in this HashMap, we need them and the size  
    return _data.values().size();
  }

  /**
   * Return a copy of the record for a given Video.
   */
  public Record get(VideoObj v) {
	// copy is made, passed the result, and then copy is returned
	  Record r = _data.get(v);
    return r;
  }

  /**
   * Return a copy of the records as a collection.
   * Neither the underlying collection, nor the actual records are returned.
   */
  public Collection<Record> toCollection() {
    // Recall that an ArrayList is a Collection.
    // created an ArrayList seen as it was recommended, then passed it and cast it, then returned it
	  ArrayList<Record> copy = (ArrayList<Record>) _data.values();
	
    return copy;
  }

  /**
   * Add or remove copies of a video from the inventory.
   * If a video record is not already present (and change is
   * positive), a record is created. 
   * If a record is already present, <code>numOwned</code> is
   * modified using <code>change</code>.
   * If <code>change</code> brings the number of copies to be less
   * than one, the record is removed from the inventory.
   * @param video the video to be added.
   * @param change the number of copies to add (or remove if negative).
   * @throws IllegalArgumentException if video null or change is zero
   * @postcondition changes the record for the video
   */
  public void addNumOwned(VideoObj video, int change) {
    
	  // checks the arguments
	  if(video==null || change==0) {
    	throw new IllegalArgumentException("video == null or change == 0");
    }
	  // first check is Inventory contains the video and is change is positive
	  if(_data.containsKey(video)==false && change > 0) {
		
		  //if true, then create new Record for given VideoObj.
		  Record newEntry = new Record(video, change, 0, 0);
		
		  //add the new <VideoObj, Record> pair to the data
		  _data.putIfAbsent(video, newEntry);
	  }
	 
	  //second check: if Record is present modify numOwned
	  else if(_data.containsValue(_data.get(video))) {
		
		// create a copy of the Record
		Record copy = _data.get(video);
		
		// change the numOwned value in copy to the specified amount
		copy.numOwned = copy.numOwned + change;
		
		// checks to see if change is less than 1, and then removes the Record from the data
		if(copy.numOwned < 1) {
			_data.remove(video, _data.get(video));
		} 
		else {
			_data.replace(video, _data.get(video), copy);
		}
	}
	
  }

  /**
   * Check out a video.
   * @param video the video to be checked out.
   * @throws IllegalArgumentException if video has no record or numOut
   * equals numOwned.
   * @postcondition changes the record for the video
   */
  public void checkOut(VideoObj video) {
    
	  // check variants, and to see if all copies are out
	  if(_data.get(video)==null || _data.get(video).numOut == _data.get(video).numOwned) {
    	throw new IllegalArgumentException("The video has no Record or All Copies are Out");
    }
    
    // if there are copies available then modify the numOut of the Record 
	  else if(_data.get(video).numOut < _data.get(video).numOwned) {
		  _data.get(video).numOut = _data.get(video).numOut + 1;
	  }
	
  }
  
  /**
   * Check in a video.
   * @param video the video to be checked in.
   * @throws IllegalArgumentException if video has no record or numOut
   * non-positive.
   * @postcondition changes the record for the video
   */
  public void checkIn(VideoObj video) {
    
	  // checks variants
	  if(_data.get(video)==null || _data.get(video).numOut <= 0) {
		  throw new IllegalArgumentException("There is no Record or numOut is non-positive");
	  }
	  
	  // check the video back in
	  _data.get(video).numOut = _data.get(video).numOut - 1;
	  
  }
  
  /**
   * Remove all records from the inventory.
   * @postcondition <code>size() == 0</code>
   */
  public void clear() {
    _data.clear();  
  }

  /**
   * Return the contents of the inventory as a string.
   */
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("Database:\n");
    for (Record r : _data.values()) {
      buffer.append("  ");
      buffer.append(r);
      buffer.append("\n");
    }
    return buffer.toString();
  }
}
