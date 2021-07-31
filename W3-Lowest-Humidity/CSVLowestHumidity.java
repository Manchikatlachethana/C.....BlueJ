
/**
 * Description of CSVLowestHumidity : Finding lowest humidity
 * 
 * METHODS
 * -------
 * 1.lowestHumidityInFile: Returns the CSVRecord that has the lowest humidity. If there is a tie, 
 *                            then returnS the first such record that was found.
 *  Note: sometimes there is not a number in the Humidity column but instead there is the string “N/A”. 
 *        This only happens very rarely. You should check to make sure the value you get is not “N/A” before converting it to a number.
 *        
 * 2.testLowestHumidityInFile: Testing lowestHumidityInFile method.
 * 3.lowestHumidityInManyFiles: Returns a CSVRecord that has the lowest humidity over all the files. 
 *                              If there is a tie, then return the first such record that was found.
 * 4.testLowestHumidityInManyFiles: Tests lowestHumidityInManyFiles method and to print the lowest humidity and
 *                                  the time the lowest humidity occurred.                           
 * @version 1.0
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVLowestHumidity {
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowHumidity = null;
       for(CSVRecord record:parser){
           if(lowHumidity==null) lowHumidity=record;
           if(lowHumidity.get("Humidity").equals("N/A")) lowHumidity=null;
           if(!record.get("Humidity").equals("N/A")){
               Integer currHum = Integer.parseInt(record.get("Humidity"));
               Integer lowHum = Integer.parseInt(lowHumidity.get("Humidity"));
               if(currHum < lowHum)
                    {
                        lowHumidity = record;
                    }
                }
            
            }
       return lowHumidity;
       }
       
    
        
    public void testLowestHumidityInFile(){
          FileResource fr = new FileResource();
          CSVParser parser = fr.getCSVParser();
          CSVRecord lowHum = lowestHumidityInFile(parser);
          System.out.println("Lowest Humidity was "+lowHum.get("Humidity")+" at "+lowHum.get("DateUTC"));
        
       }
         
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowHumidity = null;
        DirectoryResource dr = new DirectoryResource();
        
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord record = lowestHumidityInFile(fr.getCSVParser());
            if(lowHumidity == null){
                lowHumidity = record;
            }
            if(!record.get("Humidity").equals("N/A")){
               Integer currHum = Integer.parseInt(record.get("Humidity"));
               Integer lowHum = Integer.parseInt(lowHumidity.get("Humidity"));
               if(currHum < lowHum)
                    {
                        lowHumidity = record;
                    }
                }
        }
        return lowHumidity;
         }
         
    public void testLowestHumidityInManyFiles(){
        CSVRecord result = lowestHumidityInManyFiles(); 
        System.out.println("Lowest Humidity was "+result.get("Humidity")+" at "+result.get("DateUTC"));
   
         }
 }
 
/*
 * OUTPUT
 * ------
 * //Executing testLowestHumidityInFile
 * Lowest Humidity was 41 at 2015-01-01 17:51:00
 * 
 * //Executing testLowestHumidityInManyFiles(SELECTING 1,2 JAN 2015)
 * Lowest Humidity was 41 at 2015-01-01 17:51:00
 */    


