public class Sudoku {
    private static int[][] sudokuIn =
            {{0,4,0,0,0,0,6,0,0},
            {2,0,0,1,0,0,4,3,0},
            {0,0,8,2,6,4,5,0,9},
            {0,0,0,6,2,0,0,0,0},
            {0,6,3,0,0,0,7,8,0},
            {0,0,0,0,3,7,0,0,0},
            {6,0,9,5,4,2,8,0,0},
            {0,2,7,0,0,9,0,0,6},
            {0,0,1,0,0,0,0,9,0}};
    private static int[] cords = new int[2];


    //Prints out the Sudoku grid to the terminal when the GUI is not being used
    public static void printGrid(){
        for(int i = 0; i < sudokuIn.length; i++ ){
            if((i % 3 == 0) && (i != 0)){
                System.out.println("---------------------");
            }
            for(int j = 0; j < sudokuIn[0].length; j++){
                if((j % 3 == 0) && (j != 0)){
                    System.out.print("| ");
                }
                System.out.print(sudokuIn[i][j] + " ");
            }
            System.out.println();
        }
    }
    //returns the sudoku to use for the GUI grid
    public static int[][] getSudokuIn() {
        return sudokuIn;
    }

    //checks if the number is a valid number to put in the space
    public static boolean isNumValid(int num){
        //makes sure the number is not already in that space
        if(num == sudokuIn[cords[0]][cords[1]]){
            return false;
        }
        //check if the number is in the row
        for(int i = 0; i < sudokuIn[0].length; i++){
            if((sudokuIn[cords[0]][i] == num) && (i != cords[1])){
                return false;
            }
        }
        //checks if the number is in the same col
        for(int i = 0; i < sudokuIn.length; i++){
            if((sudokuIn[i][cords[1]] == num) && (i != cords[0])){
                return false;
            }
        }
        //checks to see if the number is in the 3x3
        int r = cords[0] - cords[0] % 3;
        int c = cords[1] - cords[1] % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (sudokuIn[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    //uses the backtracking method and recursion to solve the sudoku
    public static boolean solve()
    {
        //finds empty space
        for(int row = 0; row < 9; row++)
        {
            for(int col = 0; col < 9; col++)
            {
                if(sudokuIn[row][col] == 0)
                {
                    for(int number = 1; number <= 9; number++)
                    {
                        cords[0] = row;
                        cords[1] = col;
                        if(isNumValid(number))
                        {
                            sudokuIn[row][col] = number;
                            if(solve())
                            {
                                return true;
                            }
                            else
                            {
                                sudokuIn[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}

