
/**
 * ----COUNTING RATIOS,CODONS----
 * Method cgRatio: has one String parameter dna, and 
 * Finds the ratio of C’s and G’s in dna as a fraction of the entire strand of DNA.
 * Method countCTG that has one String parameter dna, and
 * returns the number of times the codon CTG appears in dna
 * 
 * @version 1.0
 */
public class CgRatio {
  
    public static float cgRatio(String dna){
        int cCount = 0;
        int gCount = 0;
        for(int i=0;i<dna.length();i++){
            if(dna.charAt(i) == 'C'){
                cCount++;
        }
        if(dna.charAt(i) == 'G'){
                gCount++;
        }
    }
    return  (float) (cCount+gCount) / dna.length();
    
    /*----Another alternative----
        int cgCount = 0;
        int start = 0;
        
        while(true){
          int cpos = dna.indexOf("C",start);
          if(cpos == -1){
              start = 0;
              break;
            }
            cgCount++;
            start = cpos+1;
        }
        while(true){
          int gpos = dna.indexOf("G",start);
          if(gpos == -1){
              start = 0;
              break;
            }
            cgCount++;
            start = gpos+1;    
          }
          return  (float) cgCount / dna.length();
           */
    }
    
    
    public static int countCTG(String dna){
        int count = 0;
        int start = 0;
        
        while(true){
            int startIndex = dna.indexOf("CTG",start);
            if(startIndex == -1){
                break;
            }
            count++;
            start = startIndex+3;
        }
      return count;
    }
    
        public static void main(String []args){
        System.out.println("Ratio of C’s and G’s in dna:"+cgRatio("ATGCCATAG"));
        System.out.println("CTG codon count:"+countCTG("CTGATCTGAG"));
    }
        
    
    }
/*
OUTPUT
------
Ratio of C’s and G’s in dna:0.44444445
CTG codon count:2

*/
