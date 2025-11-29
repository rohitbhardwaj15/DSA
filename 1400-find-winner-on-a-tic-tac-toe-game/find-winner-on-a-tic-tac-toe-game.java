class Solution {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0, antiDiag = 0;

        int player = 1;

        for (int[] move : moves) {
            int r = move[0];
            int c = move[1];

            rows[r] += player;
            cols[c] += player;
            if (r == c) diag += player;
            if (r + c == 2) antiDiag += player;

            if (Math.abs(rows[r]) == 3 ||
                Math.abs(cols[c]) == 3 ||
                Math.abs(diag) == 3 ||
                Math.abs(antiDiag) == 3) {
                
                return player == 1 ? "A" : "B";
            }
           
            player *= -1;
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
