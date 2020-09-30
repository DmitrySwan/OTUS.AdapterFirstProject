import org.apache.commons.cli.CommandLine;

import java.io.File;
import java.io.FileNotFoundException;

class Adapter {

    public static void main(String[] args) throws FileNotFoundException {
        CommandLine cl = AdapterCommandLineParser.parseCMDArgs(args);
        File inputFile = new File(cl.getOptionValue(AdapterCommandLineParser.INPUT));
        File outputFile = new File(cl.getOptionValue(AdapterCommandLineParser.OUTPUT));
        new Adapter().sumMatrices(inputFile, outputFile);
    }

    public void sumMatrices(File inputFile, File outputFile) throws FileNotFoundException {
        FileHandlerInterface fileHandler = new FileHandler(inputFile, outputFile);
        int[][] firstMatrix = fileHandler.readMatrixFromFile();
        int[][] secondMatrix = fileHandler.readMatrixFromFile();
        fileHandler.printToOutputFile(new MatrixHandler().sumMatrices(firstMatrix, secondMatrix));
    }
}
