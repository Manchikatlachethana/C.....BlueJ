
/**
 * Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
 * 
 * @author MC 
 * @version 2
 */
public class Part2 {
    
    public String findSimpleGene(String dna,int startCodon,int stopCodon ){

        if(startCodon == -1){
            return "";
        }
        if( stopCodon == -1){
            return "";
        }
        String result = "";
        if((stopCodon - startCodon)%3==0){
            result = dna.substring(startCodon,stopCodon+3);
        }
        return result;
    }
    
    public void testSimpleGene(){
        String t1 = "ATGGGTTAAGTC";
        String t2 = "gatgctataat";
        System.out.println("DNA STRAND: "+t1);
        String result1 = findSimpleGene(t1,0,6);
        System.out.println("GENE FROM DNA: "+result1);
        System.out.println("GENE FROM DNA(upper-lower): "+result1.toLowerCase());
        String result2 = findSimpleGene(t2,1,7);
        System.out.println("DNA STRAND: "+t2);
        System.out.println("GENE FROM DNA: "+result2);
        System.out.println("GENE FROM DNA(lower-upper): "+result1.toUpperCase());
        
        
        
        
    }

}
