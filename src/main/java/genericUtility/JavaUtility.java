package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class consists of generic method related to java
 * @author Vikas
 *
 */

public class JavaUtility {
	
	/**
	 * this method will generate a random number  for every run and return into the caller 
	 * @return
	 */
	
	public int getRandomNumber() {
		Random ran=new Random();
		int r=ran.nextInt(1000);
		return r;
	}
	/**
	 * This method will capture the current system date in required format
	 * @return
	 */
	
	public String getSystemDate() {
	Date d = new Date();
	SimpleDateFormat formate=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	String date = formate.format(d);
	return date;
	}

}
