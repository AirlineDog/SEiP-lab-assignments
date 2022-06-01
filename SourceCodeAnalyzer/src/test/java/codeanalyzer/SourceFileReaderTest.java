package codeanalyzer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class SourceFileReaderTest {
	private static List<String> expectedList;
	private static String expectedString;
	private final static String TYPE_WEB = "web";
	private final static String TYPE_LOCAL = "local";
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private SourceFileReaderFactory fct = new SourceFileReaderFactory();

	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter)
	}

	@Test
	public void testReadFileIntoListLocal() throws IOException {
		//read a locally stored file into a List
		SourceFileReader sfr = fct.createSourceFileReader(TYPE_LOCAL);
		List<String> actualList = sfr.readFileIntoList(TEST_CLASS_LOCAL);

		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testReadFileIntoStringLocal() throws IOException {
		//read a locally stored file into a String
		SourceFileReader sfr = fct.createSourceFileReader(TYPE_LOCAL);
		String actuals = sfr.readFileIntoString(TEST_CLASS_LOCAL);

		assertEquals(expectedString, actuals);
	}

	@Test
	public void testReadFileIntoListWeb() throws IOException {
		//read a file stored in the web into a List
		SourceFileReader sfr = fct.createSourceFileReader(TYPE_WEB);
		List<String> actualList = sfr.readFileIntoList(TEST_CLASS_WEB);

		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testReadFileIntoStringWeb() throws IOException {
		//read a file stored in the web into a String
		SourceFileReader sfr = fct.createSourceFileReader(TYPE_WEB);
		String actuals = sfr.readFileIntoString(TEST_CLASS_WEB);

		assertEquals(expectedString, actuals);
	}

	@Test
	public void testReadFileIntoListNull() throws IOException {
		//give a none existing type to cause a null List return
		SourceFileReader sfr = fct.createSourceFileReader("non-existing-type");
		List<String> actualList = sfr.readFileIntoList("any-filepath");

		assertNull(actualList);
	}

	@Test
	public void testReadFileIntoStringNull() throws IOException {
		//give a none existing type to cause a null String return
		SourceFileReader sfr = fct.createSourceFileReader("non-existing-type");
		String actualString = sfr.readFileIntoString("any-filepath");

		assertNull(actualString);
	}
}
