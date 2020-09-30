import java.io.FileNotFoundException;

class Adapter {

    public static void main(String[] args) throws FileNotFoundException {
        FileHandlerInterface fileHandler = AdapterCommandLineParser.parseCMDArgs(args);
        new Adapter().sumMatrices(fileHandler);
    }

    public void sumMatrices(FileHandlerInterface fileHandler) throws FileNotFoundException {
        int[][] firstMatrix = fileHandler.readMatrixFromFile();
        int[][] secondMatrix = fileHandler.readMatrixFromFile();
        fileHandler.printToOutputFile(new MatrixHandler().sumMatrices(firstMatrix, secondMatrix));
    }
}
