
/**
 * Write a description of Part4 here.
 * 
 * @author (Heeyam)
 * @version (May 3 2020)
 */
import edu.duke.*;

public class Part4 {
    public String findYoutubeURL(String words){
        String checkWords = words.toLowerCase();
        String checkStr = "youtube.com";
        int fromIdx = checkWords.indexOf("youtube");
        if( fromIdx == -1 ){
            return "";
        }
        int openQuotation = checkWords.lastIndexOf("\"", fromIdx);
        if ( openQuotation == -1 ){
            return "";
        }
        int endQuotation = checkWords.indexOf("\"", openQuotation+1);
        if ( endQuotation == -1 ){
            return "";
        }
        return words.substring(openQuotation, endQuotation+1);
    }
    public void testYoutubeURL(){
        String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        URLResource ur = new URLResource(url);
        for (String words : ur.words()) {
            String result = findYoutubeURL(words);
            if(result != ""){
               System.out.println(result);
            }
        }
    }
}
