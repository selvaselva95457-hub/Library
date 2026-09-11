
package Library;


import java.util.ArrayList;
import java.util.Scanner;

class Book{
	
	int BookID;
	String Title;
	String Author;
	Boolean isAvailable;

Book(int BookID , String Title , String Author) {
	
	this.BookID = BookID;
	this.Title = Title;
	this.Author = Author;
	this.isAvailable = true;
}

void DisplayBook() {
	
	System.out.println("BookID : " + BookID);
	System.out.println("Title : " + Title);
	System.out.println("Author : " + Author);
	System.out.println("status :" + (isAvailable ? "Avilable" : "Borrowed"));
	
	System.out.println("-----------------------------------------------------------");
}

}

class library{
	
	ArrayList<Book> books = new ArrayList<>();
	
	 void addBook(Book book) {
		
		books.add(book);
		System.out.println("Book added succesfuly");
	}
	
	void displayBooks() {
		
		if(books.isEmpty()) {
			System.out.println("No books avilable");
			return;
		}
		
		for (Book book : books) {
			book.DisplayBook();
		}
		
		
	}
	
	void searchbook(int id) {
		for (Book book : books) {
			if(book.BookID == id) {
				book.DisplayBook();
				return;
			}
			
		}
		System.out.println("Book Not Found");
	}
	
	void Borrowbook(int id) {
		for (Book book : books) {
			if(book.BookID == id) {
				if(book.isAvailable) {
					book.isAvailable = false;
					System.out.println("Book borrowed Successfully!!");
				}
				else {
					System.out.println("Book is Already Avilable!!");
				}
				return;
			}
		}
		System.out.println("Book not Found");
		
	}
	
	void returnbook(int id) {
		for (Book book : books) {
			if(book.BookID == id) {
				if(!book.isAvailable) {
					book.isAvailable = true;
					System.out.println("Book returned Succesfully!!");
				}
				else {
					System.out.println("book is Already Avilable");
				}
				return;
				
			}
		}
		System.out.println("Books not Found");
	}
	
}
			

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		library Library = new library();
		
		while(true) {
			
			System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM ======");
			System.out.println("1.Add Book");
			System.out.println("2.Display Book");
			System.out.println("3.Search Book");
			System.out.println("4.Borrow Book");
			System.out.println("5.Return Book");
			
			System.out.println("Enter Your Choice : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				
				System.out.println("Enter BookID :");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter the Title:");
				String title = sc.nextLine();
				
				System.out.println("Enter the Author:");
				String author = sc.nextLine();
				
				Book book = new Book(id , title , author);
				Library.addBook(book);
				break;
				
			case 2:
				
				Library.displayBooks();
				break;
				
			case 3:
				
				System.out.println("Enter the Search Book ID: ");
				int searchid = sc.nextInt();
				
				Library.searchbook(searchid);
				break;
				
			case 4:
				 System.out.println("Enter your Borrow Book ID: ");
				 int borrowid = sc.nextInt();
				 
				 Library.Borrowbook(borrowid);
				 break;
				 
			case 5:
				
				System.out.println("Enter the Return Book ID: ");
				int returnid = sc.nextInt();
				
				Library.returnbook(returnid);
				break;
				
			case 6:
				
				System.out.println("Thank You");
				sc.close();
				return;
				
			default :
				
				System.out.println("Invalid Choice");
				

			}
			

		}
		
		
	}
	
	

}

