package math;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;

public class ArrayOperationsTest {
	public ArrayOperations ao = new ArrayOperations();

	@Test
	public void test_findPrimesInFile_normal() {
		String path = "path";
		FileIO f = mock(FileIO.class);
		when(f.readFile(path)).thenReturn(new int[] { 2, 3, 4, 5, 6 });
		MyMath mm = mock(MyMath.class);
		when(mm.isPrime(2)).thenReturn(true);
		when(mm.isPrime(3)).thenReturn(true);
		when(mm.isPrime(4)).thenReturn(false);
		when(mm.isPrime(5)).thenReturn(true);
		when(mm.isPrime(6)).thenReturn(false);

		Assert.assertArrayEquals(new int[] { 2, 3, 5 }, ao.findPrimesInFile(f, path, mm));
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_findPrimesInFile_negatives_and_positives() {
		String path = "path";
		FileIO f = mock(FileIO.class);
		when(f.readFile(path)).thenReturn(new int[] { 1, 2, 3, 4, 5, 6 });
		MyMath mm = mock(MyMath.class);
		when(mm.isPrime(1)).thenThrow(IllegalArgumentException.class);
		when(mm.isPrime(2)).thenReturn(true);
		when(mm.isPrime(3)).thenReturn(true);
		when(mm.isPrime(4)).thenReturn(false);
		when(mm.isPrime(5)).thenReturn(true);
		when(mm.isPrime(6)).thenReturn(false);

		ao.findPrimesInFile(f, path, mm);
	}

}
