package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

public class ArrayOperations {

	/**
	 * Read a file with numbers and return an array with only the prime numbers
	 *
	 * @param fileIo A FileIo object
	 * @param filepath path to the numbers file
	 * @param myMath A MyMath object
	 * @return An array containing only primes
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		List<Integer> ret = new ArrayList<Integer>();
		for (int x : fileIo.readFile(filepath)) {
			if (myMath.isPrime(x)) {
				ret.add(x);
			}
		}
		return ret.stream().mapToInt(i -> i).toArray();
	}
}
