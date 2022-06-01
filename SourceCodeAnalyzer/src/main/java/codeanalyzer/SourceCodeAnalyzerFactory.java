package codeanalyzer;

public class SourceCodeAnalyzerFactory {
	public SourceCodeAnalyzer createSourceCodeAnalyzer(String sourceCodeAnalyzerType, String sourceFileLocation) {
		SourceCodeAnalyzer analyzer;
		if (sourceCodeAnalyzerType.equals("regex")) {
			analyzer = new RegexSourceCodeAnalyzer(sourceFileLocation);
		}else if (sourceCodeAnalyzerType.equals("strcomp")) {
			analyzer = new StrcompSourceCodeAnalyzer(sourceFileLocation);
		}else {
			throw new IllegalArgumentException();
		}
		return analyzer;
	}
}
