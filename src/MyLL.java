public class MyLL {
 
	public StudentInfo frontOfList;
	public static int numInList;
 
	// Default constructor
	public MyLL() {
		numInList = 0;
		frontOfList = null;
	}
 
	public void addToFront(StudentInfo studentToAdd) {
		if (studentToAdd == null) {
			return;
		}

		if (frontOfList == null || numInList <= 0) {
			// List was empty.
			studentToAdd.next = null;
			frontOfList = studentToAdd;
			numInList = 1;
			return;
		}

		// At this point, the list has at least 1 element.
		studentToAdd.next = frontOfList;
		frontOfList = studentToAdd;
		incrementnumInList();
		return;
	}
	
	public StudentInfo removeFromFront() {
		StudentInfo tempStudent = frontOfList;
		frontOfList = frontOfList.next;
		decrementnumInList();
		return tempStudent;
	} // end addToFront

	// appends the specified element to the end of this list.
	public void addToRear(StudentInfo studentToAdd) {
 
		StudentInfo currentStudent = frontOfList;
		for (int i = 0; i < numInList; i++) {
			if (currentStudent.next == null) {
				currentStudent.next = studentToAdd;
				studentToAdd = currentStudent;
				incrementnumInList();
				return;
			}
			else {
				currentStudent = currentStudent.next;
			}
		}
	} // end addToRear

	public void removeFromRear() {
		StudentInfo currentStudent = frontOfList;
		StudentInfo previousStudent = frontOfList;
		for (int i = 0; i < numInList; i++) {
			if (currentStudent.next == null) {
				previousStudent.next = null;
				decrementnumInList();
				return;
			}
			else {
				currentStudent = currentStudent.next;
			}
			if (i != 0) {
				previousStudent = previousStudent.next;
			}
		}
	}

	public void displayList() {
		if (numInList <= 0) {
			System.out.println("\nThe list is empty!\n");
			return;
		}

		// At this point, we have a non-empty list.
		System.out.println("\nHere is the list from front to rear.");
		StudentInfo currentStudent = this.frontOfList;
		while (currentStudent != null) {
			System.out.println("\nThe student number is " + currentStudent.studentNum);
			System.out.println("The first name is " + currentStudent.firstName);
			System.out.println("The last name is " + currentStudent.lastName);
			System.out.println("The height is " + currentStudent.height);
			System.out.println("The weight is " + currentStudent.weight);
			System.out.println();

			currentStudent = currentStudent.next;
		}

		System.out.println("There are " + numInList + " items in the list.");
	}

	private static int getnumInList() {
		return numInList;
	}

	// returns the number of elements in this list.
	public int size() {
		return getnumInList();
	}
 
	private static void incrementnumInList() {
		numInList++;
	}

	private static void decrementnumInList() {
		numInList--;
	}	
	
}