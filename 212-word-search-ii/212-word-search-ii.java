class Solution {
    public class Trie {
        private final int a = 'a';
        public String word;
        private Trie[] children;
        private int size;
        public Trie() {
            this.children = new Trie[26];
        }
        public boolean contains(char x) {
            return this.children[x - a] != null;
        }
        public Trie get(char x) {
            int i = x - a;
            if (this.children[i] == null) {
                this.children[i]  = new Trie();
                size++;
            }
            return this.children[i];
        }
        public void remove(char x) {
            int i = x - a;
            if (this.children[i] != null) {
                this.children[i] = null;
                size--;
            }            
        }
        public boolean isEmpty() {
            return size == 0;
        }
    }
    private Trie root;
    private char[][] board;
    private List<String> result;
    private boolean[][] visited;
    private int m;
    private int n;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.result = new LinkedList<>();
        this.root = new Trie();
        this.m = board.length;
        this.n = board[0].length;
        
        for (String s: words) {
            Trie c = root;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                c = c.get(arr[i]);
                if (i == arr.length - 1) {
                    c.word = s;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.contains(board[i][j])) {
                    visited = new boolean[m][n];
                    if (dfs(root, i, j)) {
                        root.remove(board[i][j]);
                    }
                    if (root.isEmpty()) return result;
                }
            }
        }
        return result;
    }
    
    private boolean dfs(Trie c, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) return false;       
        if (!c.contains(board[x][y])) {
            return false;
        }
        visited[x][y] = true;
        c = c.get(board[x][y]);
        if (c.word != null) {
            result.add(c.word);
            c.word = null;
        }
        boolean top = dfs(c, x - 1, y);
        if (top) {
            c.remove(board[x - 1][y]);
        }
        boolean bottom = dfs(c, x + 1, y);
        if (bottom) {
            c.remove(board[x + 1][y]);
        }
        boolean left = dfs(c, x, y - 1);
        if (left) {
            c.remove(board[x][y - 1]);
        }
        boolean right = dfs(c, x, y + 1);
        if (right) {
            c.remove(board[x][y + 1]);
        }
        visited[x][y] = false;
        return c.isEmpty();
    }
}