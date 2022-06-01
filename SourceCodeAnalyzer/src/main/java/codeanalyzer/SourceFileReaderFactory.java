package codeanalyzer;

public class SourceFileReaderFactory {

	public SourceFileReader createSourceFileReader(String type) {
		SourceFileReader reader;
		if (type.equals("local")) {
			reader = new LocalSourceFileReader();
		}else if (type.equals("web")) {
			reader = new WebSourceFileReader();
		}else {
			return new NullSourceFileReader();
		}
		return reader;
	}
}
