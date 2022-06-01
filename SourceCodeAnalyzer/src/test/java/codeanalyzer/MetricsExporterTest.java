package codeanalyzer;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MetricsExporterTest {
	private MetricsExporterFactory fct = new MetricsExporterFactory();

	@Test
	public void testWriteCsv() {
		MetricsExporter mex = fct.createMetricsExporter("csv");
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);

		// generate and write the output file
		String outputFilepath = "src/test/resources/output_metrics";
		mex.writeFile(metrics, outputFilepath);

		// evaluate that the file exists
		File outputFile = new File(outputFilepath + ".csv");
		Assert.assertTrue(outputFile.exists());

		// delete the generated file
		outputFile.delete();
	}

	@Test
	public void testWriteJson() {
		MetricsExporter mockedExporter = mock(JsonMetricsExporter.class);
		// create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		String outputFilepath = "whatever-path";

		//this is a demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(mockedExporter).writeFile(metrics, outputFilepath);
		mockedExporter.writeFile(metrics, outputFilepath);
		//just verify that the method was executed/called
		verify(mockedExporter).writeFile(metrics, outputFilepath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWriteFileWithUknownFIleType() {
		MetricsExporter mex = fct.createMetricsExporter("non-existing-type");
	}

}
