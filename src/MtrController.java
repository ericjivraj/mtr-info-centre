import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is our concrete class MtrController which implements the 4 methods from the Controller interface 
 * 
 * @author Eric Jivraj
 * @author Mohammed Sohiel
 * @author Ruhi Begum
 * @version 14/12/2017
 */

public class MtrController implements Controller {
	
	private Line someLine = new Line();
	private Station someStation = new Station(null);
	
	public MtrController()
	{
		
	}
	                                                
	/**
	 * Lists all termini in this MTR network.
	 * @return the name of all MTR stations that are the end point of the lines in the MTR network. 
	 * @throws IOException 
	 */
	
	@Override
	public String listAllTermini() throws IOException {
		String someString = someStation.displayAllTerminis();
		System.out.println(someString);
		return someString;
		}

	/**
	 * Lists the stations in their respective order in the specified MTR line.
	 * @param line	a specified line in the MTR network
	 * @return	a String representation of all stations in the specified MTR line.
	 * @throws IOException 
	 */
	
	@Override
	public String listStationsInLine(String line) throws IOException {
		String someString = someLine.listSpecificLine(line);
		System.out.println(someString);
		return "";
	}

	/**
	 * Lists the name of the line(s) that is/are directly connected with the specified MTR line.
	 * @param line	a specified line in the MTR network
	 * @return	a String representation of the name of the required line(s)
	 */

	@Override
	public String listAllDirectlyConnectedLines(String line) throws IOException {
		return "";
	}

	/**
	 * Lists a path between the specified stations.
	 * The path is represented as a sequence of the name of the stations between the specified stations. 
	 * @param stationA	the name of a station
	 * @param stationB	the name of another station
	 * @return	a String representation of a path between the specified stations
	 */

	@Override
	public String showPathBetween(String stationA, String stationB) {
		return null;
	}

}
