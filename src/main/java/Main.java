import org.apache.commons.cli.CommandLine;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static FileHandlerInterface configureApplication(CommandLine cl) throws FileNotFoundException {
        File inputFile = new File(cl.getOptionValue(AdapterCommandLineParser.INPUT));
        File outputFile = new File(cl.getOptionValue(AdapterCommandLineParser.OUTPUT));
        return new FileHandler(inputFile,outputFile);
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileHandlerInterface fileHandler = configureApplication(AdapterCommandLineParser.parseCMDArgs(args));
        int[][] firstMatrix = fileHandler.readMatrixFromFile();
        int[][] secondMatrix = fileHandler.readMatrixFromFile();
        fileHandler.printToOutputFile(new MatrixHandler().sumMatrices(firstMatrix, secondMatrix));
    }
}
