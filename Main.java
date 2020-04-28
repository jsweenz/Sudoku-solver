public class Main {

    public static void main(String args[]){
        Sudoku.printGrid();
        Sudoku.solve();
        System.out.println();
        System.out.println("solved grid");
        Sudoku.printGrid();
    }
}
