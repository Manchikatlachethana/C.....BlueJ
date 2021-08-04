
/**
 * Description of BabyNames
 * ------->FOR CHECKING THE TESTCASES TESTING FOLDER IS USED WHICH HAS SMALL CSV FILES OF YEARS - 2012,2013,2014.
 * METHODS
 * -------
 * printNames: Prints those baby names whose number of borns are greater than equal to 200.
 * totalBirths: Prints total number of births,boys,girls also print the number of girls names , 
 *                the number of boys names and the total names in the file.
 * getRank: Returns the rank of the name in the file for the given gender,  where rank 1 is the name with the largest number of births.
 *            If the name is not in the file, then -1 is returned. 
 * getName:  Returns the name of the person in the file at this rank, for the given gender, 
 *            where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then “NO NAME”  is returned.
 * whatIsNameInYear: Determines what name would have been named if they were born in a different year, based on the same popularity. 
 *                   i.e,you should determine the rank of name in the year they were born, and then print the name born in newYear 
 *                   that is at the same rank and same gender.
 * yearOfHighestRank: Selects a range of files to process and returns an integer, the year with the highest rank for the name and gender.
 *                    If the name and gender are not in any of the selected files, it should return -1. 
 * getAverageRank: Selects a range of files to process and returns a double representing the average rank of the name and gender over 
 *                 the selected files. It should return -1.0 if the name is not ranked in any of the selected files.
 * getTotalBirthsRankedHigher: Returns an integer, the total number of births of those names with the same gender and same year 
 *                             who are ranked higher than name. 
 *                                          
 * @version 1.0
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {
    
public void printNames(){
          FileResource fr = new FileResource();
           for(CSVRecord rec:fr.getCSVParser(false)){  
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
       int totalFNames = 0;
       int totalMNames = 0;
        for(CSVRecord rec:fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2)); 
            totalBirths += numBorn;
            if(rec.get(1).equals("M")){
               totalBoys += numBorn; 
            }
            else{
                totalGirls += numBorn; 
            }
            if(rec.get(1).equals("F")){
                totalFNames++;
            }
            else{
                totalMNames++;
            }
        
        }
        System.out.println("total births = "+totalBirths);
        System.out.println("total girls = "+totalGirls);
        System.out.println("total boys = "+totalBoys);
        System.out.println("total girls names  = "+totalFNames);
        System.out.println("total boys names = "+totalMNames);

}


public void testTotalBirths(){
       FileResource fr = new FileResource("testing/yob2012short.csv");
       totalBirths(fr);
       }
       
       
public int getRank(int year,String name,String gender){
     System.out.print("Rank of "+name+" with gender "+gender+" and year  "+year+" is " );
     int rank = 0;
     FileResource fr = new FileResource("testing/yob"+year+"short.csv");
     for(CSVRecord rec:fr.getCSVParser(false)){
           if(rec.get(1).equals(gender)){
            rank++;
         
           if(rec.get(0).equals(name)){
                  break;
            }
        }
        else {
            rank = -1;
        }
     }
     return rank;
         }
        
         
public String getName(int year,int rank,String gender){
    System.out.print("Name with gender "+gender+" year "+year+" and rank  "+rank+" is " );
    FileResource fr = new FileResource("testing/yob"+year+"short.csv");
    int count = 0;
   for(CSVRecord rec:fr.getCSVParser(false)){
        if(rec.get(1).equals(gender)){
        count++;
        if(count == rank) return rec.get(0);
      }
        
    
     }
     
   return "NO NAME";
    }
         
public void whatIsNameInYear(String name,int year,int newYear,String gender ){
    FileResource fr = new FileResource("testing/yob"+year+"short.csv");
    FileResource fr1 = new FileResource("testing/yob"+newYear+"short.csv");
    int rank1 = 0;
    int rank2 = 0;
    for(CSVRecord rec:fr.getCSVParser(false)){
         if(rec.get(1).equals(gender)){
             rank1++;
          }
         if(rec.get(0).equals(name)){
                  break;
            }
       }
    for(CSVRecord rec:fr1.getCSVParser(false)){
         if(rec.get(1).equals(gender)){
             rank2++;
          }
         if(rank1==rank2){
             if(gender.equals("F"))
             System.out.println(name+" born in "+year+" would be "+rec.get(0)+" if she was born in "+newYear);
             else 
             System.out.println(name+" born in "+year+" would be "+rec.get(0)+" if he was born in "+newYear);
            }
       }
       
    }
    
public int yearOfHighestRank(String name,String gender){
        System.out.print(name+" of "+gender);
        int year = -1;
        int rhigh = 0;
        int flag = 0;
        String fname = "";
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            int rank = 0;
            for(CSVRecord rec:fr.getCSVParser(false)){
                if(rec.get(1).equals(gender)){
                    rank++;
                   if(rec.get(0).equals(name)){
                    //System.out.println("::"+rank);
                    if(flag == 0) {
                            flag = 1;
                            rhigh = rank;
                        }
                        
                        if(rank<=rhigh){
                        rhigh = rank;
                        fname = f.getName();
                        year = Integer.parseInt(fname.substring(3,7));
                        //System.out.println(" and rank:"+rank);
                    }
                    
                    break;
                }
                   
                    
               
                }
                
            }
            
        }
        System.out.print(" and rank "+rhigh);

        return year;
        }
        
        
public  double getAverageRank(String name,String gender){
    System.out.print(name+" of "+gender);
    double avgRank = 0.0;
    int totalcount = 0;
    DirectoryResource dr = new DirectoryResource();
    for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            totalcount++;
            int rank = 0;
            for(CSVRecord rec:fr.getCSVParser(false)){
                
                if(rec.get(1).equals(gender)){
                    rank++;
                    if(rec.get(0).equals(name)){
                        avgRank += rank;
                    }
                    
                }
            }
            
        }
    if(avgRank == 0.0) return -1.0;
    
    return avgRank/totalcount;
        }

        
public int getTotalBirthsRankedHigher(int year,String name,String gender ){
         System.out.print("For "+name+ " of "+gender+" in "+year);
         int totalHighBirths = 0;
         FileResource fr = new FileResource("testing/yob"+year+"short.csv");
         for(CSVRecord rec:fr.getCSVParser(false)){
               if(rec.get(1).equals(gender)){
                   totalHighBirths += Integer.parseInt(rec.get(2));
                   if(rec.get(0).equals(name)){
                       totalHighBirths -= Integer.parseInt(rec.get(2));
                       break;
                       
                      } 
                   }
                }
         return totalHighBirths;
          }
    
          
public static void main(String[] args){
    BabyNames b = new BabyNames();
    System.out.println(b.getRank(2012,"Sophia","F"));
    System.out.println(b.getName(2012,4,"F"));
    b.whatIsNameInYear("Isabella",2012,2014,"F");
    System.out.println(" in year: "+b.yearOfHighestRank("Olivia","F"));
    System.out.println(" with Average Rank: "+b.getAverageRank("Mason","M"));
    System.out.println(" total high ranked births: "+b.getTotalBirthsRankedHigher(2012,"Ava","F"));
   }
   
}


/*
    * OUTPUT---printNames method.
    * -----
    * Name - Sophia, Gender - F, Num Born - 10
    * Name - Emma, Gender - F, Num Born - 9
    * Name - Isabella, Gender - F, Num Born - 8
    * Name - Olivia, Gender - F, Num Born - 7
    * Name - Ava, Gender - F, Num Born - 6
    * Name - Jacob, Gender - M, Num Born - 8
    * Name - Mason, Gender - M, Num Born - 7
    * Name - Ethan, Gender - M, Num Born - 7
    * Name - Noah, Gender - M, Num Born - 6
    * Name - William, Gender - M, Num Born - 5
    * 
    * -----testTotalBirths method
    * total births = 73
      total girls = 40
      total boys = 33
      total girls names  = 5
      total boys names = 5
      
    *  ------Main method
      Rank of Sophia with gender F and year  2012 is 1
      Name with gender F year 2012 and rank  4 is Olivia
      Isabella born in 2012 would be Sophia if she was born in 2014
      Olivia of F and rank 2 in year: 2014
      Mason of M with Average Rank: 3.0
      For Ava of F in 2012 total high ranked births: 34
    */

