
/**
 * CSVMax: To find out hottest tempearture of a particular hour on the particular day from csv files!
 * 
 * METHODS
 * ------
 *  hottestHourInFile: finds hottest temperature and returns the that temperature record.
 *  testHottestInDay: tests the hottestHourInFile method by choosing required file(any year & any day) and 
 *                     returns temperature record along with time zone.
 * @version 1.0
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
     public CSVRecord hottestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow:parser){
            if(largestSoFar == null){
                largestSoFar = currentRow;
            }
            
            else{
                Double currTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                Double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if(currTemp > largestTemp){
                    largestSoFar = currentRow;
                }
            }
          
            
     }
     return largestSoFar;
     }
     public void testHottestInDay(){
         FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
         CSVRecord largest = hottestHourInFile(fr.getCSVParser());
         System.out.println("ON 2015-01-01,Hottest Temperature was "+largest.get("TemperatureF")+" at "+largest.get("TimeEST"));
        }

}

/*
 * OUTPUT
 * ------
 * ON 2015-01-01,Hottest Temperature was 51.1 at 2:51 PM
 *
 */
