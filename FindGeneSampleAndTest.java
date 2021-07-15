/*
 * Finding gene from DNA
 * @MC
 * Version-1
 */
public class FindGeneSampleAndTest {
	
	public static String findGeneSample(String dna) {
		String result = "";
		int startIndex=dna.indexOf("ATG");
		if(startIndex == -1) {
			return "(No start codon)gene doesn't exist in dna";
		}
		int stopIndex=dna.indexOf("TAA",startIndex+3);
		if(stopIndex == -1) {
			return "(No stop codon)gene doesn't exist in dna";
		}
		result = dna.substring(startIndex,stopIndex+3);
		return result;
	}
	
	public static void main(String []args) {
		String dna = "AATGTAA";
		System.out.println("DNA strand is:"+dna);
		String gene = findGeneSample(dna);
		System.out.println("Gene is:"+gene);
		
		dna = "ATCCTATGCTTCGGCTGCCTAATATGGT";
		System.out.println("DNA strand is:"+dna);
		String gene1 = findGeneSample(dna);
		System.out.println("Gene is:"+gene1);
		
		dna = "ATCCTCTTCGGCTGCCTAAGGT";
		System.out.println("DNA strand is:"+dna);
		String gene2 = findGeneSample(dna);
		System.out.println("Gene is:"+gene2);
		
		dna = "ATGCCTCTTCGGCTGCCGGT";
		System.out.println("DNA strand is:"+dna);
		String gene3 = findGeneSample(dna);
		System.out.println("Gene is:"+gene3);
		

	}	

}
/*
DNA strand is:AATGTAA
Gene is:ATGTAA
DNA strand is:ATCCTATGCTTCGGCTGCCTAATATGGT
Gene is:ATGCTTCGGCTGCCTAA
DNA strand is:ATCCTCTTCGGCTGCCTAAGGT
Gene is:(No start codon)gene doesn't exist in dna
DNA strand is:ATGCCTCTTCGGCTGCCGGT
Gene is:(No stop codon)gene doesn't exist in dna

*/
