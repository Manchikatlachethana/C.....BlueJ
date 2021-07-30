
/** TASK
 * 
 * Description of CSVColdest: To Find the coldest day of the year.
 *                          
 * CSV Files: nc_weather data folder that has year and day wise data
 * 
 * METHODS
 * -------
 * 1.coldestHourInFile: Returns the CSVRecord with the coldest temperature in the file and 
 *                     thus all the information about the coldest temperature, such as the hour of the coldest temperature.
 * 2.testColdestHourInFile : Test the method coldestHourInFile and print out information about that coldest temperature, 
 *                           such as the time of its occurrence.
 * 3.fileWithColdestTemperature:Returns a string that is the name of the file from selected files that has the coldest temperature. 
 * 4.testFileWithColdestTemperature:Tests fileWithColdestTemperature method.
 * 
 * 
 * @version 1.0
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
            FileResource fr = new FileResource("nc_weather/2015/weather-2015-01-09.csv");
            CSVParser parser = fr.getCSVParser();
            CSVRecord result = coldestHourInFile(parser);
            System.out.println("Finding lowest temperature on 2015-01-09:");
            System.out.println("Coldest temperaure:"+result.get("TemperatureF")+" at "+result.get("TimeEST"));
        }
        
        public String fileWithColdestTemperature(){
            CSVRecord coldest = null;
            File temp = null;
            DirectoryResource dr = new DirectoryResource();
           for(File f:dr.selectedFiles()){
               
           FileResource fr = new FileResource(f);
           CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
           
           if( coldest == null){
               coldest = currentRow;
               temp = f;
            } 
            else{
                Double currTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                Double lowestTemp = Double.parseDouble(coldest.get("TemperatureF"));
                if(currTemp < lowestTemp)
                {
                    temp = f;
                    coldest = currentRow;
                    
                }   
                
                
            }
           
         
        }
        
        return temp.getName();
    }
        
    public void testFileWithColdestTemperature(){
            //coldest day among multiple files.
            String cday = fileWithColdestTemperature();
            System.out.println("Coldest day was in file: "+cday);
            //coldest hour from that day
            FileResource fr = new FileResource("nc_weather/2015/"+cday);
            CSVParser parser = fr.getCSVParser();
            CSVRecord cHour = coldestHourInFile(parser);
            System.out.println("Coldest temperature on that day was "+cHour.get("TemperatureF"));
            //printing all temperatures from the coldest day
            CSVParser parser1 = fr.getCSVParser();
            System.out.println("All the Temperatures on the coldest day were:");
        for(CSVRecord record:parser1){
            System.out.println(record.get("DateUTC")+" "+record.get("TemperatureF"));
        }
        }

}
/*
 * OUTPUT
 * -------
 * Finding lowest temperature on 2015-01-01:
 * Coldest temperaure:24.1 at 6:51 AM
 * //(selecting first (1-3 )days of jan 2015)
 * Coldest day was in file: weather-2015-01-01.csv         
 * Coldest temperature on that day was 24.1
 * All the Temperatures on the coldest day were:
 * 2015-01-01 05:51:00 28.0
 * 2015-01-01 06:51:00 28.9
 * 2015-01-01 07:51:00 28.0
 * 2015-01-01 08:51:00 27.0
 * 2015-01-01 09:51:00 27.0
 * 2015-01-01 10:51:00 25.0
 * 2015-01-01 11:51:00 24.1
 * 2015-01-01 12:51:00 26.1
 * 2015-01-01 13:51:00 30.0
 * 2015-01-01 14:51:00 36.0
 * 2015-01-01 15:51:00 42.1
 * 2015-01-01 16:51:00 45.0
 * 2015-01-01 17:51:00 48.9
 * 2015-01-01 18:51:00 50.0
 * 2015-01-01 19:51:00 51.1
 * 2015-01-01 20:51:00 50.0
 * 2015-01-01 21:51:00 48.9
 * 2015-01-01 22:51:00 43.0
 * 2015-01-01 23:51:00 41.0
 * 2015-01-02 00:51:00 43.0
 * 2015-01-02 01:51:00 41.0
 * 2015-01-02 02:51:00 42.1
 * 2015-01-02 03:51:00 42.1
 * 2015-01-02 04:51:00 42.1
 * 
 */