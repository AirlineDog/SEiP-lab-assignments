package math;

public class MyMath {
	/**
	 * Calculate the factorial of n
	 * @param n
	 * @return the factorial of n
	 */
	public int factorial(int n) {
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException();
		}
		if (n == 0) {
			return 1;
		}

		return n * factorial(n - 1);
	}

	/**
	 * Check if n is prime
	 * @param n
	 * @return true if n is prime else false
	 */
	public boolean isPrime(int n) {
		if (n < 2) {
			throw new IllegalArgumentException();
		}
		int i = 2;
		while (i * i < n) {
			if (n % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}
}
