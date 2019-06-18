import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This is our class Station which contains 2 methods, one which displays all stations
 * And another method which displays only the stations classified as terminis
 * 
 * @author Eric Jivraj
 * @author Mohammed Sohiel
 * @author Ruhi Begum
 * @version 14/12/2017
 */

public class Station {

	private String stationName;
	
	public Station(String stationName)
	{
		this.stationName = stationName;
	}

	/**
	 * Lists all stations in this MTR network
	 * @return the name of all MTR stations 
	 * @throws IOException 
	 */
	
	public String displayAllStations() throws IOException
	{
		Scanner scanner = new Scanner(new File("csv/MTRsystem_partial.csv"));
        scanner.useDelimiter(", ");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+" - ");
        }
        scanner.close();
        return "";
	}
	
	/**
	 * Lists all terminis in this MTR network
	 * @return the name of all MTR stations that are the end point of the lines in the MTR network 
	 * @throws IOException 
	 */
	
	public String displayAllTerminis() throws IOException
	{
		{
			BufferedReader reader = new BufferedReader(new FileReader("csv/MTRsystem_partial.csv"));
			List<String> terminis = new ArrayList<>();
			String termini = null;
			
			while ((termini = reader.readLine()) != null) {
			    
				String[] storeStation;
				storeStation = termini.split(",");
				
				terminis.add(storeStation[0] + ": " + storeStation[1] + " - " + storeStation[storeStation.length-1] + "\n");
			}
				System.out.println(terminis);
				return "";
		}
	}
	
}
