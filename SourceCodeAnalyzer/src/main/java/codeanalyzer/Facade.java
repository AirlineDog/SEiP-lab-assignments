package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.analyzers.SourceCodeAnalyzer;
import codeanalyzer.analyzers.SourceCodeAnalyzerFactory;
import codeanalyzer.exporters.MetricsExporter;
import codeanalyzer.exporters.MetricsExporterFactory;

public class Facade {

	public void analyze(String sourceCodeAnalyzerType, String sourceFileLocation, String filepath, String outputFileType, String outputFilePath) throws IOException {
		SourceCodeAnalyzerFactory srcfct = new SourceCodeAnalyzerFactory();

		SourceCodeAnalyzer analyzer = srcfct.createSourceCodeAnalyzer(sourceCodeAnalyzerType, sourceFileLocation);

		int loc = analyzer.calculateLOC(filepath);
		int nom = analyzer.calculateNOM(filepath);
		int noc = analyzer.calculateNOC(filepath);

		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",loc);
		metrics.put("nom",nom);
		metrics.put("noc",noc);

		MetricsExporterFactory expfct = new MetricsExporterFactory();
		MetricsExporter exporter = expfct.createMetricsExporter(outputFileType);
		exporter.writeFile(metrics, outputFilePath);

	}
}
