
/**
 * Write a description of Part2 here.
 * 
 * @author (Heeyam)
 * @version (Apr 25 2020)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String str = "";
        int startIdx = 0;
        int stopIdx = 0;
        String upperStartCodon = startCodon.toUpperCase();
        String upperStopCodon = stopCodon.toUpperCase();
        String lowerStartCodon = startCodon.toLowerCase();
        String lowerStopCodon = stopCodon.toLowerCase();
        
        startIdx = dna.indexOf(upperStartCodon);
        if(startIdx == -1){
            startIdx = dna.indexOf(lowerStartCodon);
            if(startIdx == -1){
                return "";
            }
        }
        stopIdx = dna.indexOf(upperStopCodon, startIdx+3);
        if(stopIdx == -1){
            stopIdx = dna.indexOf(lowerStopCodon, startIdx+3);
            if(stopIdx == -1){
                return "";
            }
        }
        
        int subStr = stopIdx - startIdx;
        if(subStr % 3 == 0){
            return dna.substring(startIdx, stopIdx+3);
        }
        
        return "";
    }
    
    public void testSimpleGene(){
        String startCodon = "ATG";
        String stopCodon = "TAA";
       
        String dna1 = "ATGGGTTAAGTC";
        System.out.println("DNA is " + findSimpleGene(dna1,startCodon, stopCodon));
        
        String dna2 = "atgggttaagtc";
        System.out.println("DNA is " + findSimpleGene(dna2,startCodon, stopCodon));
        
        String dna3 = "ABCDEFG";
        System.out.println("DNA is " + findSimpleGene(dna3,startCodon, stopCodon));
        
        String dna4 = "ATGABCTAA";
        System.out.println("DNA is " + findSimpleGene(dna4,startCodon, stopCodon));
        
        String dna5 = "ATGABCDTAA";
        System.out.println("DNA is " + findSimpleGene(dna5,startCodon, stopCodon));
    }
}
