package pl.pawel.kul.model;


public class FunctionOne implements GeneratingFunction{
    private final String functionGeneratingBinary;
    private final int[][] functionMatrix;

    public FunctionOne() {
        functionGeneratingBinary="1011";
        functionMatrix=new int[][]{{1,1,1,0,1,0,0},{0,1,1,1,0,1,0},{1,1,0,1,0,0,1}};
    }

    public String getGeneratingFunction() {
        return functionGeneratingBinary;
    }

    public int[][] getMatrixFunction() {
        return functionMatrix;
    }
}
