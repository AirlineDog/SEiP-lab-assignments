package codeanalyzer.analyzers;

import java.io.IOException;
import java.util.List;

import codeanalyzer.readers.SourceFileReader;
import codeanalyzer.readers.SourceFileReaderFactory;

/**
 * Analyzes the contents of a Java source code file and calculates the following
 * metrics: loc = lines of code, nom = number of methods, and noc=number of
 * classes. This class supports strcomp source code analysis, (with the use of
 * string comparison)
 *
 */
public class StrcompSourceCodeAnalyzer implements SourceCodeAnalyzer {

	private SourceFileReader fileReader;

	public StrcompSourceCodeAnalyzer(String fileReaderType) {
		SourceFileReaderFactory fct = new SourceFileReaderFactory();
		this.fileReader = fct.createSourceFileReader(fileReaderType);
	}

	@Override
	public int calculateLOC(String filepath) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int nonCodeLinesCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); // clear all leading and trailing white spaces
			if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{")
					|| line.equals("}") || line.equals(""))
				nonCodeLinesCounter++;
		}
		int loc = sourceCodeList.size() - nonCodeLinesCounter;
		return loc;
	}

	@Override
	public int calculateNOM(String filepath) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int methodCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); // clear all leading and trailing white spaces
			if (((line.contains("public") || line.contains("private") || line.contains("protected"))
					|| line.contains("void") || line.contains("int") || line.contains("String")) && line.contains("(")
					&& line.contains(")") && line.contains("{"))
				methodCounter++;
		}
		return methodCounter;
	}

	@Override
	public int calculateNOC(String filepath) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int classCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); // remove leading and trailing white spaces
			if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
				classCounter++;
			}
		}
		return classCounter;
	}

}
