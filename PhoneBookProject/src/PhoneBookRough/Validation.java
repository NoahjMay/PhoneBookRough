
package PhoneBookRough;

import java.util.regex.*;

public class Validation 
{
	
	
	public static boolean stringValidation(String stringToValidate) 
	{
		Pattern pattern 	= Pattern.compile("^[a-zA-Z]", Pattern.CASE_INSENSITIVE);
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
	public static boolean streetValidation(String stringToValidate) 
	{
		Pattern pattern 	= Pattern.compile("^\\d{1,6}\\040([A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,})$|^\\d{1,6}\\040([A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,}"
				+ "\\040[A-Z]{1}[a-z]{1,})$|^\\d{1,6}\\040([A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,})$");
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
