
/**
 * Finding a Gene - Using the Simplified Algorithm.
 * 
 * @author MC 
 * @version 1
 */
public class Part1 {
    
    public String findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if(stopIndex == -1){
            return "";
        }
        String result = "";
        if((stopIndex-startIndex)%3==0){
            result = dna.substring(startIndex,stopIndex+3);
        }
        return result;
    }
    
    public void testSimpleGene(){
        String t1 = "AGCTAA";
        String t2 = "ATGCAA";
        String t3 = "AGCGCATAA";
        String t4 = "CAGATGC";
        String t5 = "ATGCTATAA";
        String t6 = "AATGGCTAA";
        
        System.out.println("DNA STRAND: "+t1);
        String result1 = findSimpleGene(t1);
        System.out.println("GENE FROM DNA: "+result1);
        String result2 = findSimpleGene(t2);
        System.out.println("DNA STRAND: "+t2);
        System.out.println("GENE FROM DNA: "+result2);
        String result3 = findSimpleGene(t3);
        System.out.println("DNA STRAND: "+t3);
        System.out.println("GENE FROM DNA: "+result3);
        String result4 = findSimpleGene(t4);
        System.out.println("DNA STRAND: "+t4);
        System.out.println("GENE FROM DNA: "+result4);
        String result5 = findSimpleGene(t5);
        System.out.println("DNA STRAND: "+t5);
        System.out.println("GENE FROM DNA: "+result5);
        String result6 = findSimpleGene(t6);
        System.out.println("DNA STRAND: "+t6);
        System.out.println("GENE FROM DNA: "+result6);
        
        
        
        
    }

}
