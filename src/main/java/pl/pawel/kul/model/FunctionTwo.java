package pl.pawel.kul.model;


public class FunctionTwo implements GeneratingFunction{
    private final String functionGeneratingBinary;
    private final int[][] functionMatrix;

    public FunctionTwo() {
        functionGeneratingBinary="1101";
        functionMatrix = new int[][]{{1,0,1,1,1,0,0},{1,1,1,0,0,1,0},{0,1,1,1,0,0,1}};
    }

    public String getGeneratingFunction() {
        return functionGeneratingBinary;
    }

    public int[][] getMatrixFunction() {
        return functionMatrix;
    }
}
