package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.CsvMetricsExporter;
import codeanalyzer.JsonMetricsExporter;
import codeanalyzer.MetricsExporter;
import codeanalyzer.RegexSourceCodeAnalyzer;
import codeanalyzer.SourceCodeAnalyzer;
import codeanalyzer.StrcompSourceCodeAnalyzer;

public class DemoClient {

	public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";

		if(args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}
		SourceCodeAnalyzer analyzer = null;
		if (sourceCodeAnalyzerType.equals("regex")) {
			analyzer = new RegexSourceCodeAnalyzer(sourceFileLocation);

		}else if (sourceCodeAnalyzerType.equals("strcomp")) {
			analyzer = new StrcompSourceCodeAnalyzer(sourceFileLocation);

		}else {
			System.out.println("Incorrect argument 2 [regex|strcomp].");
			System.exit(1);
		}
		int loc = analyzer.calculateLOC(filepath);
		int nom = analyzer.calculateNOM(filepath);
		int noc = analyzer.calculateNOC(filepath);

		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",loc);
		metrics.put("nom",nom);
		metrics.put("noc",noc);


		MetricsExporter exporter = null;
		if (outputFileType.equals("csv")) {
			exporter = new CsvMetricsExporter();
		} else if (outputFileType.equals("json")) {
			exporter = new JsonMetricsExporter();
		} else {
			System.out.println("Incorrect argument 4 [csv|json].");
			System.exit(1);
		}
		exporter.writeFile(metrics, outputFilePath);

	}

}
