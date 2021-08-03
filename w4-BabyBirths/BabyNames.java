
/**
 * BabyNames
 * --------
 * printNames: Prints those baby names whose number of borns are greater than equal to 200.
 * totalBirths: Prints total number of births,boys,girls.
 * @version 1.0
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyNames {
     public void printNames(){
        FileResource fr = new FileResource();
        for(CSVRecord rec:fr.getCSVParser(false)){  //false returns actual data leaving header row(as there is no header row for this data).
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 200){
            System.out.println("Name - "+rec.get(0)+", Gender - "+rec.get(1)+", Num Born - "+rec.get(2));
        }
    }
   }
   
   
   public void totalBirths(FileResource fr){
       int totalBirths = 0; 
       int totalBoys = 0;
       int totalGirls = 0;
        for(CSVRecord rec:fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2)); 
            totalBirths += numBorn;
            if(rec.get(1).equals("M")){
               totalBoys += numBorn; 
            }
            else{
                totalGirls += numBorn; 
            }
        
        }
        System.out.println("total births = "+totalBirths);
        System.out.println("total girls = "+totalGirls);
        System.out.println("total boys = "+totalBoys);
         }
         
         
   public void testTotalBirths(){
       FileResource fr = new FileResource("small-data/example-small.csv");
       totalBirths(fr);
       }

}
/*
    * OUTPUT---printNames method.
    * -----
    * Name - Isabella, Gender - F, Num Born - 200
    * Name - Ava, Gender - F, Num Born - 100
    * Name - Noah, Gender - M, Num Born - 100
    * Name - Liam, Gender - M, Num Born - 40
    * Name - Mason, Gender - M, Num Born - 30
    * Name - Jacob, Gender - M, Num Born - 20
    * Name - William, Gender - M, Num Born - 10
    * 
    * -----testTotalBirths method
    * total births = 1700
    * total girls = 1500
    * total boys = 200
    */
