package math;

import org.junit.Assert;
import org.junit.Test;


public class MyMathTest {
	MyMath mm = new MyMath();

	@Test (expected = IllegalArgumentException.class)
	public void test_factorial_less_than_zero() {
		mm.factorial(-1);
	}

	@Test
	public void test_factorial_zero() {
		Assert.assertEquals(1, mm.factorial(0));
	}

	@Test
	public void test_factorial_one() {
		Assert.assertEquals(1, mm.factorial(1));
	}

	@Test
	public void test_factorial_two() {
		Assert.assertEquals(2, mm.factorial(2));
	}

	@Test
	public void test_factorial_less_than_12() {
		Assert.assertEquals(720, mm.factorial(6));
	}

	@Test
	public void test_factorial_12() {
		Assert.assertEquals(479001600, mm.factorial(12));
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_factorial_more_than_12() {
		mm.factorial(13);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_isPrime_negative() {
		mm.isPrime(-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_isPrime_0() {
		mm.isPrime(0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_isPrime_1() {
		mm.isPrime(1);
	}

	@Test
	public void test_isPrime_2() {
		Assert.assertTrue(mm.isPrime(2));
	}

	@Test
	public void test_isPrime_false_positive() {
		Assert.assertFalse(mm.isPrime(74));
	}

	@Test
	public void test_isPrime_true_positive() {
		Assert.assertTrue(mm.isPrime(241));
	}
}
