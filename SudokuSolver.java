public class SudokuSolver {

    // Function to check if placing num is valid at board[row][col]
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row and column
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num || board[x][col] == num)
                return false;
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num)
                    return false;
            }
        }
        return true;
    }

    // Recursive backtracking function
    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find empty cell (0 represents empty)
                if (board[row][col] == 0) {
                    // Try numbers 1 to 9
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursively try to fill the rest
                            if (solveSudoku(board))
                                return true;

                            // Backtrack
                            board[row][col] = 0;
                        }
                    }
                    // No valid number found
                    return false;
                }
            }
        }
        // No empty cell left – puzzle solved
        return true;
    }

    // Function to print Sudoku board
    private static void printBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0 && r != 0)
                System.out.println("------+-------+------");
            for (int d = 0; d < 9; d++) {
                if (d % 3 == 0 && d != 0)
                    System.out.print("| ");
                System.out.print(board[r][d] == 0 ? ". " : board[r][d] + " ");
            }
            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("Original Sudoku:");
        printBoard(board);

        if (solveSudoku(board)) {
            System.out.println("\nSolved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists!");
        }
    }
}
