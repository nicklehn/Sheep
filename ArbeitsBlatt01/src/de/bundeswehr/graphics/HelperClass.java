package de.bundeswehr.graphics;
/**
 * Contains helper methods such as wait.
 * 
 * @author PSe
 *
 */
public class HelperClass {

	 /**
	   * Wait for a specified number of milliseconds before finishing.
	   * This provides an easy way to specify a small delay which can be
	   * used when producing animations.
	   * @param  milliseconds  the number 
	   */
	  public static void wait(int milliseconds)
	  {
	      try
	      {
	          Thread.sleep(milliseconds);
	      } 
	      catch (Exception e)
	      {
	          // ignoring exception at the moment
	      }
	  }
	  
}
