package codeanalyzer.readers;

import java.io.IOException;
import java.util.List;

/**
 * Retrieves (reads) the contents of a given file.
 * This class will return null.
 */
public class NullSourceFileReader implements SourceFileReader {

	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		return null;
	}

	@Override
	public String readFileIntoString(String filepath) throws IOException {
		return null;
	}

}
