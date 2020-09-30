import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class FileHandler implements FileHandlerInterface{

    private static Logger log = Logger.getLogger(FileHandler.class);

    private File inputFile;
    private File outputFile;
    private Scanner scanner;
    private int dimension;


    FileHandler(File inputFile, File outputFile) throws FileNotFoundException {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        initScanner();
        this.dimension = scanner.nextInt();

    }

    private void initScanner() throws FileNotFoundException {
        scanner = new Scanner(inputFile);
    }

    public int[][] readMatrixFromFile()  {
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public void printToOutputFile(int[][] matrix) {
        try (FileWriter fw = new FileWriter(outputFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (int j = 0; j < dimension; j++) {
                bw.write(matrix[dimension][dimension]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
