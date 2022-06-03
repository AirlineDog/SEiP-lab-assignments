package codeanalyzer.analyzers;

import java.io.IOException;

/**
 * Analyzes the contents of a Java source code file
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes.
 */
public interface SourceCodeAnalyzer {

	/**
	 * @param filepath The path to the specified file
	 * @return Lines of code
	 * @throws IOException
	 */
	public int calculateLOC(String filepath) throws IOException;
	/**
	 * @param filepath The path to the specified file
	 * @return Number of methods
	 * @throws IOException
	 */
	public int calculateNOM(String filepath) throws IOException;
	/**
	 * @param filepath The path to the specified file
	 * @return Number of classes
	 * @throws IOException
	 */
	public int calculateNOC(String filepath) throws IOException;
}
