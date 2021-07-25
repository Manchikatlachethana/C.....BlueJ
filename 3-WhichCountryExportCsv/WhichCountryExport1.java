
/**
 * Description of WhichCountryExport1
 * METHODS
 * -------
 * 1.tester: createS your CSVParser and call each of the other methods
 * 2.countryInfo: returns a string of information about the country or returns “NOT FOUND” if there is no information about the country.
 * 3.listExportersTwoProducts: prints the names of all the countries that have both exportItem1 and exportItem2 as export items.
 * @version 1.0
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountryExport1 {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser,"Germany"));
        CSVParser parser1 = fr.getCSVParser();
        listExportersTwoProducts(parser1,"gold","diamonds");
        
    }
    public String countryInfo(CSVParser parser,String country){
        System.out.println("Selected Country: "+country);
        for(CSVRecord record:parser){
            String Country1 =record.get("Country");
            if(Country1.contains(country)){
                
                return record.get("Country")+":"+record.get("Exports")+":"+record.get("Value (dollars)");
            }
            
        } 
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
        System.out.println("Countries which have exports of both "+exportItem1+" and "+exportItem2+":");
        for(CSVRecord record:parser){
            
            String export1 = record.get("Exports");
            String export2 = record.get("Exports");
            
            if( (export1.contains(exportItem1))&& (export2.contains(exportItem2)) ){
            
                System.out.println(record.get("Country"));
            }
        }
        
    }

}
/*
 * OUTPUT
 * ------
 * Selected Country: Germany
 * Germany:motor vehicles, machinery, chemicals, computer and electronic products, electrical equipment, pharmaceuticals, metals, transport equipment, foodstuffs, textiles, rubber and plastic products:$1,547,000,000,000
 * Countries which have exports of both gold and diamonds:
 * Armenia
 * Congo (Democratic Republic of the)
 * Ghana
 * Guinea
 * Namibia
 * South Africa
 */
