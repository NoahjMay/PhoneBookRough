
package PhoneBookRough;

public class Person extends Address
{
	private String firstName;
	private String lastName;
	private String fullName;
	
	private long   phoneNumber;
	
	Person()
	{
		super();
	}
	
	Person(String fullName, String address, String cityName, String stateName, long zipCode, long phoneNumber)
	{
		
		super(address, cityName,stateName, zipCode);
		
		this.fullName 			= fullName;
		
		this.phoneNumber 		= phoneNumber;
		
		String fullNameArray[] 	= fullName.split(" ");
		
		this.firstName 			= fullNameArray[0];
		
		this.lastName  			= fullNameArray[fullNameArray.length -1];
		
	}	
	
	
	
	public String getFirstName() 
	{
		return firstName;
	}


	public String getLastName() 
	{
		return lastName;
	}

	public String getFullName() 
	{
		return fullName;
	}

	public long getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;	
	}

	public void setFullName(String fullName) 
	{
		this.fullName = fullName;
	}

	public void setPhoneNumber(long phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	
	
	
}
