
package PhoneBookRough;

import java.util.regex.*;

public class Validation 
{
	
	//this method matches a given string against special characters. 
	//If special characters are found it returns false
	public static boolean stringValidation(String stringToValidate) 
	{
		Pattern pattern 	= Pattern.compile("[\\%\\&\\;\\:\\[\\]\\{\\}\\?\\^\\#\\@\\!\\`\\~\\<\\>\\/\\,\\*\\|\\=\\+\\-\\_\\(\\)]");
		Matcher matcher 	= pattern.matcher(stringToValidate);
		
		boolean matchFound 	= matcher.find();
		
		
	    if(stringToValidate == null || stringToValidate.equals(""))
		{
			return false;
		}
	    else if(matchFound == true) 
		{
			return false;
		}
	    else return true;
	}
	//this method matches a given string to see if it has the proper number of digits for a zip code. 
	//if a match is found it returns true.
	public static boolean zipCodeValidation(String stringToValidate) 
	{
		Pattern pattern 	= Pattern.compile("^\\d{5}(-\\d{4})?$");
		Matcher matcher 	= pattern.matcher(stringToValidate);
		
		boolean matchFound 	= matcher.find();
		
		
		if(stringToValidate == null || stringToValidate.equals(""))
		{
			return false;
		}
		else if(matchFound == true) 
		{
			return true;
		}
		else return false;
	}
	//this method matches a given string to see if it has the proper number of digits for a phone number. 
	//if a match is found it returns true.
	public static boolean phoneNumberValidation(String stringToValidate) 
	{
		Pattern pattern 	= Pattern.compile("^^\\D?(\\d{3})\\D?\\D?(\\d{3})\\D?(\\d{4})$");
		Matcher matcher 	= pattern.matcher(stringToValidate);
		
		boolean matchFound 	= matcher.find();
		
		if(stringToValidate == null || stringToValidate.equals(""))
		{
			return false;
		}
		else if(matchFound == true) 
		{
			return true;
		}
		else return false;
	}
	
	

}
