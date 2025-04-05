class Solution {
    // Function to check if it's safe to place a queen at board[row][col]
    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check row on the left side
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Check column on the upper side
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal (north-west)
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check upper right diagonal (north-east)
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check lower left diagonal (south-west)
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check lower right diagonal (south-east)
        for (int i = row, j = col; i < n && j < n; i++, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Recursive function to solve N Queens
    private void nqueen(char[][] board, int row, List<List<String>> ans) {
        int n = board.length;
        if (row == n) {
            // Base case: when all queens are placed, convert board to string format
            List<String> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    str.append(board[i][j]);
                }
                l.add(str.toString());
            }
            ans.add(l);
            return;
        }

        // Try placing queen in all columns one by one
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // Place queen
                nqueen(board, row + 1, ans); // Recur to place rest of queens
                board[row][j] = '.'; // Backtrack
            }
        }
    }

    // Main function to solve N Queens problem
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        nqueen(board, 0, ans);
        return ans;
    }
}
