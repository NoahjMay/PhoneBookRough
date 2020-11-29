
package PhoneBookRough;

public class Address
{
	private String address;
	private String cityName;
	private String stateName;
	
	private long   zipCode;
	
	Address(){}
	
	Address(String address, String cityName, String stateName, long zipCode)
	{
		
		this.address 	= address;
		this.cityName 	= cityName;
		this.stateName 	= stateName;
	
		this.zipCode 	= zipCode;
	}

	public String getAddress() 
	{
		return address;
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

	public void setAddress(String address) 
	{
		this.address = address;
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
