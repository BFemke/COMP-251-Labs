package Lab1;

public class Solution3 {
	
	public static int[] theMCSS(int[] A)
	{
		int maxSum = 0;
		int thisSum = 0;
		int seqStart = 0;
		int seqEnd = 0;
		
		long startTime = System.nanoTime();
		for(int i = 0, j = 0; j < A.length; j++)
		{
			thisSum += A[j];
			
			if(thisSum > maxSum)
			{
				maxSum = thisSum;
				seqStart = i;
				seqEnd = j;
			}
			else if(thisSum < 0)
			{
				i = j+1;
				thisSum = 0;
			}
		}
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		int[] seqSpan = {seqStart, seqEnd};
		return seqSpan;
	}
	
	public static void testSolution(int[] sequence)
	{
		int[] seqSpan = theMCSS(sequence);
		seqSpan = theMCSS(sequence);
		seqSpan = theMCSS(sequence);
		
		
	}
}
