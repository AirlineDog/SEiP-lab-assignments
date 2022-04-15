package gradeshistogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Grades Histogram generator class.
 *
 * @author Alexios Doganis
 */
public class HistogramGenerator {

	private int[] grades;

	/**
	 * HistogramGenerator constructor
	 */
	public HistogramGenerator(String path) {
		this.grades = this.readGrades(path);
	}

	/**
	 * @param grades the grades to set
	 */
	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	/**
	 * @return the grades
	 */
	public int[] getGrades() {
		return grades;
	}

	public static void main(String[] args) {
		
		HistogramGenerator hist = new HistogramGenerator(args[0]);

		int[] freqs = new int[11];
		for (int grade : hist.getGrades()) {
			freqs[grade]++;
		}

		hist.generateHistogram(freqs);
	}

	/**
	 * Scans a file containing grades (integers) and stores them into an array.
	 *
	 * @param path the path of the grades file
	 * @return an int[] array containing the grades
	 */
	public int[] readGrades(String path) {
		Scanner in = null;
		try {
			File file = new File(path);
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Integer> grades = new ArrayList<Integer>();
		while (in.hasNextInt()) {
			grades.add(in.nextInt());
		}
		int[] gradesArray = new int[grades.size()];
		for (int i = 0; i < grades.size(); i++) {
			gradesArray[i] = grades.get(i);
		}
		return gradesArray;
	}

	/**
	 * @param freqs the chart frequencies array
	 */
	public void generateHistogram(int[] freqs) {

		XYSeriesCollection dataset = new XYSeriesCollection();

		XYSeries data = new XYSeries("Grades");
		for (int i = 0; i < freqs.length; i++) {
			data.add(i, freqs[i]);
		}

		dataset.addSeries(data);

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grades", "Frequency", dataset);

		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("Grades Chart", chart);
		frame.pack();
		// make the previously created frame visible
		frame.setVisible(true);
	}
}
