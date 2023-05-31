// Program to read the contents of a file and write new contents to the file. Use also exception handling in the program
package fileAndExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

class WriteFile{
	public void writeData() {
		try {
		       // Creates a Writer using FileWriter
		       FileWriter fileWriter = new FileWriter("Book.txt");                                      // open file for writing
		       fileWriter.write("Hello, Welcome to my new book.\nI hope you will find this helpful.");  // Writes text to file 
		       System.out.println("Data is written to the file.");                                      // reference msg.
		       fileWriter.close();                                                                      // Closes the writer
		     }
		     catch (Exception e) {             
		       e.getStackTrace();
		     }
	}
}

class ReadFile{
	public void readDataFromFile() {
		File myFile = new File("Book.txt");
		try {
			Scanner scan = new Scanner(myFile);                           // open file 
			while(scan.hasNextLine()) {
				String data = scan.nextLine();                            //reading data from file
				System.out.println(data);                                 // printing data on console
			}
			scan.close();                                                 //Closing file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

public class FileOperations {

	public static void main(String[] args) {
		/*
		WriteFile fileOperationWrite = new WriteFile();                  // object creation for WriteFile class
		fileOperationWrite.writeData();                                  // calling writeData method
		*/
		ReadFile fileOperationRead = new ReadFile();                     // object creation for readfile class
		fileOperationRead.readDataFromFile();                            // calling readDataFromFile method

	}

}
