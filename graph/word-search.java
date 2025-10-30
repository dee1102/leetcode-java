class Solution {
    List<List<Integer>> direction = new ArrayList<>();
    public boolean exist(char[][] board, String word) {
        direction.add(Arrays.asList(0,1));
        direction.add(Arrays.asList(1,0));
        direction.add(Arrays.asList(0,-1));
        direction.add(Arrays.asList(-1,0));

        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    used[i][j] = true;
                    if (traverse(board, word, used, 1, i, j)) return true;
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean traverse(char[][] board, String word, boolean[][] used, int index, int x, int y) {
        // base case
        if (index == word.length()) {
            return true;
        }
        // choices
        for (List<Integer> dir: this.direction) {
            int px = dir.get(0), py = dir.get(1);
            if ((x + px > -1 && x + px < board.length) && (y + py > -1 && y + py < board[0].length) && board[x+px][y+py] == word.charAt(index) && used[x+px][y+py] == false) {
                used[x+px][y+py] = true;
                index++;
                if (traverse(board, word, used, index, x+px, y+py)) return true;
                used[x+px][y+py] = false;
                index--;
            }
        }
        return false;
    }
}