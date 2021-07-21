
/**
 * Finding Multiple Genes and storing using StorageResource.
 * If no gene found in dna it returns empty string.
 * Version-15 
 */
import edu.duke.*;
public class AllGenesStored {
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
	
	public static  StorageResource getAllGenes(String dna) {
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
	
	public static void testOn(String dna) {
	   
		System.out.println("Testing all printGenes on dna:"+dna);
		StorageResource genes = getAllGenes(dna);
		for(String g:genes.data()) {
			System.out.println(g);
		} 
	}
	public static void main(String[] args) {
    System.out.println("Gene will not be printed if gene not found");
		testOn("ATGATCTAATTTAGCTGCAAGGTGAAGA");
		testOn("");
		testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA ");
	}

}
/*
OUTPUT
------
Gene will not be printed if gene not found
Testing all printGenes on dna:ATGATCTAATTTAGCTGCAAGGTGAAGA
ATGATCTAA
Testing all printGenes on dna:
Testing all printGenes on dna:ATGATCATAAGAAGATAATAGAGGGCCATGTAA 
ATGATCATAAGAAGATAA
ATGTAA
*/
