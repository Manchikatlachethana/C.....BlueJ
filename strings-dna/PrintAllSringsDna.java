
/**
 * Description of PrintAllSringsDna class
 * 
 * METHODS
 * -------
 * 1.findStopCodon: finds stopCodons(TAA,TGA,TAG)
 * 2.findGene: finds gene (with has start and stop codons) from given dna strand (ATGCGTTTTTTTTAA)
 * 3.getAllGenes: will store all genes found from findGene method in StorageResource.
 * 4.cgRatio: finds out which gene has highest CG ratio(C's,G's) from dna strand.
 * 5.void method processGenes that has one parameter sr, which is a StorageResource of strings does following:
 *   -prints all the Strings in sr that are longer than 9 characters
 *   -prints the number of Strings in sr that are longer than 9 characters
 *   -prints the Strings in sr whose C-G-ratio is higher than 0.35
 *   -prints the number of strings in sr whose C-G-ratio is higher than 0.35
 *   -prints the length of the longest gene in sr
 * 6.testProcessGenes: does differnt tests on processGenes by considering differnt testcases on dna strands.
 * 
 * @version 1.0
 */
import edu.duke.*;
public class PrintAllSringsDna {
    
    public int findStopCodon(String dnaStr,int startIndex,String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon,startIndex+3);
        while(currIndex!=-1) {
            int diff = currIndex-startIndex;
            if(diff % 3 == 0) {
                return currIndex;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex+1);
            }
        }
        return dnaStr.length(); 
    }
    
    
    
    public String findGene(String dna,int where) {
        int startIndex = dna.indexOf("ATG",where);
        if(startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = 0;
        if(taaIndex == -1 ||tgaIndex!=-1&&tgaIndex<tagIndex) {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        if(minIndex == -1||(tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        if(minIndex == -1) {
            return "";
        }
        return dna.substring(startIndex, minIndex+3);

    }
    
    public   StorageResource getAllGenes(String dna) {
        StorageResource geneList  = new StorageResource();
        int startIndex = 0; 
        while(true) {
            String currentGene = findGene(dna,startIndex);
            if(currentGene.isEmpty()) {
                break;
            }
             geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex)+currentGene.length();
        }
        return geneList;
    }
    
    public  float cgRatio(String dna){
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
     }
    public void processGenes(StorageResource sr){
        int longStringCount = 0;
        int cgRatioHigh = 0;
        int longestGenelen = 0;
        for(String s:sr.data()){
            if(s.length()>9){
                longStringCount++;
                System.out.println("Strings length longer than 9 characters:"+s);
                
            }
            if(cgRatio(s)>0.35){
                cgRatioHigh++;
              System.out.println("Strings in sr whose C-G-ratio is higher than 0.35:"+s);  
              }
            else{
                System.out.println("No Strings in sr are having C-G-ratio is higher than 0.35");
            }
            
            if(s.length()>longestGenelen){
                longestGenelen = s.length();
            }
        }
        System.out.println("Number of Strings length longer than 9 characters:"+longStringCount);
        System.out.println("Number of Strings in sr whose C-G-ratio is higher than 0.35:"+cgRatioHigh);
        System.out.println("length of the longest gene in sr:"+longestGenelen);
    }
    
    public void testProcessGenes(){
        String dna = "ATGCGTTTTTTTTAA";
        System.out.println("DNA:"+dna);
        StorageResource dnasr = getAllGenes(dna);
        processGenes(dnasr);
   
        /*String testcases---"ATGCGTTTTTTTTAA","ATGCCATAG","ATGCGTTTTTTTTTTTAAAAAAATAA","ATGCCATAG","ATGTAG";*/
        
    }
    /*
     * 
    public static void main(String []args){
        testProcessGenes()
    }
    */

}
/*
     * OUTPUT
     * -----
     * DNA:ATGCGTTTTTTTTAA
     * Strings length longer than 9 characters:ATGCGTTTTTTTTAA
     * No Strings in sr are having C-G-ratio is higher than 0.35
     * Number of Strings length longer than 9 characters:1
     * Number of Strings in sr whose C-G-ratio is higher than 0.35:0
     * length of the longest gene in sr:15
 */
