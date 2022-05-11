package math;

public class MyMath {
	public int factorial(int n) {
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException();
		}
		if (n == 0) {
			return 1;
		}

		return n * factorial(n - 1);
	}
}
