

package PhoneBookRough;

import java.util.*;

public class PhoneBook
{

	public static void main(String[] args) 
	{
		Scanner menuInputScanner 			= new Scanner(System.in);
		Scanner consoleinputScanner 		= new Scanner(System.in);	
		Scanner consoleStringInputScanner 	= new Scanner(System.in);
		
		runConsoleCommands(menuInputScanner, consoleinputScanner, consoleStringInputScanner);
		
		menuInputScanner.close();
		consoleinputScanner.close();
		consoleStringInputScanner.close();
	}
	
	private static Person personArrary[] = new Person[1];
	private static int personCount;

	// This method takes scanner objects from the main method and runs other methods based on the user input from a menu that runs in a loop until exited.
	public static void runConsoleCommands(Scanner menuInputScanner, Scanner consoleinputScanner, Scanner consoleStringInputScanner) 
	{
		String exit 								= " 0: Exit the phonebook.\n";
		String addNewEntry 							= " 1: Add a new person to the phonebook.\n";
		String existingEntrySearch 					= " 2: Search for a person in the phonebook by every data point. \n";
		String firstNameSearch 						= " 3: Search for a person in the phonebook by their first name.\n";
		String lastNameSearch 						= " 4: Search for a person in the phonebook by their last name.\n";
		String fullNameSearch 						= " 5: Search for a person in the phonebook by their full name.\n";
		String telephoneNumberSearch 				= " 6: Search for a person in the phonebook by a telephone number.\n";
		String cityStateSearch 						= " 7: Search for a person in the phonebook by the city or state name.\n";
		String deleteRecordByTelephoneNumber 		= " 8: Delete a record by the records telephone number.\n";
		String updateRecordByTelephoneNumber 		= " 9: Update a record by the records telephone number.\n";
		String displayRecordsDecendingOrderedByName	= "10: Display records in descending order by name.\n";	
		String menuCommand 							= "default";
		
		while(menuCommand != "exit")
		{
			
			
			System.out.println(exit + addNewEntry + existingEntrySearch + firstNameSearch + lastNameSearch + fullNameSearch + 
					   telephoneNumberSearch + cityStateSearch + deleteRecordByTelephoneNumber + updateRecordByTelephoneNumber +
					   displayRecordsDecendingOrderedByName);
							   
			System.out.print("Choose a number for an action from the above list: ");
			
			menuCommand = menuInputScanner.nextLine().trim();
			
			if(menuCommand.equals("0") || menuCommand.equals("1") || menuCommand.equals("2") || menuCommand.equals("3") || menuCommand.equals("4") || 
					menuCommand.equals("5") || menuCommand.equals("6") || menuCommand.equals("7") || menuCommand.equals("8") || 
					menuCommand.equals("9") || menuCommand.equals("10")) 
			{
				System.out.print("\nYou chose: ");		
			}
			else System.out.println("\nYou did not input a proper number from the menu.\n");	
			
			
			try 
			{
				
				switch (menuCommand) 
				{

				case "0":
					
					System.out.println(exit);
					menuCommand = "exit";
					break;
					
				case "1":
					
					System.out.println(addNewEntry);
					addNewEntry(consoleInputForAPerson(consoleinputScanner));
					
					break;
					
				case "2":
					
					System.out.println(existingEntrySearch);
					existingEntrySearch(consoleInputForAPerson(consoleinputScanner));
					
					break;
					
				case "3":
					
					System.out.println(firstNameSearch);
					firstNameSearch(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "4":
					
					System.out.println(lastNameSearch);
					lastNameSearch(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "5":
					
					System.out.println(fullNameSearch);
					fullNameSearch(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "6":
					
					System.out.println(telephoneNumberSearch);
					telephoneNumberSearch(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "7":
					
					System.out.println(cityStateSearch);
					cityStateSearch(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "8":
					
					System.out.println(deleteRecordByTelephoneNumber);
					deleteARecordByItsTelephoneNumber(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "9":
					
					System.out.println(updateRecordByTelephoneNumber);
					updateARecordByItsTelephoneNumber(consoleStringInputForSearching(consoleStringInputScanner),
					consoleInputForAPerson(consoleinputScanner));
					
					break;
					
				case "10":
					
					System.out.println(displayRecordsDecendingOrderedByName);
					sortPersonArraryByFullName();
					
					for (int index = 0; index < personArrary.length; index++) 
					{
						displayPerson(index);
					}
					break;
		

				}
			}
			catch (Exception e) 
			{	
				if(menuCommand.equals("1")) {
					System.out.println("There was an error while trying to add a new person to the phone book.\n");
				}
				else if(menuCommand.equals("2")) {
					System.out.println("There was an error while trying to Search for a person in the phonebook by every data point.\n");
				}
				else if(menuCommand.equals("3")) {
					System.out.println("There was an error while trying to search for a person in the phonebook by their first name.\n");
					
				}
				else if(menuCommand.equals("4")) {
					System.out.println("There was an error while trying to search for a person in the phonebook by their last name.\n");
					
				}
				else if(menuCommand.equals("5")) {
					System.out.println("There was an error while trying search for a person in the phonebook by their full name.\n");
					
				}
				else if(menuCommand.equals("6")) {
					System.out.println("There was an error while trying to search for a person in the phonebook by a telephone number.\n");
				}
				else if(menuCommand.equals("7")) {
					System.out.println("There was an error while trying to search for a person in the phonebook by the city or state name.\n");
				}
				else if(menuCommand.equals("8")) {
					System.out.println("There was an error while trying to delete a record by the records telephone number.\n");
				}
				else if(menuCommand.equals("9")) {
					System.out.println("There was an error while trying to update a record by the records telephone number.\n");
				}
				else if(menuCommand.equals("10")) {
					System.out.println("There was an error while trying to display records in descending order by name.\n");
				}
				

			}
		}
	}
	
	//This method prompts the user for formated input it takes the next line as an array of strings and parses the
	//data that should be integers into longs. it then calls the Person constructor and returns a person object.
	public static Person consoleInputForAPerson(Scanner consoleinputScanner) 
	{
		System.out.println("Please input values for a person coma seperated with"
				+ " a leading space for each value after the full name.\ni.e. "
				+ "full name, address, city, state, zip code, phone number");
		
		String stringInputArray[] = consoleinputScanner.nextLine().split(",");
		
		String 	fullName 	= stringInputArray[0].trim();
		String 	address 	= stringInputArray[1].trim();
		String 	cityName 	= stringInputArray[2].trim();
		String 	stateName 	= stringInputArray[3].trim();
		
		long 	zipCode 	= Long.parseLong(stringInputArray[4].trim());
		long 	phoneNumber = Long.parseLong(stringInputArray[5].trim());
		
		Person newPerson = new Person(fullName, address, cityName, stateName, zipCode, phoneNumber);
		return newPerson;	
	}
	
	//This method prompts the user for data and then returns a string from the command console.
	public static String consoleStringInputForSearching(Scanner consoleStringInput) 
	{
		System.out.print("please input the data you chose to search by.");
		String stringInputArray = consoleStringInput.nextLine().trim();
		
		String 	searchString = stringInputArray;
		
		return searchString;
	}
	
	//This method creates a new array of person objects, with an increased size based on the personCount it then
	// adds every current object in the static array of person objects (personArrary) to the new array. 
	//After that it sets the new array to the static array.
	public static void addNewEntry(Person newPerson) 
	{	
		
		personCount++;
		
		Person newPersonArrary[] = new Person[personCount]; 
		
		for (int index = 0; index < personArrary.length; index++) 
		{
			newPersonArrary[index] = personArrary[index];

		}
		newPersonArrary[newPersonArrary.length - 1] = newPerson;		
		System.out.println();		
		personArrary = newPersonArrary;
				
	}
	
	//This method searches every value of the static array of person objects for objects that have all the same data and 
	//displays every record that matches along the way.
	public static void existingEntrySearch(Person personSearch) 
	{	
			
		String 	fullName 	= personSearch.getFullName().toLowerCase();
		String 	address 	= personSearch.getAddress().toLowerCase();
		String 	cityName 	= personSearch.getCityName().toLowerCase();
		String 	stateName 	= personSearch.getStateName().toLowerCase();
			
		long 	zipCode 	= personSearch.getZipCode();
		long 	phoneNumber = personSearch.getPhoneNumber();
		
		System.out.println("This person is already in this phone book.");
		for (int index = 0; index < personArrary.length; index++) 
		{
			
			if(personArrary[index].getFullName().toLowerCase().equals(fullName) && personArrary[index].getAddress().toLowerCase().equals(address)		&&
			   personArrary[index].getCityName().toLowerCase().equals(cityName)	&& personArrary[index].getStateName().toLowerCase().equals(stateName)	&&
	           personArrary[index].getZipCode()  == 				  zipCode	&& personArrary[index].getPhoneNumber() == 				   phoneNumber	) 
			{
				displayPerson(index);
			}
			if (index == personArrary.length) 
			{
				System.out.println("This person is not in the phone book.");
			}
		}
		
		

	}
	
	//This method searches every value of the static array of person objects for objects that have the same first name and 
	//displaying records that match along the way.
	public static void firstNameSearch(String firstNameSearch) 
	{
		
		System.out.println("The person or people with this first name are.");
		for (int index = 0; index < personArrary.length; index++) 
		{
			String firstName = personArrary[index].getFirstName().toLowerCase();
			if(firstName.equals(firstNameSearch.toLowerCase())) 
			{
				
				displayPerson(index);
			}
			if (index == personArrary.length) 
			{
				System.out.println("A person with this first name is not in the phone book.");
			}
		}
		
	}
	
	//This method searches every value of the static array of person objects for objects that have the same last name and 
	//displaying records that match along the way.
	public static void lastNameSearch(String lastNameSearch) 
	{
		System.out.println("The person or people with this last name are.");
		for (int index = 0; index < personArrary.length; index++) 
		{
			String lastName = personArrary[index].getLastName().toLowerCase();
			
			if(lastName.equals(lastNameSearch.toLowerCase())) 
			{
				displayPerson(index);
			} 
			if (index == personArrary.length) 
			{
				System.out.println("A person with this last name is not in the phone book.");
			}
		}		
	}
	//This method searches every value of the static array of person objects for objects that have the same full name and 
	//displaying records that match along the way.
	public static void fullNameSearch(String fullNameSearch) 
	{	
		System.out.println("The person or people with this full name are.");
		for (int index = 0; index < personArrary.length; index++) 
		{
			String fullName = personArrary[index].getFullName().toLowerCase();
			
			if(fullName.equals(fullNameSearch.toLowerCase())) 
			{		
				displayPerson(index);
			}
			if (index == personArrary.length) 
			{
				System.out.println("A person with this name is not in the phone book.");
			}
		}	
		
		
	}
	//This method searches every value of the static array of person objects for objects that have the same phone number and 
	//displaying records that match along the way.
	public static void telephoneNumberSearch(String telephoneNumber) 
	{
		long longTelephoneNumber = Long.parseLong(telephoneNumber);
		
		System.out.println("The person or people with this phone number are.");
		for (int index = 0; index < personArrary.length; index++) 
		{
			if(personArrary[index].getPhoneNumber() == longTelephoneNumber) 
			{
				displayPerson(index);
			}
			if (index == personArrary.length) 
			{
				System.out.println("A person with this phone number is not in the phone book.");
			}
		}	
	
	}
	
	//This method searches every value of the static array of person objects for objects that have the same state or city name.
	//displaying records that match along the way.
	public static void cityStateSearch(String cityState) 
	{	
		System.out.println("The person or people with this city or state are.");
		for (int index = 0; index < personArrary.length; index++) 
		{
			String cityName 	= personArrary[index].getCityName().toLowerCase();
			String stateName 	= personArrary[index].getStateName().toLowerCase();
			
			if(cityName.equals(cityState.toLowerCase()) || stateName.equals(cityState.toLowerCase())) 
			{
				displayPerson(index);
			}
			if (index == personArrary.length) 
			{
		           System.out.println("A person with this city or state is not in the phone book.");
			}
		}
	}

	//This method Deletes A record in the static array of person objects buy creating a new array one index smaller and then setting 
	//the index with the given phone number to the last index of the original array it then sets the static array to the new array 
	//truncating the last index off.  
	public static void deleteARecordByItsTelephoneNumber(String deletePhoneNumber) 
	{	
		long longDeletePhoneNumber = Long.parseLong(deletePhoneNumber);
		
		for (int index = 0; index < personArrary.length; index++) 
		{
			if(personArrary[index].getPhoneNumber() == longDeletePhoneNumber) 
			{
				personCount--;	
				
				Person removeAPersonArrary[] 	= new Person[personCount]; 
				
				personArrary[index] 			= personArrary[personArrary.length-1];
				
				for (int index2 = 0; index2 < personArrary.length-1; index2++) 
				{
					removeAPersonArrary[index2] = personArrary[index2];

				}
				personArrary = removeAPersonArrary;	
			} 
			if (index == personArrary.length) 
			{
				System.out.println("A person with this phone number is not in the phone book.");
			}
		}	
		
	}

	//This method updates a record in the static array of person objects when given a number tied to someone in the array. 
	public static void updateARecordByItsTelephoneNumber(String updatePhoneNumber, Person updatePerson) 
	{	
		long longUpdatePhoneNumber = Long.parseLong(updatePhoneNumber);
		
		for (int index = 0; index < personArrary.length; index++) 
		{
			if(personArrary[index].getPhoneNumber() == longUpdatePhoneNumber) 
			{
				personArrary[index].setFirstName(updatePerson.getFirstName());
				personArrary[index].setLastName(updatePerson.getLastName());
				personArrary[index].setFullName(updatePerson.getFullName());
				personArrary[index].setAddress(updatePerson.getAddress());
				personArrary[index].setCityName(updatePerson.getCityName());
				personArrary[index].setStateName(updatePerson.getStateName());
				personArrary[index].setZipCode(updatePerson.getZipCode());
				personArrary[index].setPhoneNumber(updatePerson.getPhoneNumber());
			}
			if (index == personArrary.length) 
			{
				System.out.println("A person with this phone number is not in the phone book.");
			}	
		}		
	}
	
	//This method sorts the static array of person objects by full name.
	public static void sortPersonArraryByFullName() 
	{
		Comparator<Person> personSortComparator = Comparator.comparing(Person::getFullName); 
	    Arrays.sort(personArrary, personSortComparator);	
	}
	
	// This method displays every parameter of a person object at a given index on the personArrary and formats the phone number.
	public static void displayPerson(int index) 
	{		
		System.out.print("\n" + personArrary[index].getFullName() + ", " + personArrary[index].getAddress() + ", " + personArrary[index].getCityName() + 
						   ", " + personArrary[index].getStateName() + ", " + personArrary[index].getZipCode()+ ", ");
		
		String formatString 	= Long.toString(personArrary[index].getPhoneNumber());
		String firstThree 		= formatString.substring(0, 3);
		String secondThree 		= formatString.substring(3, 6);
		String lastFour 		= formatString.substring(6, 10);
		
		System.out.println("("+ firstThree+ ")-" + secondThree + "-" + lastFour);
	}
	
}
