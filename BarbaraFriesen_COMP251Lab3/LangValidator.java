package BarbaraFriesen_COMP251Lab3;

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
import java.util.Stack;

public class LangValidator {
	
    public static boolean isValidString(String s) {
    	int numChar = 0;
    	String split[] = s.split("\\$");
    	Stack<Character> stack = new Stack<Character>();
    	
    	//Checks if string contains more than one'$'
    	for(int i = 0; i < s.length(); i++)
    	{
    		if(s.charAt(i) == '$') {numChar++;}
    		if(numChar > 1) {return false;}
    	}
    	
    	if(split.length == 0) {return true;} //Checks if both are empty
    	
    	//adds left side of string to stack
    	for(int j = 0; j < split[0].length(); j++)
    	{
    		stack.push(split[0].charAt(j));
    	}
    	
    	//checks left side of string to see of equal
   		for(int j = 0; j < split[1].length(); j++)
   		{
   			if(stack.isEmpty()|| ((split[1].charAt(j)) != (stack.peek()))) {return false;} //if larger than left side
   			else {stack.pop();}
   		}
    	
    	//returns true if stack is empty at the end
    	if(stack.isEmpty()) {return true;}
    	return false;
    }

	
    public static void main(String[] args) throws FileNotFoundException {
       	Scanner fin = new Scanner(new FileReader("input.txt"));
        while (fin.hasNext()) {
            String str = fin.nextLine();
            System.out.println(str);
            System.out.println(isValidString(str));
            System.out.println();
        }
    }

	
	
}
