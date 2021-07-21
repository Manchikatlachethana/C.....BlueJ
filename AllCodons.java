/*
 * Finding 3 stop codons(TAA,TGA,TAG)
 * Version-1.2
 */
public class AllCodons {
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
		return dnaStr.length();	
	}
	
	public static String findGene(String dna) {
		int startIndex = dna.indexOf("ATG");
		if(startIndex == -1) {
			return "No start codon!";
		}
		int taaIndex = findStopCodon(dna,startIndex,"TAA");
		int tagIndex = findStopCodon(dna,startIndex,"TAG");
		int tgaIndex = findStopCodon(dna,startIndex,"TGA");
//		int temp = Math.min(tagIndex, tgaIndex);
//		int minIndex = Math.min(temp, taaIndex);
		int minIndex = Math.min(taaIndex,Math.min(tagIndex, tgaIndex));
		if(minIndex == dna.length()) {
			return "No Gene found!";
		}
		return dna.substring(startIndex, minIndex+3);

	}  

	public static void main(String[] args) {
		String dna = "xxxyyyzzzTAAxxxyyyzzzTGAxxyTAGAAT";
		System.out.println("dna"+dna);
		System.out.println(findGene(dna));
		int sindex = findStopCodon(dna,0,"TAA");
		System.out.println("stop codon taa found at:"+sindex);
		sindex = findStopCodon(dna,9,"TGA");
		System.out.println("stop codon tga found at:"+sindex);
		sindex = findStopCodon(dna,21,"TAG");
		System.out.println("stop codon tag found at:"+sindex);
		String dna1 = "ATGAAATGATAA";
		System.out.println("dna:"+dna1 + "\ngene:"+findGene(dna1));
		String dna2 = "ATGAAA";
		System.out.println("dna:"+dna2 + "\ngene:"+findGene(dna2));
		
	}

}
/* OUTPUT
-----------
dna:xxxyyyzzzTAAxxxyyyzzzTGAxxyTAGAAT
No start codon!
stop codon taa found at:9
stop codon tga found at:21
stop codon tag found at:27
dna:ATGAAATGATAA
gene:ATGAAATGA
dna:ATGAAA
gene:No Gene found!
*/
