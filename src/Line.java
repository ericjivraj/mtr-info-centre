import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.LinkedList;

/**
 * This is our class Line which contains 5 methods, one which lists all stations in a specific line
 * Another method which gets the first station of a given line
 * Another method which gets the last station of a given line
 * Another method which gets a specific station when given a number (order number in the line)
 * And one last method which lists all directly connected lines when given a line
 * 
 * @author Eric Jivraj
 * @author Mohammed Sohiel
 * @author Ruhi Begum
 * @version 14/12/2017
 */

public class Line {
	private String[] lines;
	
	public Line(){
		lines = new String[12];		
	}
	
	/**
	 * Lists the stations in their respective order in the specified MTR line
	 * @param lineName	a specified line in the MTR network
	 * @return	a String representation of all stations in the specified MTR line
	 * @throws IOException 
	 */
	
	public String listSpecificLine(String lineName) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("csv/MTRsystem_partial.csv"));

		String aLine ="";
		int i = 0;
		boolean found = false;
		
		while(found == false)
		{
			lines[i] = reader.readLine(); //Holds every station on the line
			aLine = lines[i]; //Hold that entire line in a single string i.e station1, station2, station3 ect 
			String[] allStations = aLine.split(","); //Split the elements in that string by commas and hold all elements separately in array parts
			
			String specificLine = allStations[0]; //get the first element which is the line name
			if(lineName.equals(specificLine)) //If the linename passed in is the same as the current iterated lines name, put that line in string aLine
			{
				aLine = lines[i];
				found = true;
			}
			else
			{
				i++;
			}
		}
		 return aLine;
	}
	
	/**
	 * Lists the first station in a MTR line
	 * @param lineName	a specified line in the MTR network
	 * @return	a String representation of the first station in the MTR line
	 * @throws IOException 
	 */
	
	public String getFirstStation(String lineName) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("csv/MTRsystem_partial.csv"));

		String aLine ="";
		String aStation="";
		int i = 0;
		boolean found = false;
		
		while(found == false)
		{
			lines[i] = reader.readLine(); //Holds every station on the line
			aLine = lines[i]; //Hold that entire line in a single string i.e station1, station2, station3 ect 
			String[] allStations = aLine.split(","); //Split the elements in that string by commas and hold all elements separately in array parts
			
			String specificLine = allStations[0]; //get the first element which is the line name
			if(lineName.equals(specificLine)) //If the linename passed in is the same as the current iterated lines name, put that line in string aLine
			{
				aStation = allStations[1];
				found = true;
			}
			else
			{
				i++;
			}
		}
		 return aStation;
	}
	
	/**
	 * Lists the last station in a MTR line
	 * @param lineName	a specified line in the MTR network
	 * @return	a String representation of the last station in the MTR line
	 * @throws IOException 
	 */
	
	public String getLastStation(String lineName) throws IOException
	{ 
		BufferedReader reader = new BufferedReader(new FileReader("csv/MTRsystem_partial.csv"));

		String aLine ="";
		String aStation="";
		int i = 0;
		boolean found = false;
		
		while(found == false)
		{
			lines[i] = reader.readLine(); //Holds every station on the line
			aLine = lines[i]; //Hold that entire line in a single string i.e station1, station2, station3 ect 
			String[] allStations = aLine.split(","); //Split the elements in that string by commas and hold all elements separately in array parts
			
			String specificLine = allStations[0]; //get the first element which is the line name
			if(lineName.equals(specificLine)) //If the linename passed in is the same as the current iterated lines name, put that line in string aLine
			{
				aStation = allStations[allStations.length-1];
				found = true;
			}
			else
			{
				i++;
			}
		}
		 return aStation;
	}
	
	/**
	 * Lists the name of the line(s) that is/are directly connected with the specified MTR line
	 * @param line	a specified line in the MTR network
	 * @return	a String representation of the name of the required line(s)
	 * @throws IOException
	 */
	
	public String listAllDirectlyConnectedLines(String line) throws IOException
	{

		BufferedReader reader = new BufferedReader(new FileReader("csv/MTRsystem_partial.csv"));
		
		String foundString ="";
		int i = 0;
		int count = 0;
		boolean foundPassed = false;
		boolean foundConnected = false;
		boolean foundFirst = false;
		
		LinkedList<LinearNode> passedStations = new LinkedList<LinearNode>();
		LinkedList<LinearNode> connectedStations = new LinkedList<LinearNode>();
		try{
			while(foundPassed == false && foundConnected == false)
			{
				LinearNode<String> aLineNode = new LinearNode<String>(); //Create an empty node
				aLineNode.setElement(listStationByNumber(count)); // Add the first iterated line as an element to the node
				passedStations.add(count, aLineNode); //add this node with this element at count index
				String[] tmpArr = aLineNode.getElement().split((","));
				
				if(tmpArr[0].equals(line)) //This section finds our passed line
				{
					foundString = line;
				}
				
				if(foundString != null) //This section finds the connected lines
				{
					
					
					
					
					
					
					String comparedString = aLineNode.getElement(); //prints all lines one by one
					System.out.print(aLineNode.getElement() + "\n");
					
					String[] tmpArr2 = comparedString.split(","); // all lines
					//System.out.println(tmpArr2[0]);
					
					String [] prevArr = foundString.split(","); //the line passed in parameters
					//System.out.println(foundString);		
					//System.out.println(prevArr[1]);
					
					i++;
				}
				count++;
			}
		}
		
		catch(Exception e)
		{
			System.out.println("");
		}
			return "You passed in " + foundString;
	}
	
	/**
	 * Lists the name of a station by number
	 * @param lineNumber	a specified line in the MTR network
	 * @return	a String representation of the station name by number
	 * @throws IOException
	 */
	
	public String listStationByNumber(int lineNumber) throws IOException
	{
			String[] tmpArr = new String[12];
			Stream<String> stream = Files.lines(Paths.get("csv/MTRsystem_partial.csv")); 
			{
				tmpArr = stream.toArray(String[]::new);
			}
		return tmpArr[lineNumber] + " ";
	}
}
