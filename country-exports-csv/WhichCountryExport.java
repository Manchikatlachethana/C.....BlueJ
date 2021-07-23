
/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * CSV FILES :exportdata.csv(original file),exportssmall.csv(less rows file from original file)
 * @version 1.0
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountryExport 
{
    public void listExporters(CSVParser parser,String exportOfIntrest){
        //for each row in the CSV File
        for(CSVRecord record:parser){
            //Look at the "Exports" column
            String export = record.get("Exports");
            //Check if it contains exportOfInterest
            if(export.contains(exportOfIntrest)){
                
                //If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
        }
    }
}
public void whoExportsCoffee(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser,"coffee");
   }

}
/*
 * OUTPUT(exportssmall.csv)
 * ------
 *Madagascar
 *Malawi
 */