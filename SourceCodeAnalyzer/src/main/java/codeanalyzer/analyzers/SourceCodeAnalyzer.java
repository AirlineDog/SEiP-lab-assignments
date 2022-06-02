package codeanalyzer.analyzers;

import java.io.IOException;

/**
 * Analyzes the contents of a Java source code file
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes.
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and
 * strcomp (with the use of string comparison).
 */
public interface SourceCodeAnalyzer {
	public int calculateLOC(String filepath) throws IOException;
	public int calculateNOM(String filepath) throws IOException;
	public int calculateNOC(String filepath) throws IOException;
}
