import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;

class FileHandler implements FileHandlerInterface {

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

    public int[][] readMatrixFromFile() {
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        log.info("#readMatrixFromFile \n" + matrixToString(matrix));
        return matrix;
    }

    public void printToOutputFile(int[][] matrix) {
        log.info("#printToOutputFile \n" + matrixToString(matrix));
        try (FileWriter fw = new FileWriter(outputFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (int[] aMatrix : matrix) {
                for (int anAMatrix : aMatrix) {
                    out.print(anAMatrix + " ");
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String matrixToString(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                result.append(" ").append(anInt);
            }
            result.append("\n");
        }
        return result.toString();
    }
}
