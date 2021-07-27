
/**
 * Description of WhichCountryExport1
 * METHODS
 * -------
 * 1.tester: createS your CSVParser and call each of the other methods
 * 2.countryInfo: returns a string of information about the country or returns “NOT FOUND” if there is no information about the country.
 * 3.listExportersTwoProducts: prints the names of all the countries that have both exportItem1 and exportItem2 as export items.
 * 4.numberOfExporters: returns the number of countries that export exportItem.
 * 5.bigExporters: prints the names of countries and their Value amount for all countries
 *                 whose Value (dollars) string is longer than the amount string(usrvalue).
 * @version 1.1
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
        CSVParser parser2 = fr.getCSVParser();
        System.out.println(numberOfExporters(parser2,"gold"));
        CSVParser parser3 = fr.getCSVParser();
        bigExporters(parser3,"$323,400,000,000");
        
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
    
    public int numberOfExporters(CSVParser parser,String exportItem ){
        int exportCount = 0;
        System.out.println("Number of Countries which have exports "+exportItem+":");
          for(CSVRecord record:parser){
            String exportitem = record.get("Exports");
            if(exportitem.contains(exportItem)){
                exportCount++;
        }
        
    }
    
    return exportCount;
    }
    
    public void bigExporters(CSVParser parser,String usrvalue){
        System.out.println("Countries which have dollar value greater than "+usrvalue+" (big exporters):");
        for(CSVRecord record:parser){
            String value = record.get("Value (dollars)");
            if(value.length()>usrvalue.length()){
                System.out.println(record.get("Country")+" "+value);
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
 * Number of Countries which have exports gold:
 * 30
 * Countries which have dollar value greater than $323,400,000,000 (big exporters):
 * China $2,252,000,000,000
 * European Union $2,173,000,000,000
 * Germany $1,547,000,000,000
 * United States $1,610,000,000,000
 */
