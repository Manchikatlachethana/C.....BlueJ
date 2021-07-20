/*
 * Finding gene from DNA(but having codons(A,T,G,C) in substring with multiple of 3)
 * @author MC
 * Version-1.1
 */
public class FindGeneWhile {
	
	public static String findGene(String dna) {
		int startIndex = dna.indexOf("ATG");
		int currIndex = dna.indexOf("TAA",startIndex+3);
		while(currIndex!=-1) {
			if((currIndex- startIndex)%3==0) {
				return dna.substring(startIndex,currIndex+3);
			}
			else {
				currIndex = dna.indexOf("TAA",currIndex+3);
			}
		}
		return "Not present in dna";
	}

	public static void main(String[] args) {
		String dna = "AATGCGTAATTAATCG";
		System.out.println("DNA strand is:"+dna);
		String gene = findGene(dna);
		System.out.println("Gene is:"+gene);
		
		dna = "CGATGGTTGATAAGCCTAAGCTATAA";
		System.out.println("DNA strand is:"+dna);
		String gene1 = findGene(dna);
		System.out.println("Gene is:"+gene1);
		
		dna = "CGATGGTTGATAAGCCTAAGCCTAAGCTAAA";
		System.out.println("DNA strand is:"+dna);
		String gene2 = findGene(dna);
		System.out.println("Gene is:"+gene2);

	}

}

/*
OUTPUT
-------
DNA strand is:AATGCGTAATTAATCG
Gene is:ATGCGTAATTAA
DNA strand is:CGATGGTTGATAAGCCTAAGCTATAA
Gene is:ATGGTTGATAAGCCTAAGCTATAA
DNA strand is:CGATGGTTGATAAGCCTAAGCCTAAGCTAAA
Gene is:Gene is not present in dna
*/
