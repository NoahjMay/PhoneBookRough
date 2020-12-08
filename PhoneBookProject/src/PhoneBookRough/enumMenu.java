package PhoneBookRough;

public enum enumMenu
{
	
	EXIT
	{
	      public String toString() {return " 0: Exit the phonebook.\n";}
	},
	INPUT_VALUES_FOR_A_PERSON
	{
	      public String toString() {return "Please input data for a person in this format./n "
					+ "John Doe, 114 Market St, St Louis, MO, 63403, 6366435698/n"
					+ "Every data set is necessary./n";}
	},
	ADD_NEW_ENTRY
	{
	      public String toString() {return " 1: Add a new person to the phonebook.\n";}
	},
	EXISTING_ENTRY_SEARCH
	{
	      public String toString() {return " 2: Search for a person in the phonebook by every data point. \n";}
	},
	FIRST_NAME_SEARCH
	{
	      public String toString() {return " 3: Search for a person in the phonebook by their first name.\n";}
	},
	LAST_NAME_SEARCH
	{
	      public String toString() {return " 4: Search for a person in the phonebook by their last name.\n";}
	},
	FULL_NAME_SEARCH
	{
	      public String toString() {return " 5: Search for a person in the phonebook by their full name.\n";}
	},
	TELEPHONE_NUMBER_SEARCH
	{
	      public String toString() {return " 6: Search for a person in the phonebook by a telephone number.\n";}
	},
	CITY_STATE_SEARCH
	{
	      public String toString() {return " 7: Search for a person in the phonebook by the city or state name.\n";}
	},
	DELETE_RECORD_BY_TELEPHONE_NUMBER
	{
	      public String toString() {return " 8: Delete a record by the records telephone number.\n";}
	},
	UPDATE_RECORD_BY_TELEPHONE_NUMBER
	{
	      public String toString() {return " 9: Update a record by the records telephone number.\n";}
	},
	DISPLAY_RECORDS_IN_DECENDING_ORDER_BY_NAME
	{
	      public String toString() {return "10: Display records in descending order by name.\n";}
	},
	SEARCH_BY_ERROR
	{
	      public String toString() {return "There was an error while trying to search for a person in the phonebook by ";}
	},
	WHILE_TRYING_ERROR
	{
	      public String toString() {return "There was an error while trying to ";}
	},
	IMPROPER_NUMBER_ERROR
	{
	      public String toString() {return "\nYou did not input a proper number from the menu.\n";}
	};
	
					
}