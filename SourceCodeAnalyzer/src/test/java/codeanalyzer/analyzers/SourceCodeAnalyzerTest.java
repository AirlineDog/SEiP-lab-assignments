package codeanalyzer.analyzers;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class SourceCodeAnalyzerTest {
	private static List<String> testSourceCode;
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TYPE_LOCAL = "local";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private SourceCodeAnalyzerFactory fct = new SourceCodeAnalyzerFactory();


	@Test
	public void testCalculateRegexLOC() throws IOException {
		SourceCodeAnalyzer sca = fct.createSourceCodeAnalyzer(TYPE_REGEX, TYPE_LOCAL);
		assertEquals(21, sca.calculateLOC(TEST_CLASS));
	}

	@Test
	public void testCalculateStrCompLOC() throws IOException {
		SourceCodeAnalyzer sca = fct.createSourceCodeAnalyzer(TYPE_STRCOMP, TYPE_LOCAL);
		assertEquals(7, sca.calculateLOC(TEST_CLASS));
	}

	@Test
	public void testCalculateRegexNOM() throws IOException {
		SourceCodeAnalyzer sca = fct.createSourceCodeAnalyzer(TYPE_REGEX, TYPE_LOCAL);
		assertEquals(3, sca.calculateNOM(TEST_CLASS));
	}

	@Test
	public void testCalculateStrCompNOM() throws IOException {
		SourceCodeAnalyzer sca = fct.createSourceCodeAnalyzer(TYPE_STRCOMP, TYPE_LOCAL);
		assertEquals(3, sca.calculateNOM(TEST_CLASS));
	}

	@Test
	public void testCalculateRegexNOC() throws IOException {
		SourceCodeAnalyzer sca = fct.createSourceCodeAnalyzer(TYPE_REGEX, TYPE_LOCAL);
		assertEquals(3, sca.calculateNOC(TEST_CLASS));
	}

	@Test
	public void testCalculateStrCompNOC() throws IOException {
		SourceCodeAnalyzer sca = fct.createSourceCodeAnalyzer(TYPE_STRCOMP, TYPE_LOCAL);
		assertEquals(3, sca.calculateNOC(TEST_CLASS));
	}

}
