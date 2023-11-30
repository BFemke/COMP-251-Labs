package Lab1;

public class Solution1 {
	
	public static int[] theMCSS(int[]A)
	{
		int maxSum = 0;
		int seqStart  = 0;
		int seqEnd = 0;
		
		long startTime = System.nanoTime();
		for(int i = 0; i < A.length; i++)
		{
			for(int j = i; j < A.length; j++)
			{
				int thisSum = 0;
				
				for(int k = i; k <= j;k++)
				{
					thisSum += A[k];
				}
				
				if(thisSum > maxSum)
				{
					maxSum = thisSum;
					seqStart = i;
					seqEnd = j;
				}
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
