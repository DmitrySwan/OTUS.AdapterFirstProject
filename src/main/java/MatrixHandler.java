public class MatrixHandler implements MatrixHandlerInterface{

    public int[][] sumMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int length = firstMatrix.length;
        int[][] result = new int[length][length];
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                result[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return result;
    }
}
