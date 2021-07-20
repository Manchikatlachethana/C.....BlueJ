/*
 * Finding Multiple Genes(using Break).
 * If no gene found in dna it returns empty string.
 * @author MC
 * Version-1.4
 */
public class AllGenesBreak {
	
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
	
	public static String findGene(String dna,int where) {
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
	
	public static void printAllGenes(String dna) {
		int startIndex = 0; 
		while(true) {
			String currentGene = findGene(dna,startIndex);
			if(currentGene.isEmpty()) {
				break;
			}
			System.out.println(currentGene);
			startIndex = dna.indexOf(currentGene, startIndex)+currentGene.length();
		}
	}
	
	public static void testOn(String dna) {
		System.out.println("Testing all printGenes on dna:"+dna);
		printAllGenes(dna);
	}
	public static void main(String[] args) {

		testOn("ATGATCTAATTTAGCTGCAAGGTGAAGA");
		testOn("");
		testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA ");
		
	}

}
/*
OUTPUT
-------
Testing all printGenes on dna:ATGATCTAATTTAGCTGCAAGGTGAAGA
ATGATCTAA
Testing all printGenes on dna:
Testing all printGenes on dna:ATGATCATAAGAAGATAATAGAGGGCCATGTAA 
ATGATCATAAGAAGATAA
ATGTAA

*/
