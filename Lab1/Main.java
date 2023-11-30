package Lab1;

import java.security.SecureRandom;

public class Main {

	public static void main(String args[])
	{
		SecureRandom ranNum = new SecureRandom();
		
		int numInput = 100;
		int[] sequence = new int[numInput];
		
		for(int i = 0; i < numInput; i++)
		{
			sequence[i] = (ranNum.nextInt(60))-30;
		}
		
		Solution1.testSolution(sequence);
		System.out.println();
		Solution2.testSolution(sequence);
		System.out.println();
		Solution3.testSolution(sequence);
		System.out.println();
	}
}
