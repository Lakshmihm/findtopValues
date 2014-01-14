package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Lakshmi
 * Date: 13/11/2013
 * 
 * 
 */
public class TestFindTopValuesImpl
{

	FindTopValuesImpl	impl	= new FindTopValuesImpl();

	@Test
	public void testFindMaxValue() throws Exception
	{

		int[] arr = { 100, 10, 1, 2, 5, 15, 20 };

		assertEquals(100, impl.findMaxValue(arr));
	}

	@Test
	public void testFindMaxValueWithNegative() throws Exception
	{

		int[] arr = { -500, 100, 10, 1, 2, 5, 15, 20, -100, -4 };

		assertEquals(100, impl.findMaxValue(arr));
	}

	@Test
	public void testFindMaxValueWithOneElement() throws Exception
	{

		int[] arr = { 100 };

		assertEquals(100, impl.findMaxValue(arr));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindMaxValueWithNullArray() throws Exception
	{

		impl.findMaxValue(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindMaxValueWithEmptyArray() throws Exception
	{

		impl.findMaxValue(new int[0]);
	}

	@Test
	public void testFindTopNValues() throws Exception
	{

		int[] arr = { 100, 1, 2, 5, 6, 55, 95, 45, 25 };

		int[] result = { 100, 95, 55, 45, 25 };
		int[] result1 = { 100, 95, 55, 45, 25, 6, 5, 2, 1 };
		assertArrayEquals(result, impl.findTopNValues(arr, 5));
		assertArrayEquals(result1, impl.findTopNValues(arr, arr.length));

	}

	@Test
	public void testFindTopNValuesWithDups() throws Exception
	{

		int[] arr = { 100, 1, 2, 5, 6, 55, 95, 95, 25, 100, 25, 5, 1 };

		int[] result = { 100,100, 95, 95, 55 };
		assertArrayEquals(result, impl.findTopNValues(arr, 5));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindTopNValuesWithNullArray() throws Exception
	{

		impl.findTopNValues(null, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindTopNValuesWithEmptyArray() throws Exception
	{

		impl.findTopNValues(new int[0], 10);
	}

	@Test
	public void testFindTop0Values() throws Exception
	{
		int[] arr = { 100, 1, 2, 5, 6, 55, 95, 45, 25 };

		assertArrayEquals(new int[0], impl.findTopNValues(arr, 0));
	}

}
