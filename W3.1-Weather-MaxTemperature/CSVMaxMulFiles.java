
/**
 * CSVMaxMulFiles : To find out Maximum tempearture by checking multiple files of csv 
 * 
 * METHODS
 * -------
 *  1.hottestHourInFile: Finds Maximum temperature from a single day and returns the maximum temperature record.
 *  2.hottestInManyDays: Finds Maximum temperature from many files(days or may consider whole year files) and 
 *                       returns the maximum temperature record.
 *  3.testHottestInManyDays: Tests the hottestInManyDays method by selecting many files(10 or whole year) and 
 *                           returns the Maximum temperature along with Date.
 *                           
 * @version 1.1
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class CSVMaxMulFiles {
    
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
    
    public CSVRecord hottestInManyDays(){
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
           FileResource fr = new FileResource(f); 
           CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
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
    
    public void testHottestInManyDays(){
        CSVRecord largest = hottestInManyDays();
        System.out.println("Hottest temperature was "+largest.get("TemperatureF")+" on "+largest.get("DateUTC"));
    }

}

/*
 * OUTPUT(CHOOSING FIRST 10 FILES OF 2015)
 * ---------------------------------------
 * Hottest temperature was 66.9 on 2015-01-04 15:51:00
 */
