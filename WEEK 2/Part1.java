
/**
 * Write a description of Part1 here.
 * 
 * @author (Heeyam)
 * @version (Apr 25 2020)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        String str = "";
        int startIdx = 0;
        int stopIdx = 0;
        
        startIdx = dna.indexOf("ATG");
        if(startIdx == -1){
            return "";
        }
        stopIdx = dna.indexOf("TAA", startIdx+3);
        if(stopIdx == -1){
            return "";
        }
        
        int subStr = stopIdx - startIdx;
        if(subStr % 3 == 0){
            return dna.substring(startIdx, stopIdx+3);
        }
        
        return "";
    }
    
    public void testSimpleGene(){
        String dna1 = "AAATAA";
        System.out.println("DNA is " + findSimpleGene(dna1));
        
        String dna2 = "ATGAAA";
        System.out.println("DNA is " + findSimpleGene(dna2));
        
        String dna3 = "ABCDEFG";
        System.out.println("DNA is " + findSimpleGene(dna3));
        
        String dna4 = "ATGABCTAA";
        System.out.println("DNA is " + findSimpleGene(dna4));
        
        String dna5 = "ATGABCDTAA";
        System.out.println("DNA is " + findSimpleGene(dna5));
    }
}
