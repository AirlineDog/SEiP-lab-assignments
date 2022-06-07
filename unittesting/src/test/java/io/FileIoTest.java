package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class FileIoTest {
	public FileIO f = new FileIO();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test_normal() {
		Assert.assertArrayEquals(new int[] {1,2,3,4,5,6}, f.readFile("src/test/resources/NormalTest.txt"));
	}

	@Test
	public void test_non_existing_file() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		f.readFile("src/test/resources/Nothing");
	}

	@Test
	public void test_empty_file() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		f.readFile("src/test/resources/Empty.txt");
	}

	@Test
	public void testReadFileContainsInvalidEntries() {
		Assert.assertArrayEquals(new int[] {1,2,3,4,5,6}, f.readFile("src/test/resources/Invalid.txt"));
	}
}
