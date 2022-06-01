package codeanalyzer;

public class MetricsExporterFactory {
	public MetricsExporter createMetricsExporter(String type) {
		MetricsExporter exporter;
		if (type.equals("csv")) {
			exporter = new CsvMetricsExporter();
		}else if (type.equals("json")) {
			exporter = new JsonMetricsExporter();
		}else {
			throw new IllegalArgumentException();
		}
		return exporter;
	}
}
