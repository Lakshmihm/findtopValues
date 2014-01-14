package test;
/**
 * This class does a benchmark test
 * @author lmadhavarao
 *
 */
public class BenchMarkFindTopValuesImpl
{

	private static final int	RUNS	= 10000000;

	public static void main(String[] args)
	{
		FindTopValuesImpl findTopValuesImpl = new FindTopValuesImpl();
		int testArr[] = new int[50];//create a random test array
		for (int i = 0; i < testArr.length; i++)
		{
			testArr[i] = (int) (Math.random() * 55);
		}

		System.out.println("\n\n---------------\nStarting\n---------------");
		benchmarkFindMax(findTopValuesImpl, testArr);
		benchmarkfindTopNValues(findTopValuesImpl, testArr, 10);
		benchmarkfindTopNValues(findTopValuesImpl, testArr, 15);
	}

	private static void benchmarkFindMax(FindTopValues topValues, int testArr[])
	{

		System.out.println("\n\n---------------Warm up for findMax\n---------------");
		for (int i = 0; i < 1000; i++)
		{
			topValues.findMaxValue(testArr);
		}

		System.out.println("\n\n---------------Benchmarking for findMax\n---------------");
		final long start = System.currentTimeMillis();

		for (int i = 0; i < RUNS; i++)
		{

			topValues.findMaxValue(testArr);
		}

		final float dt = System.currentTimeMillis() - start;
		System.out.println("findMaxValue : " + dt + " ms, " + (dt / RUNS) + "ms per run");
	}

	private static void benchmarkfindTopNValues(FindTopValues topValues, int testArr[], int n)
	{

		System.out.format("\n\n---------------Warm up for findTopNValues\n finding top  %d---------------", n);
		for (int i = 0; i < 1000; i++)
		{
			topValues.findTopNValues(testArr, n);
		}

		System.out.format("\n\n---------------Benchmarking for findTopNValues\n finding top %d---------------", n);
		final long start = System.currentTimeMillis();

		for (int i = 0; i < RUNS; i++)
		{

			topValues.findTopNValues(testArr, n);
		}

		final float dt = System.currentTimeMillis() - start;
		System.out.println("findTopNValues : " + dt + " ms, " + (dt / RUNS) + "ms per run");
	}
}
