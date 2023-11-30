package BarbaraFriesen_COMP251Lab4;

/******************************************************************************
 *  Under Linux:
 *  Compilation:  javac LangValidator.java
 *  Execution:    java LangValidator file.txt
 *  
 *  Reads in a text file and checks to see if the strings (one string per line)
 *  belongs to the following language:
 *  L={w$w' | w is possibly an empty string of characters except $, and w' = reverse(w)}
 *
 *  % java  java LangValidator
 *  $
 *  true
 *
 *  % java LangValidator
 *  aab$aba
 *  false
 *
 ******************************************************************************/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LangValidator {
	
    public static boolean isValidString(String s, int length, int endIndex, int startIndex) {
    	if(length==1&&s.charAt(startIndex)=='$') {return true;}
    	
    	if(s.charAt(startIndex)==s.charAt(endIndex)&&s.charAt(startIndex) != '$'&&s.charAt(endIndex) != '$')
    		{
    			return isValidString(s, length-2, endIndex-1, startIndex+1);
    		}
    	return false;
    }

	
    public static void main(String[] args) throws FileNotFoundException {
       	Scanner fin = new Scanner(new FileReader("input.txt"));
        while (fin.hasNext()) {
            String str = fin.nextLine();
            System.out.println(str);
            System.out.println(isValidString(str, str.length(), str.length()-1, 0));
            System.out.println();
        }
    }

	
	
}

