
/**
 * Part 3: Problem Solving with Strings
 * 
 * @author MC 
 * @version 3
 */
public class Part3 {
    
    public boolean twoOccurrences(String stringa,String stringb){
        int count = 0;
        int bc = (stringb.length())-(stringa.length());
        for(int i = 0;i <= bc;i++){
            if(stringb.substring(i,i+stringa.length()).equals(stringa)){        
            count++;
        }  
    }
    if(count>=2){
            return true;
        }   
        else{
            return false;
        }
    }
    
    public void testing(){
        System.out.println(twoOccurrences("an","banana"));
        System.out.println(twoOccurrences("by","A story by Abby Long"));
        System.out.println(twoOccurrences("atg","ctgtatgta"));
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
    }
    
    public String lastPart(String stringa,String stringb){
        String result="";
        stringa.indexOf(stringa);
        if(stringb.contains(stringa)){
            result = stringb.substring(stringa.indexOf(stringa)+stringa.length()+1);
        }
        else{
            result=stringb;
        }
        return result;
        } 
        
    }

