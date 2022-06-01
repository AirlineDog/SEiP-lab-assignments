package codeanalyzer;

public class SourceCodeAnalyzerFactory {
	public SourceCodeAnalyzer createSourceCodeAnalyzer(String type) {
		SourceCodeAnalyzer analyzer;
		if (type.equals("regex")) {
			analyzer = new RegexSourceCodeAnalyzer(type);
		}else if (type.equals("strcomp")) {
			analyzer = new StrcompSourceCodeAnalyzer(type);
		}else {
			throw new IllegalArgumentException();
		}
		return analyzer;
	}
}
