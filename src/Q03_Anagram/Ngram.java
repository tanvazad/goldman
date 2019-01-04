package Q03_Anagram;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ngram {
	
	private static void generateNgrams(int N, String sent, List ngramList) {
		  String[] tokens = sent.split("\\s+"); //split sentence into tokens
		 
		  //GENERATE THE N-GRAMS
		  for(int k=0; k<(tokens.length-N+1); k++){
		    String s="";
		    int start=k;
		    int end=k+N;
		    for(int j=start; j<end; j++){
		     s=s+""+tokens[j];
		    }
		    //Add n-gram to a list
		    ngramList.add(s);
		  }
		}//End of method
	
	public static void main(String args[]) {
		List l = new ArrayList();
		
		
		String str = "  Hello   ";
		int strCount = str.length();
		String ltrim = str.replaceAll("^\\s+","");
		
		System.out.println(":"+ltrim+": spaces at the beginning:" + (strCount-ltrim.length()));
		
		String rtrim = str.replaceAll("\\s+$", "");
		System.out.println(":"+rtrim+": spaces at the end:" + (strCount-rtrim.length()));
	}
	
	
}
