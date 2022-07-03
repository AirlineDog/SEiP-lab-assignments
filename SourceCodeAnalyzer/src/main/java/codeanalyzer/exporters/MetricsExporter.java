package codeanalyzer.exporters;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given output.
 */
public interface MetricsExporter {
	/**
	 * Writes the metrics into a file
	 * @param metrics The calculated metrics
	 * @param filepath The path to the specified file
	 */
	public void writeFile(Map<String, Integer> metrics, String filepath);
}
