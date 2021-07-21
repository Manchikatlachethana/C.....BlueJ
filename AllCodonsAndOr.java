/*
 * Finding 3 stop codons(TAA,TGA,TAG)using AND,OR
 * Version-1.3
 */
public class AllCodonsAndOr {
	
	public static int findStopCodon(String dnaStr,int startIndex,String stopCodon) {
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
		return -1;	
	}
	
	public static String findGene(String dna) {
		int startIndex = dna.indexOf("ATG");
		if(startIndex == -1) {
			return "No start codon!";
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
			return "No Gene found!";
		}
		return dna.substring(startIndex, minIndex+3);

	}  

	public static void main(String[] args) {

		String dna = "ATGCCCGGGAAATAACCC";
		System.out.println("DNA:"+dna);
		String gene = findGene(dna);
		if(!gene.equals("ATGCCCGGGAAATAA")) {
		System.out.println("error");
		}
		else {
			System.out.println("Gene is:"+gene);
		}
		
	}
		
}
/*
OUTPUT
-------
DNA:ATGCCCGGGAAATAACCC
Gene is:ATGCCCGGGAAATAA
*/
