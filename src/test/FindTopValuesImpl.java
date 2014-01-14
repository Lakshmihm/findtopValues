package test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lakshmi
 * Date: 13/11/2013
 *
 * 
 */
public class FindTopValuesImpl implements FindTopValues
{
	@Override
	public int findMaxValue(int[] anyOldOrderValues)
	{

		if (anyOldOrderValues == null || anyOldOrderValues.length == 0) throw new IllegalArgumentException("Empty Array!");

		int max = anyOldOrderValues[0];

		//Linear complexity of O(n)
		for (int i = 1; i < anyOldOrderValues.length; i++)
		{
			if (anyOldOrderValues[i] > max)
			{
				max = anyOldOrderValues[i];
			}
		}
		return max;
	}

	@Override
	public int[] findTopNValues(int[] anyOldOrderValues, int n)
	{

		//better to use Java's priority queue rather than implementing a new heap based Data Structure
		if (anyOldOrderValues == null || anyOldOrderValues.length == 0) throw new IllegalArgumentException("Empty array!");
		
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(anyOldOrderValues.length, Collections.reverseOrder());

		for (int i = 0; i < anyOldOrderValues.length; i++)
		{
			p.add(anyOldOrderValues[i]);
		}

		int[] result = new int[n];
		for (int i = 0; i < n; i++)
		{
			result[i] = p.poll();
		}
		return result;
	}
}
