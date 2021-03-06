

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
		String menuCommand = "default";
		
		while(menuCommand != "exit")
		{
			
			
			System.out.println(enumMenu.EXIT + "" + enumMenu.ADD_NEW_ENTRY + enumMenu.EXISTING_ENTRY_SEARCH + enumMenu.FIRST_NAME_SEARCH + enumMenu.LAST_NAME_SEARCH + 
					enumMenu.FULL_NAME_SEARCH + enumMenu.TELEPHONE_NUMBER_SEARCH + enumMenu.CITY_STATE_SEARCH + enumMenu.DELETE_RECORD_BY_TELEPHONE_NUMBER + 
					enumMenu.UPDATE_RECORD_BY_TELEPHONE_NUMBER + enumMenu.DISPLAY_RECORDS_IN_DECENDING_ORDER_BY_NAME);
							   
			System.out.print("Choose a number for an action from the above list: ");
			
			menuCommand = menuInputScanner.nextLine().trim();
			
			if(menuCommand.equals("0") || menuCommand.equals("1") || menuCommand.equals("2") || menuCommand.equals("3") || menuCommand.equals("4") || 
					menuCommand.equals("5") || menuCommand.equals("6") || menuCommand.equals("7") || menuCommand.equals("8") || 
					menuCommand.equals("9") || menuCommand.equals("10")) 
			{
				System.out.print("\nYou chose: ");		
			}
			else System.out.println(enumMenu.IMPROPER_NUMBER_ERROR);	
			
			
			try 
			{
				
				switch (menuCommand) 
				{

				case "0":
					
					System.out.println(enumMenu.EXIT);
					menuCommand = "exit";
					break;
					
				case "1":
					
					System.out.println(enumMenu.ADD_NEW_ENTRY);
					addNewEntry(consoleInputForAPerson(consoleinputScanner));
					
					break;
					
				case "2":
					
					System.out.println(enumMenu.EXISTING_ENTRY_SEARCH);
					existingEntrySearch(consoleInputForAPerson(consoleinputScanner));
					
					break;
					
				case "3":
					
					System.out.println(enumMenu.FIRST_NAME_SEARCH);
					firstNameSearch(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "4":
					
					System.out.println(enumMenu.LAST_NAME_SEARCH);
					lastNameSearch(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "5":
					
					System.out.println(enumMenu.FULL_NAME_SEARCH);
					fullNameSearch(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "6":
					
					System.out.println(enumMenu.TELEPHONE_NUMBER_SEARCH);
					telephoneNumberSearch(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "7":
					
					System.out.println(enumMenu.CITY_STATE_SEARCH);
					cityStateSearch(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "8":
					
					System.out.println(enumMenu.DELETE_RECORD_BY_TELEPHONE_NUMBER);
					deleteARecordByItsTelephoneNumber(consoleStringInputForSearching(consoleStringInputScanner));
					
					break;
					
				case "9":
					
					System.out.println(enumMenu.UPDATE_RECORD_BY_TELEPHONE_NUMBER);
					updateARecordByItsTelephoneNumber(consoleStringInputForSearching(consoleStringInputScanner),
					consoleInputForAPerson(consoleinputScanner));
					
					break;
					
				case "10":
					
					System.out.println(enumMenu.DISPLAY_RECORDS_IN_DECENDING_ORDER_BY_NAME);
					sortPersonArraryByFullName();
					
					for (int index = 0; index < personArrary.length; index++) 
					{
						displayPerson(index);
						System.out.print("\n");
					}
					break;
		

				}
			}
			catch (Exception e) 
			{	
				if(menuCommand.equals("1")) 
				{
					System.out.println(enumMenu.WHILE_TRYING_ERROR + "a new person to the phone book.\n");
				}
				else if(menuCommand.equals("2")) 
				{
					System.out.println(enumMenu.SEARCH_BY_ERROR + "every data point.\n");
				}
				else if(menuCommand.equals("3")) 
				{
					System.out.println(enumMenu.SEARCH_BY_ERROR + "their first name.\n");
					
				}
				else if(menuCommand.equals("4")) 
				{
					System.out.println(enumMenu.SEARCH_BY_ERROR + "their last name.\n");
					
				}
				else if(menuCommand.equals("5"))
				{
					System.out.println(enumMenu.SEARCH_BY_ERROR + "their full name.\n");
					
				}
				else if(menuCommand.equals("6")) 
				{
					System.out.println(enumMenu.SEARCH_BY_ERROR + "a telephone number.\n");
				}
				else if(menuCommand.equals("7")) 
				{
					System.out.println(enumMenu.SEARCH_BY_ERROR + "the city or state name.\n");
				}
				else if(menuCommand.equals("8")) 
				{
					System.out.println(enumMenu.WHILE_TRYING_ERROR + "delete a record by the records telephone number.\n");
				}
				else if(menuCommand.equals("9")) 
				{
					System.out.println(enumMenu.WHILE_TRYING_ERROR + "update a record by the records telephone number.\n");
				}
				else if(menuCommand.equals("10")) 
				{
					System.out.println(enumMenu.WHILE_TRYING_ERROR + "display records in descending order by name.\n");
				}
				

			}
		}
	}
	
	//This method prompts the user for formated input it takes the next line as an array of strings and parses the
	//data that should be integers into longs. it then calls the Person constructor and returns a person object.
	public static Person consoleInputForAPerson(Scanner consoleinputScanner) 
	{
		System.out.println(enumMenu.INPUT_VALUES_FOR_A_PERSON);
		
		String stringInputArray[] = consoleinputScanner.nextLine().split(",");
		
		String 	fullName 		= stringInputArray[0].trim();
		String 	street 			= stringInputArray[1].trim();
		String 	cityName 		= stringInputArray[2].trim();
		String 	stateName 		= stringInputArray[3].trim();	
		String 	strZipCode 		= stringInputArray[4].trim();
		String 	strPhoneNumber 	= stringInputArray[5].trim(); 
		
		if(Validation.stringValidation(fullName) == true &&
		   Validation.stringValidation(street) == true && 
		   Validation.stringValidation(cityName) == true &&
		   Validation.stringValidation(stateName) == true &&
		   Validation.stringValidation(strZipCode) == true &&
		   Validation.stringValidation(strPhoneNumber) == true &&
		   Validation.zipCodeValidation(strZipCode) == true && 
		   Validation.phoneNumberValidation(strPhoneNumber) == true) 
		{
					long zipCode = Long.parseLong(strZipCode);
					long phoneNumber = Long.parseLong(strPhoneNumber);
					Person newPerson = new Person(fullName, street, cityName, stateName, zipCode, phoneNumber);
					return newPerson;
		}
		else 
		{
			System.out.println("\n" + enumMenu.WHILE_TRYING_ERROR + "input data for a new person for the phonebook.\n");
			return null;
		}
		
					
	}
	
	//This method prompts the user for data and then returns a string from the command console.
	public static String consoleStringInputForSearching(Scanner consoleStringInput) 
	{
		System.out.print("please input data: ");
		String stringInputArray = consoleStringInput.nextLine().trim();
		
		return stringInputArray;
	}
	
	//This method creates a new array of person objects, with an increased size based on the personCount it then
	// adds every current object in the static array of person objects (personArrary) to the new array. 
	//After that it sets the new array to the static array.
	public static void addNewEntry(Person newPerson) 
	{	
		if(newPerson != null) 
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
		
				
	}
	
	//This method searches every value of the static array of person objects for objects that have all the same data and 
	//displays every record that matches along the way.
	public static void existingEntrySearch(Person personSearch) 
	{	
		int indexValue = 1;	
		String 	fullName 	= personSearch.getFullName().toLowerCase();
		String 	address 	= personSearch.getStreet().toLowerCase();
		String 	cityName 	= personSearch.getCityName().toLowerCase();
		String 	stateName 	= personSearch.getStateName().toLowerCase();
			
		long 	zipCode 	= personSearch.getZipCode();
		long 	phoneNumber = personSearch.getPhoneNumber();
		
		for (int index = 0; index < personArrary.length; index++) 
		{
			
			if(personArrary[index].getFullName().toLowerCase().equals(fullName) && personArrary[index].getStreet().toLowerCase().equals(address)		&&
			   personArrary[index].getCityName().toLowerCase().equals(cityName)	&& personArrary[index].getStateName().toLowerCase().equals(stateName)	&&
	           personArrary[index].getZipCode()  == 				  zipCode	&& personArrary[index].getPhoneNumber() == 				   phoneNumber	) 
			{
				System.out.print("This person is already in this phone book: ");
				displayPerson(index);
			}else indexValue++;
			
		}
		if(indexValue > personArrary.length) 
		{
			System.out.println("This person is not in the phone book.\n");
		}			
	}
	
	//This method searches every value of the static array of person objects for objects that have the same first name and 
	//displaying records that match along the way.
	public static void firstNameSearch(String firstNameSearch) 
	{	
		int indexValue = 1;
		
		if(Validation.stringValidation(firstNameSearch) == true) 
		{
			for (int index = 0; index < personArrary.length; index++) 
			{
				String firstName = personArrary[index].getFirstName().toLowerCase();
				if(firstName.equals(firstNameSearch.toLowerCase())) 
				{
					System.out.print("A person with this first name is: ");
					displayPerson(index);
				}else indexValue++;
				
			}
			if(indexValue > personArrary.length) 
			{
				System.out.println("A person with this first name is not in the phone book.\n");
			}
			
		}else System.out.println(enumMenu.SEARCH_BY_ERROR + "their first name.\n");
		
		
		
	}
	
	//This method searches every value of the static array of person objects for objects that have the same last name and 
	//displaying records that match along the way.
	public static void lastNameSearch(String lastNameSearch) 
	{
		int indexValue = 1;
		
		if(Validation.stringValidation(lastNameSearch) == true) 
		{
			for (int index = 0; index < personArrary.length; index++) 
			{
				String lastName = personArrary[index].getLastName().toLowerCase();
				
				if(lastName.equals(lastNameSearch.toLowerCase())) 
				{
					System.out.print("A person with this last name is: ");
					displayPerson(index);
				}else indexValue++; 	
			}
			if(indexValue > personArrary.length)
			{			
				System.out.println("A person with this last name is not in the phone book.\n");
			}
		}else System.out.println(enumMenu.SEARCH_BY_ERROR + "their last name.\n");
	}
	
	//This method searches every value of the static array of person objects for objects that have the same full name and 
	//displaying records that match along the way.
	public static void fullNameSearch(String fullNameSearch) 
	{	
		int indexValue = 1;
		
		if(Validation.stringValidation(fullNameSearch) == true) 
		{
			
			for (int index = 0; index < personArrary.length; index++) 
			{
				String fullName = personArrary[index].getFullName().toLowerCase();
				
				if(fullName.equals(fullNameSearch.toLowerCase())) 
				{		
					System.out.print("A person with this full name is: ");
					displayPerson(index);
				}else indexValue++;
			}
			if (indexValue > personArrary.length)
			{
				System.out.println("A person with this full name is not in the phone book.\n");
			}
		}else System.out.println(enumMenu.SEARCH_BY_ERROR + "their full name.\n");
		
	}
	//This method searches every value of the static array of person objects for objects that have the same phone number and 
	//displaying records that match along the way.
	public static void telephoneNumberSearch(String telephoneNumber) 
	{
		int indexValue = 1;
		
		if(Validation.phoneNumberValidation(telephoneNumber) == true) 
		{
			long longTelephoneNumber = Long.parseLong(telephoneNumber);
			
			for (int index = 0; index < personArrary.length; index++) 
			{
				if(personArrary[index].getPhoneNumber() == longTelephoneNumber) 
				{
					System.out.print("A person with this telephone number is: ");
					displayPerson(index);
				}else indexValue++;	
			}	
			if (indexValue > personArrary.length)
			{
				System.out.println("A person with this phone number is not in the phone book.\n");
			}
		}else System.out.println(enumMenu.SEARCH_BY_ERROR + "their telephone number.\n");
	}
	
	//This method searches every value of the static array of person objects for objects that have the same state or city name.
	//displaying records that match along the way.
	public static void cityStateSearch(String cityState) 
	{	
		int indexValue = 1;
		
		if(Validation.stringValidation(cityState) == true) 
		{
			for (int index = 0; index < personArrary.length; index++) 
			{
				String cityName 	= personArrary[index].getCityName().toLowerCase();
				String stateName 	= personArrary[index].getStateName().toLowerCase();
				
				if(cityName.equals(cityState.toLowerCase()) || stateName.equals(cityState.toLowerCase())) 
				{
					System.out.print("A person with this city or state is: ");
					displayPerson(index);
				}else indexValue++;
			}
			if (indexValue > personArrary.length)
			{
		           System.out.println("A person from this city or state is not in the phone book.\n");
			}
		}else System.out.println(enumMenu.SEARCH_BY_ERROR + "the city or State.\n");
	}

	//This method Deletes A record in the static array of person objects buy creating a new array one index smaller and then setting 
	//the index with the given phone number to the last index of the original array it then sets the static array to the new array 
	//truncating the last index off.  
	public static void deleteARecordByItsTelephoneNumber(String deletePhoneNumber) 
	{	
		int indexValue = 1;
		
		long longDeletePhoneNumber = Long.parseLong(deletePhoneNumber);
		
		if(Validation.phoneNumberValidation(deletePhoneNumber) == true) 
		{
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
				}else indexValue++;
			}	
			if (indexValue > personArrary.length)
			{
				System.out.println("A person with this phone number is not in the phone book.\n");
			}
		}else System.out.println(enumMenu.WHILE_TRYING_ERROR + "delete a record by the records telephone number.\n");
	}

	//This method updates a record in the static array of person objects when given a number tied to someone in the array. 
	public static void updateARecordByItsTelephoneNumber(String updatePhoneNumber, Person updatePerson) 
	{	
		int indexValue = 1;
		
		long longUpdatePhoneNumber = Long.parseLong(updatePhoneNumber);
		
		if(Validation.phoneNumberValidation(updatePhoneNumber) == true) 
		{
			for (int index = 0; index < personArrary.length; index++) 
			{
				if(personArrary[index].getPhoneNumber() == longUpdatePhoneNumber) 
				{
					personArrary[index].setFirstName(updatePerson.getFirstName());
					personArrary[index].setLastName(updatePerson.getLastName());
					personArrary[index].setFullName(updatePerson.getFullName());
					personArrary[index].setStreet(updatePerson.getStreet());
					personArrary[index].setCityName(updatePerson.getCityName());
					personArrary[index].setStateName(updatePerson.getStateName());
					personArrary[index].setZipCode(updatePerson.getZipCode());
					personArrary[index].setPhoneNumber(updatePerson.getPhoneNumber());
				}else indexValue++;	
			}	
			if (indexValue > personArrary.length)
			{
				System.out.println("A person with this phone number is not in the phone book.\n");
			}	

		}else System.out.println(enumMenu.WHILE_TRYING_ERROR + "update a record by the records telephone number.\n");
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
		System.out.print(personArrary[index].getFullName() + ", " + personArrary[index].getStreet() + ", " + personArrary[index].getCityName() + 
						   ", " + personArrary[index].getStateName() + ", " + personArrary[index].getZipCode()+ ", ");
		
		String formatString 	= Long.toString(personArrary[index].getPhoneNumber());
		String firstThree 		= formatString.substring(0, 3);
		String secondThree 		= formatString.substring(3, 6);
		String lastFour 		= formatString.substring(6, 10);
		
		System.out.println("("+ firstThree+ ")-" + secondThree + "-" + lastFour + "\n");
	}
	
	
	
}

