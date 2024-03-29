package codeanalyzer.readers;

import java.io.IOException;
import java.util.List;

/**
 * Retrieves (reads) the contents of a given file.
 */
public interface SourceFileReader {
	/**
	 * Reads a file and returns its content in a List
	 *
	 * @param fileReaderType the location of a file (<b>local</b> for locally stored
	 *                       files, <b>web</b> for files stored on the web).
	 * @param filepath       the url of the file
	 * @return a List that contains the contents of the file or null if the type is
	 *         neither <b>local</b> nor <b>web</b>
	 * @throws IOException
	 */
	public List<String> readFileIntoList(String filepath) throws IOException;

	/**
	 * Reads a file and returns its content in a single String
	 *
	 * @param fileReaderType the location of a file (<b>local</b> for locally stored
	 *                       files, <b>web</b> for files stored on the web).
	 * @param filepath       the url of the file
	 * @return a String that contains the contents of the file or null if the type
	 *         is neither <b>local</b> nor <b>web</b>
	 * @throws IOException
	 */
	public String readFileIntoString(String filepath) throws IOException;

}
