package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
	ArithmeticOperations arop = new ArithmeticOperations();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test_division_with_positive() {
		Assert.assertEquals(5.0, arop.divide(10, 2), 0);
	}

	@Test
	public void test_division_with_negative() {
		Assert.assertEquals(-5.0, arop.divide(10, -2), 0);
	}

	@Test (expected = ArithmeticException.class)
	public void test_division_with_zero() {
		arop.divide(10, 0);
	}

	@Test
	public void test_multiply_with_x_zero() {
		Assert.assertEquals(0, arop.multiply(0, 10), 0);
	}

	@Test
	public void test_multiply_with_y_zero() {
		Assert.assertEquals(0, arop.multiply(10, 0), 0);
	}

	@Test
	public void test_multiply_with_both_zero() {
		Assert.assertEquals(0, arop.multiply(0, 0), 0);
	}

	@Test
	public void test_multiply_with_small_positives() {
		Assert.assertEquals(50, arop.multiply(10, 5), 0);
	}

	@Test
	public void test_multiply_with_big_positives() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		arop.multiply(Integer.MAX_VALUE / 2 + 1, 2);
	}

	@Test
	public void test_multiply_with_x_negative() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		arop.multiply(10, -5);
	}

	@Test
	public void test_multiply_with_y_negative() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		arop.multiply(-10, 5);
	}

	@Test
	public void test_multiply_with_both_negative() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		arop.multiply(-10, -5);
	}

}
