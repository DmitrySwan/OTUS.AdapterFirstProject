import java.io.FileNotFoundException;

public interface FileHandlerInterface {
    int[][] readMatrixFromFile() throws FileNotFoundException;

    void printToOutputFile(int[][] sumMatrices);
}
