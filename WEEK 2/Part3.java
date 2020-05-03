
/**
 * Write a description of Part3 here.
 * 
 * @author (Heeyam)
 * @version (Apr 25 2020)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int fromIdx = 0;
        int strIdx = stringb.indexOf(stringa, fromIdx);
        
        if(strIdx == -1){
            return false;
        }
        fromIdx = strIdx + stringa.length();
        strIdx = stringb.indexOf(stringa, fromIdx);
        if(strIdx == -1){
            return false;
        }
        return true;
    }
    
    public void testing(){
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));        
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        
        String stringa = "an";
        String stringb = "banana";
        String strresult = lastPart(stringa, stringb);
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + strresult +"."); 
    
        stringa = "zoo";
        stringb = "forest";
        strresult = lastPart(stringa, stringb);
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + strresult +"."); 
    }
    
    public String lastPart(String stringa, String stringb){
        int fromIdx = 0;
        int strIdx = stringb.indexOf(stringa, fromIdx);
        if(strIdx == -1) {
            return stringb;
        }
        return stringb.substring(strIdx, strIdx + stringa.length() + 1);
    }
}
