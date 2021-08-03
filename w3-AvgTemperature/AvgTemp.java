
/**
 * Description of AvgTemp
 * 
 * METHODS
 * ------
 * 1.averageTemperatureInFile:Returns a double that represents the average temperature in the file
 * 2.testAverageTemperatureInFile:Tests averageTemperatureInFile method.
 * 3.averageTemperatureWithHighHumidityInFile: Returns a double that represents the average temperature 
 *                                       of only those temperatures when the humidity was greater than or equal to value.
 * 4.testAverageTemperatureWithHighHumidityInFile: Tests averageTemperatureWithHighHumidityInFile method.
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
             return avgtemp/count;
         }
         public void testAverageTemperatureInFile(){
             FileResource fr = new FileResource();
             
             System.out.println("Average temperature in file is "+averageTemperatureInFile(fr.getCSVParser()));
            }
            
            
            
         public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){
                double avgTemp = 0.0;
                int count = 0;
                 
                for(CSVRecord record:parser){
                     if(Integer.parseInt(record.get("Humidity"))>= value){
                       Double currTemp = Double.parseDouble(record.get("TemperatureF"));
                       avgTemp = avgTemp+currTemp;
                       count++;
                    }
                     
                    }
                if(count == 0){
                        return 0.0;
                    }
                return avgTemp/count;
            }
         public void testAverageTemperatureWithHighHumidityInFile(){
             DirectoryResource dr = new DirectoryResource();
             double result = 0.0;
             for(File f:dr.selectedFiles()){
             FileResource fr = new FileResource(f);
             result = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);
            }
            System.out.println(result);
             if(result == 0.0 ){
             System.out.println("No temperatures with that humidity");
             }
            else{
                System.out.println("Average Temp when high Humidity is "+result);
            }
         }
         }


/*
 * OUTPUT
 * ------
 * //executing testAverageTemperatureInFile(selecting 1 jan 2015)
 * Average temperature in file is 37.93333333333334
 * //executing testAverageTemperatureWithHighHumidityInFile (selecting 1 jan 2015)
 * Average Temp when high Humidity is 26.74285714285714
 */