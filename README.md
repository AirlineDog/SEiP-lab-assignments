# SEiP-lab-assignments 2022

This repository is used for the Software Eningineering in Practice (SEiP) course taught in Athens University of Economics and Business Department of Management Science & Technology.

## Modules
- [Histogram Generator](./gradeshistogram/) Takes a grades txt file and generates a histogram
- [JUnit Test](./unittesting/) Implements some arithmetic functions and includes various test cases and techniques
- [Source Code Analyzer](./SourceCodeAnalyzer/) Reads a Java source code file that is stored locally or on the web, calculates the Lines of Code (LOC), Number of Classes (NOC), and Number of Methods (NOM) metrics, and finally, exports  these metrics to an output file

## Required Tools

- Java JDK <a href="https://www.oracle.com/java/technologies/downloads/">version 1.8</a> (or later)  
- Maven <a href="https://maven.apache.org/what-is-maven.html">3.6</a> (or later)

## How to Built and Run

1. Download the required tools
2. Clone this repository (or your Fork)
3. Run ```mvn package```
4. Run ```java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar path_to_your_txt_file```
