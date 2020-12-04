
package PhoneBookRough;

public class Address
{
	private String street;
	private String cityName;
	private String stateName;
	
	private long   zipCode;
	
	Address(){}
	
	Address(String street, String cityName, String stateName, long zipCode)
	{
		
		this.street 	= street;
		this.cityName 	= cityName;
		this.stateName 	= stateName;
	
		this.zipCode 	= zipCode;
	}

	public String getStreet() 
	{
		return street;
	}

	public String getCityName() 
	{
		return cityName;
	}

	public String getStateName() 
	{
		return stateName;
	}

	public long getZipCode() 
	{
		return zipCode;
	}

	public void setStreet(String address) 
	{
		this.street = address;
	}

	public void setCityName(String cityName) 
	{
		this.cityName = cityName;
	}

	public void setStateName(String stateName) 
	{
		this.stateName = stateName;
	}

	public void setZipCode(long zipCode) 
	{
		this.zipCode = zipCode;
	}
	
	
	
	
	
}
