
/**
 * Description of AvgTemp
 * 
 * METHODS
 * ------
 * averageTemperatureInFile:Returns a double that represents the average temperature in the file
 * testAverageTemperatureInFile:Tests averageTemperatureInFile method.
 * 
 * 
 *  
 * @version 1.0
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class AvgTemp {
         public double averageTemperatureInFile(CSVParser parser){
             double avgtemp = 0.0;
             int count = 0;
             for(CSVRecord record:parser){
                
                 Double currTemp = Double.parseDouble(record.get("TemperatureF"));
                 avgtemp = avgtemp+currTemp;
                 count++;  
                
                }
             return avgtemp/(int)count;
         }
         public void testAverageTemperatureInFile(){
             FileResource fr = new FileResource();
             System.out.println("Average temperature in file is "+averageTemperatureInFile(fr.getCSVParser()));
            }
         /*public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){
                
            }*/

}
/*
 * OUTPUT
 * ------
 * Average temperature in file is 37.93333333333334
 *
 */