
/**
 * CSVMaxMulFiles1
 * 
 * METHODS
 * -------
 * 1.hottestHourInFile: Finds Maximum temperature from a single day by calling getLargestOfTwo and returns the maximum temperature record.
 * 2.hottestInManyDays: Finds Maximum temperature from many files(days or may consider whole year files) by calling getLargestOfTwo and 
 *                       returns the maximum temperature record. 
 * 3.getLargestOfTwo: Finds out the largest temperature record and returns that record. 
                    
 * @version 1.2
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMaxMulFiles1 {
    
    public CSVRecord hottestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow:parser){
            
            largestSoFar = getLargestOfTwo(currentRow,largestSoFar);
          
            
     }
     return largestSoFar;
    }
    
    
    public CSVRecord hottestInManyDays(){
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            
           FileResource fr = new FileResource(f); 
           CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
           largestSoFar = getLargestOfTwo(currentRow,largestSoFar);
          
           
        }
        return largestSoFar;
    }
    
       public CSVRecord getLargestOfTwo(CSVRecord currentRow,CSVRecord largestSoFar ){
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
        return largestSoFar;
    }
    
  
    public static void main(String []args){
        
        CSVMaxMulFiles1 cmax = new CSVMaxMulFiles1();
        //hours testing
        FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVRecord largest = cmax.hottestHourInFile(fr.getCSVParser());
        System.out.println("Finding Max temperature on 2015-01-01:");
        System.out.println("Hottest Temperature was "+largest.get("TemperatureF")+" at "+largest.get("TimeEST"));
        //days testing
        CSVRecord largest1 = cmax.hottestInManyDays();
        System.out.println("Finding Max temperature by selecting multiple files:");
        System.out.println("Hottest temperature was "+largest1.get("TemperatureF")+" on "+largest1.get("DateUTC"));
        
        
    }

}
/*
 * OUTPUT
 * ------
 * Finding Max temperature on 2015-01-01:
 * Hottest Temperature was 51.1 at 2:51 PM
 * Finding Max temperature by selecting multiple files:
 * Hottest temperature was 66.9 on 2015-01-04 15:51:00
 */
