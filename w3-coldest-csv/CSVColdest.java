
/** TASK
 * 
 * Description of CSVColdest:
 *                          To Find the coldest day of the year and other interesting facts about the temperature and humidity in a day.
 * CSV Files: nc_weather data folder that has year and day wise data
 * 
 * METHODS
 * -------
 * 1.coldestHourInFile: Returns the CSVRecord with the coldest temperature in the file and 
 *                     thus all the information about the coldest temperature, such as the hour of the coldest temperature.
 * 2.testColdestHourInFile : Test the method coldestHourInFile and print out information about that coldest temperature, 
 *                           such as the time of its occurrence.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVColdest {
        public CSVRecord coldestHourInFile(CSVParser parser){
            CSVRecord coldest = null;
            for(CSVRecord currentRow:parser){
                if(coldest == null){
                    coldest = currentRow;
                }
                else{
                    Double currTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                    Double lowest = Double.parseDouble(coldest.get("TemperatureF"));
                    if(currTemp<lowest)
                    {
                        coldest = currentRow;
                    }
                }
                
            }
            return coldest;
        }
     
      
    public void testColdestHourInFile(){
            FileResource fr = new FileResource("nc_weather/2015/weather-2015-01-01.csv");
            CSVParser parser = fr.getCSVParser();
            CSVRecord result = coldestHourInFile(parser);
            System.out.println("Finding lowest temperature on 2015-01-01:");
            System.out.println("Coldest temperaure:"+result.get("TemperatureF")+" at "+result.get("TimeEST"));
        }
        
        public String fileWithColdestTemperature(){
            CSVRecord coldest = null;
            File file = null;
            DirectoryResource dr = new DirectoryResource();
           for(File f:dr.selectedFiles()){
           FileResource fr = new FileResource(f);
           CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
           
           if( coldest== null){
               coldest = currentRow;
            } 
            else{
                Double currTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                Double lowestTemp = Double.parseDouble(coldest.get("TemperatureF"));
                if(currTemp < lowestTemp){
                    coldest = currentRow;
                    
                    file = f;
                }
                
            }
           
           
            
           
        }
        
        //System.out.println("Coldest temperature on that day was "+coldest.get("TemperatureF"));
        
        
        return file.getName();
    }
        
    public void testFileWithColdestTemperature(){
           
            System.out.println("Coldest day was in file "+fileWithColdestTemperature());
            
            //System.out.println("All the Temperatures on the coldest day were:");
        }

}
/*
 * OUTPUT
 * -------
 * Finding lowest temperature on 2015-01-01:
 * Coldest temperaure:24.1 at 6:51 AM
 * 
 */