
/**
 * Using Csv library to get fields from csv file .
 *  
 * @version 1.0
 */

import edu.duke.*;
import org.apache.commons.csv.*;
public class FirstCsv {
    public void readFood(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            System.out.print(record.get("Name")+" ");
            System.out.print(record.get("Favorite Color")+" ");
            System.out.println(record.get("Favorite Food"));
            
        }
    }
    

}

/*
OUTPUT
-----
Drew Green Chocolate
Owen Blue Pineapple
Susan Purple Cake
Robert Green Pizza
*/

